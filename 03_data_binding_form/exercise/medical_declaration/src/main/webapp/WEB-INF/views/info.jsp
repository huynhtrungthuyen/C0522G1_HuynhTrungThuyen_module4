<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 13/09/2022
  Time: 2:11 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thông tin tờ khai y tế</h2>

<table>
    <tr>
        <td>Họ tên:</td>
        <td>${declaration.name}</td>
    </tr>

    <tr>
        <td>Năm sinh:</td>
        <td>${declaration.yearOfBirth}</td>
    </tr>

    <tr>
        <td>Giới tính:</td>
        <td>${declaration.gender}</td>
    </tr>

    <tr>
        <td>Quốc tịch:</td>
        <td>${declaration.nationality}</td>
    </tr>

    <tr>
        <td>Số CMND/CCCD/Hộ chiếu:</td>
        <td>${declaration.identityCard}</td>
    </tr>

    <tr>
        <td>Thông tin đi lại:</td>
        <td>${declaration.travelInformation}</td>
    </tr>

    <tr>
        <td>Số hiệu phương tiện:</td>
        <td>${declaration.vehicleNumber}</td>
    </tr>

    <tr>
        <td>Số ghế:</td>
        <td>${declaration.seats}</td>
    </tr>

    <tr>
        <td>Ngày khởi hành:</td>
        <td>${declaration.departureDay}/${declaration.departureMonth}/${declaration.departureYear}</td>
    </tr>

    <tr>
        <td>Ngày kết thúc:</td>
        <td>${declaration.endDay}/${declaration.endMonth}/${declaration.endYear}</td>
    </tr>

    <tr>
        <td>Tỉnh/thành đã đến trong 14 ngày qua:</td>
        <td>${declaration.note}</td>
    </tr>
</table>
</body>
</html>
