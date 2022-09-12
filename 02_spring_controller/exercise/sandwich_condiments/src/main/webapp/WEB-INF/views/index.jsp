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
  <title>Sandwich Condiments</title>
</head>
<body>
<h3>Sandwich Condiments</h3>

<form action="/save" method="get">
  <input type="checkbox" name="condiment" value="Lettuce"> Lettuce &nbsp
  <input type="checkbox" name="condiment" value="Tomato"> Tomato &nbsp
  <input type="checkbox" name="condiment" value="Mustard"> Mustard &nbsp
  <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
<%--  <input type="checkbox" name="condiment" value="" checked hidden>--%>
  <br><hr>
  <button type="submit"> Save </button>
</form>

<h4>Condiments:</h4>
<c:forEach items="${condiment}" var="temp">${temp}<br></c:forEach>
</body>
</html>
