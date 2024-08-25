<%@ page import="java.util.List" %>
<%@ page import="com.codewithprem.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<center>
    <h1> User Management
    </h1>

    <h3>
        <a href="${pageContext.request.contextPath}/new">Add a new user </a>
    </h3>

    <h3>
        <a href="${pageContext.request.contextPath}/list">List of users</a>
    </h3>
</center>
</body>
</html>