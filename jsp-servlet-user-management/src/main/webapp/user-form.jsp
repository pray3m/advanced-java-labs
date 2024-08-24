<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
<h1>
    Create a new User
</h1>

<form action="${pageContext.request.contextPath}/insert" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>
    <br/><br/>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <br/><br/>
    <input type="submit" value="Create User">
</form>

</body>
</html>
