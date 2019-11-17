<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 16/11/2019
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login" method="post">
    <fieldset>
        <legend>Login</legend>
        <label>Account :</label>
        <input type="text" name="account"><br>
        <label>Password :</label>
        <input type="password" name="password">
        <input type="submit" name="submit" value="Login">
    </fieldset>
</form>

</body>
</html>
