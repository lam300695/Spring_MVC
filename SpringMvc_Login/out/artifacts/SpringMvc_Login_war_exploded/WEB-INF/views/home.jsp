<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 12/11/2019
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Home</h1>
<form action="login" method="post">
    <fieldset>
        <legend>Login</legend>
        <label>Account: </label>
        <input name="account" type="text">
        <label>Password: </label>
        <input name="password" type="password">
        <input type="submit" id="submit" value="Login">
    </fieldset>
</form>
</body>
</html>
