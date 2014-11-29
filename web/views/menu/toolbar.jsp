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

            <li><a href="adduser">Registration</a></li>

            <c:choose>
                <c:when test="${sessionScope.isUser}">
                    <li><a href="addbook">Add Post</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login">Add Post</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.isUser}">
                    <li><a href="dashboard">Dashboard</a></li>
                    <li><a href="logout">Logout</a></li>
                </c:when>

                <c:otherwise>
                    <li><a href="login">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>

        <!-- End Topbar Navigation -->
        <!--
        <div>
            <div class="btn-group">
                <button type="button" class="btn-u btn-u-default"><a style="color:white;">Home</a></button>
                <button type="button" class="btn-u btn-u-blue">

                    <a style="color:white;">Registration</a>
                </button>
                <button type="button" class="btn-u"><a style="color:white;">Dashboard</a></button>
                <button type="button" class="btn-u btn-u-purple"><a style="color:white;">Add Post</a></button>

            </div>

        </div>
        -->
    </div>
</div>
</body>
</html>
