<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/25/14
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My self</title>
</head>
<body>
<!--=== Profile ===-->
<div class="profile">
    <div class="container content">
        <div class="row">
            <!-- start left sideber-->
            <jsp:include page="left_sidebar.jsp"/>
            <!--End Left Sidebar-->

            <div class="col-md-9">
                <!--Profile Body-->
                <div class="profile-body">
                    <div class="profile-bio">
                        <div class="row">
                            <div class="col-md-5">
                                <img class="img-responsive md-margin-bottom-10" src="assets/img/5.jpg" alt="">
                                <a class="btn-u btn-u-sm" href="#">Change Picture</a>
                            </div>
                            <div class="col-md-7">
                                <h2>Name:<c:out value="${requestScope.userInfo.userName}"/></h2>
                                <span><c:out value="${requestScope.userInfo.deptName}"/></span>
                                <span><c:out value="${requestScope.userInfo.uniName}"/></span>
                                <hr>
                            </div>
                        </div>
                        <!--/end row-->

                    </div>
                    <%--end of profilr-bio--%>

                    <hr>

                    <div class="row">
                        <!--Social Icons v3-->
                        <div class="col-sm-6 sm-margin-bottom-30">
                            <div class="panel panel-profile">
                                <div class="panel-heading overflow-h">
                                    <h2 class="panel-title heading-sm pull-left"><i class="fa fa-pencil"></i> Contact Address</h2>
                                    <a href="#"><i class="fa fa-cog pull-right"></i></a>
                                </div>
                                <div class="panel-body">
                                    <h2><c:out value="${requestScope.userInfo.email}"/></h2>
                                    <span><c:out value="${requestScope.userInfo.address}"/></span>
                                    <span><c:out value="${requestScope.userInfo.phoneNo}"/></span>
                                    <hr>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 sm-margin-bottom-30">
                            <div class="panel panel-profile">
                                <div class="panel-heading overflow-h">
                                    <h2 class="panel-title heading-sm pull-left"><i class="fa fa-pencil"></i> Social Contacts</h2>
                                    <a href="#"><i class="fa fa-cog pull-right"></i></a>
                                </div>
                                <div class="panel-body">
                                    <ul class="list-unstyled social-contacts-v2">
                                        <li><i class="rounded-x tw fa fa-twitter"></i> <a href="#">Twitter</a></li>
                                        <li><i class="rounded-x fb fa fa-facebook"></i> <a href="#">Dacebook</a></li>
                                        <li><i class="rounded-x sk fa fa-skype"></i> <a href="#">Skype</a></li>
                                        <li><i class="rounded-x gp fa fa-google-plus"></i> <a href="#">Google Plus</a></li>
                                        <li><i class="rounded-x gm fa fa-envelope"></i> <a href="#">Google Account</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--End Social Icons v3-->
                    </div><!--/end row-->

                    <hr>

                </div>
                <!--End Profile Body-->
            </div>
        </div><!--/end row-->
    </div><!--/container-->
</div>
<!--=== End Profile ===-->
</body>
</html>
