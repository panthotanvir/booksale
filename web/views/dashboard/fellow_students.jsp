
<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/25/14
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!--=== Profile ===-->
<div class="profile">
    <div class="container content">
        <div class="row">
            <!--Left Sidebar-->
            <jsp:include page="left_sidebar.jsp"/>
            <!--End Left Sidebar-->

            <div class="col-md-9">
                <!--Profile Body-->
                <div class="profile-body margin-bottom-20">

                            <!--Profile Blog-->
                            <div class="row margin-bottom-20">
                                <c:if test="${requestScope.userDept != null}">
                                <c:forEach var="us" items="${requestScope.userDept}" varStatus="item">
                                <div class="col-sm-6 sm-margin-bottom-20">
                                    <div class="profile-blog">
                                        <img class="rounded-x" src="assets/img/testimonials/img1.jpg" alt="">
                                        <div class="name-location">
                                            <strong><i class=" icon-user"></i>  <c:out value="${us.userName}"/></strong>
                                            <span><i class="fa fa-envelope"></i>  <a href="#"><c:out value="${us.email}"/></a></span></br>
                                            <span><i class="fa fa-map-marker"></i>  <a href="#"><c:out value="${us.address}"/></a></span>
                                        </div>
                                        <div class="clearfix margin-bottom-20"></div>
                                        <hr>
                                    </div>
                                </div>
                                </c:forEach>
                                </c:if>
                            </div><!--/end row-->
                            <!--End Profile Blog-->
                    <button type="button" class="btn-u btn-u-default btn-block text-center">Load More</button>
                    <!--End Profile Blog-->
                </div>
                <!--End Profile Body-->
            </div>
        </div><!--/end row-->
    </div><!--/container-->
</div>
<!--=== End Profile ===-->
</body>
</html>
