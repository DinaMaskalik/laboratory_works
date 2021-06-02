<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hotel</title>
</head>

<body>
<h2>Hotel Table</h2>
<form method="get" action="/lab2/hotel">
    <c:forEach var="hotel" items="${hotels}">
        <p class="subNav">${hotel}
            <button class="btn btn-secondary" type="submit" name="btn_delete" value="${hotel.id}">Delete</button>
        </p>

    </c:forEach>
</form>

<b class="subNav">Max cost hotel:</b>
<form method="post" action="/lab2/hotel">
    <input type="text" name="maxCost" size="" 10>
    <button class="" type="submit">Find</button>
</form>

<c:forEach var="findHotel" items="${findHotels}">
    <p class="subNav">${findHotel}</p>
</c:forEach>
</body>
</html>
