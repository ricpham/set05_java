<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login Page</h1>
<form method="POST" action="login">
    <p>
        <input type="text" placeholder="Enter username" name="username">
    </p>
    <p>
        <input type="password" placeholder="Enter Password" name="password">
    </p>
    <p>
        <input type="submit" value="Login" />
    </p>
</form>
</body>
</html>
