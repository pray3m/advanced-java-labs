package com.codewithprem;

import com.codewithprem.dao.UserDAO;
import com.codewithprem.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet method called");

        String action = req.getServletPath();

        try {

            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;

                case "/insert":
                    insertUser(req, resp);
                    break;

                default:
                    listUser(req, resp);
                    break;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("show new form");
        RequestDispatcher dispatcher = req.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        System.out.println("Insert user");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        User newUser = new User(name, email);

        userDAO.insertUser(newUser);
        resp.sendRedirect("list");
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        System.out.println("List user");
        List<User> users = userDAO.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("user-list.jsp").forward(req, resp);
    }
}
