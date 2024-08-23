package com.codewithprem;

import com.codewithprem.dao.UserDAO;
import com.codewithprem.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User newUser = new User(name, email);

        try {
            userDAO.createUser(newUser);
            resp.sendRedirect("index.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
