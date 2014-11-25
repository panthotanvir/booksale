<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/25/14
  Time: 12:38 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title></title>
</head>
<body>
<div class="topbar">
    <div class="container">
        <!-- Topbar Navigation -->
        <ul class="loginbar pull-right">
                <li><a href="home">home page</a></li>
                <li><a href="adduser">Registration</a></li>
                <li><a href="addbook">Add Post</a></li>
            <c:choose>
                <c:when test="${sessionScope.isUser}">
                    <li><a href="logout">Logout</a></li>
                </c:when>

                <c:otherwise>
                    <li><a href="login">Login</a></li>
                </c:otherwise>
            </c:choose>
            <%--<li><a href="logout">Logout</a></li>--%>
        </ul>
        <!-- End Topbar Navigation -->
    </div>
</div>
</body>
</html>
