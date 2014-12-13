<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/25/14
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--Left Sidebar-->
<div class="col-md-3 md-margin-bottom-40">
    <img class="img-responsive profile-img margin-bottom-20" src="uploads/users/<c:out value="${requestScope.userInfo.user.photo}"/>" alt="profile">

    <ul class="list-group sidebar-nav-v1 margin-bottom-40" id="sidebar-nav-1">
        <li class="list-group-item">
            <a href="dashboard"><i class="fa fa-bar-chart-o"></i> Overall</a>
        </li>
        <li class="list-group-item">
            <a href="profile"><i class="fa fa-user"></i> Profile</a>
        </li>
        <li class="list-group-item">
            <a href="library"><i class="fa fa-cubes"></i> My Posted Books</a>
        </li>
        <li class="list-group-item">
            <a href="fellow"><i class="fa fa-group"></i>Departmental Students</a>
        </li>
        <li class="list-group-item">
            <a href="request"><i class="fa fa-group"></i>My Requested List</a>
        </li>
        <li class="list-group-item">
            <a href="exchange"><i class="fa fa-group"></i>My Exchange List</a>
        </li>
        <li class="list-group-item">
            <a href="settings"><i class="fa fa-cog"></i>Settings</a>
        </li>
    </ul>


    <hr>
    <div class="margin-bottom-50"></div>

    <!--Datepicker-->
    <form action="#" id="sky-form2" class="sky-form">
        <div id="inline-start"></div>
    </form>
    <!--End Datepicker-->
</div>
<!--End Left Sidebar-->

