<%--
  Created by IntelliJ IDEA.
  User: Dina Maskalik
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Person</title>
</head>

<body>
<h2>Person Info</h2>

<b class="subNav">ID person:</b>
<form method="post" action="/lab3/person">
    <input type="text" name="id" size="" 10>
    <button class="" type="submit">Find</button>
</form>

<p class="subNav">${findPersonId}</p>
<p class="subNav">${findPersonName}</p>
<p class="subNav">${findPersonEmail}</p>
<p class="subNav">${findPersonState}</p>

</body>
</html>
