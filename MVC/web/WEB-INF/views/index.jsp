<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 11/11/2019
  Time: 00:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USD</title>
</head>
<body>
<form method="post" action="/usd">
    <label>Input USD :</label>
    <input name="usd" type="text" value="0"><br>
    <label>Input rate :</label>
    <input name="rate" type="text" value="23200"><br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
