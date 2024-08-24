package com.codewithprem.dao;

import com.codewithprem.DbConnection;
import com.codewithprem.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void insertUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name,email) VALUES (?,?)";

        Connection conn = DbConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        Connection conn = DbConnection.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            User user = new User(id, name, email);
            users.add(user);
        }

        return users;
    }
}
