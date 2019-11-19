<%--
  Created by IntelliJ IDEA.
  User: lam
  Date: 12/11/2019
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sanwich</title>
</head>
<body>
<form action="/submit" method="post">
<div class="container">
<h1>Sandwich Condiments</h1>
<label class="checkbox">
    <input type="checkbox" name="tuongot">
    Tuong ot
</label>
<label class="checkbox">
    <input type="checkbox" name="tuongca">
    Tuong ca
</label>
<label class="checkbox">
    <input type="checkbox" name="tuongoi">
    Tuong oi
</label>
<label class="checkbox">
    <input type="checkbox" name="tuongcam">
    Tuong cam
</label><br>
    <input type="submit" value="save">
</div>
</form>
</body>
</html>
