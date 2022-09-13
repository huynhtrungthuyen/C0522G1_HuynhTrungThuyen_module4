<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 13/09/2022
  Time: 12:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="email" method="post" action="/save">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>

        <tr>
            <td>Languages</td>
            <td><form:select path="languages" items="${languageList}"/>
        </tr>

        <tr>
            <td>Page size</td>
            <td>
                show <form:select path="pageSize" items="${pageSizeList}" /> emails per page
            </td>
        </tr>

        <tr>
            <td>Spams filter</td>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Update</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
