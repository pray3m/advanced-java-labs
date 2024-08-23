package com.codewithprem.dao;

import com.codewithprem.DbConnection;
import com.codewithprem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (name,email) VALUES (?,?)";

        Connection conn = DbConnection.getConnection();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.executeUpdate();
    }
}
