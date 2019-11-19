<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 13/11/2019
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<form action="/submit" method="post">
    <label><h1>Caculator</h1></label><br>
    <input type="text" name="num1">
    <input type="text" name="num2"><br>
    <select name="operater">
        <option value="+">cong</option>
        <option value="-">tru</option>
        <option value="*">nhan</option>
        <option value="/">chia</option>
    </select>
    <input type="submit" value="submit">
</form>
</body>
</html>
