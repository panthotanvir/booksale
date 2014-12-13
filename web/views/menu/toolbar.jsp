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
    <style>

        .topbar ul.loginbar > li{
            padding-right: 10px;
        }
        .topbar ul.loginbar > li > a,
        .topbar ul.loginbar > li > a:hover{
            color: white;
            font-size: 16px;
        }
    </style>
</head>
<body>
<div class="topbar">
    <div class="container">
        <!-- Topbar Navigation -->
        <ul class="loginbar pull-right">

            <c:choose>
                <c:when test="${sessionScope.isUser}">
                    <li><a href="addbook" rel="grow-rotate" class="btn-u btn-u-red grow-rotate">Add Post</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="login" rel="grow-rotate" class="btn-u btn-u-red grow-rotate">Add Post</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${sessionScope.isUser}">

                </c:when>
                <c:otherwise>
                    <li><a href="adduser" rel="grow-rotate" class="btn-u btn-u-dark-blue grow-rotate">Registration</a></li>
                </c:otherwise>
            </c:choose>

            <c:choose>
                <c:when test="${sessionScope.isUser}">
                    <li><a href="dashboard" rel="grow-rotate" class="btn-u btn-u-green grow-rotate">Dashboard</a></li>
                    <li><a href="logout" rel="grow-rotate" class="btn-u grow-rotate">Logout</a></li>
                </c:when>

                <c:otherwise>
                    <li><a href="login" rel="grow-rotate" class="btn-u grow-rotate">Login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>

        <!-- End Topbar Navigation -->

    </div>
</div>
</body>
</html>
