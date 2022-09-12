<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 11/09/2022
  Time: 4:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h3>Calculator</h3>

<form method="post" action="">
    <input type="text" name="number1" placeholder="Input first number" value="${number1}">
    <input type="text" name="number2" placeholder="Input second number" value="${number2}">
    <br><br>
    <button type="submit" name="calculator" value="Addition">Addition(+)</button>
    <button type="submit" name="calculator" value="Subtraction">Subtraction(-)</button>
    <button type="submit" name="calculator" value="Multiplication">Multiplication(X)</button>
    <button type="submit" name="calculator" value="Division">Division(/)</button>
</form>
<p>Result: ${result}</p>
</body>
</html>
