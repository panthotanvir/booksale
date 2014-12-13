
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/25/14
  Time: 3:24 PM

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
                                        <img class="rounded-x" src="uploads/users/<c:out value="${us.user.photo}"/>" alt="">
                                        <div class="name-location">
                                            <strong><i class=" icon-user"></i>  <c:out value="${us.user.userName}"/></strong>
                                            <span><i class="fa fa-envelope"></i>  <a href="#"><c:out value="${us.user.email}"/></a></span></br>
                                            <span><i class="fa fa-map-marker"></i>  <a href="#"><c:out value="${us.user.address}"/></a></span>
                                        </div>
                                        <div class="clearfix margin-bottom-20"></div>
                                        <hr>
                                    </div>
                                </div>
                                </c:forEach>
                                </c:if>
                            </div><!--/end row-->
                            <!--End Profile Blog-->

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
