<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 09/09/2022
  Time: 6:41 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/dictionary" method="get">
    <input type="text" name="eng" placeholder="Input"><br><br>
    <button type="submit">Search</button><br>
    <h3>${result}</h3>
</form>
</body>
</html>
