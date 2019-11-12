<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 11/11/2019
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<form method="post" action="/usd">
    <label>Rate :</label>
    <input name="rate" value="23200" type="text"><br>
    <label>USD</label>
    <input name="usd" type="text"><br>
    <input type="submit" id="submit" value="converter">
</form>
</body>
</html>
