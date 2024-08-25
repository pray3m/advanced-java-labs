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
    <a href="${pageContext.request.contextPath}/new">Add a new user </a>

    <div>
        <h2>
            List of Users
        </h2>
        <table border="1" cellpadding="10" cellspacing="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>

            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null) {
                    for (User user : users) {
            %>

            <tr>
                <td>
                    <%= user.getId() %>
                </td>
                <td>
                    <%= user.getName() %>
                </td>
                <td>
                    <%= user.getEmail() %>
                </td>
                <td>
                    <a href="">
                        <button>Edit</button>
                    </a>
                    <a href="${pageContext.request.contextPath}/delete?id=<%= user.getId() %>">
                        <button>Delete</button>
                    </a>
                </td>
            </tr>

            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4"> No users found.</td>
            </tr>
            <%
                }

            %>

        </table>
    </div>


</center>
</body>
</html>