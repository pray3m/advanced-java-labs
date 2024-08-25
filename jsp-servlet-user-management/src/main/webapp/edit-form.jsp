<%@ page import="com.codewithprem.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>

<center>
    <h1>
        Edit user
    </h1>

    <%
        User user = (User) request.getAttribute("user");
        if (user != null) {
    %>

    <form action="${pageContext.request.contextPath}/update" method="post">

        <label for="id">Id:</label>
        <input type="text" id="id" name="id" required disabled value="<%=user.getId()%>">
        <br/><br/>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%= user.getName() %>" required>
        <br/><br/>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= user.getEmail() %>" required>
        <br/><br/>
        <input type="submit" value="Update">
    </form>
    <% } else {
    %>
    <p> User not found</p>
    <%
        }
    %>
</center>

</body>
</html>
