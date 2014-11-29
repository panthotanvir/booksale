<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/25/14
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Overview</title>
</head>
<body>
<!--=== Profile ===-->
<div class="profile container content">
    <div class="row">
        <!--Left Sidebar-->
        <jsp:include page="left_sidebar.jsp"/>
        <!--End Left Sidebar-->

        <div class="col-md-9">
            <!--Profile Body-->
            <div class="profile-body">
                <!--Service Block v3-->
                <div class="row margin-bottom-10">
                    <div class="col-sm-6 sm-margin-bottom-20">
                        <div class="service-block-v3 servive-block-u">
                            <i class="icon-users"></i>
                            <span class="service-heading">Overall Posted Book </span>
                            <span class="counter"><c:out value="${requestScope.countBook}"/></span>

                            <div class="clearfix margin-bottom-10"></div>

                            <div class="statistics">
                                <h3 class="heading-xs">Statistics in Progress Bar <span class="pull-right">67%</span></h3>
                                <div class="progress progress-u progress-xxs">
                                    <div style="width: 67%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="67" role="progressbar" class="progress-bar progress-bar-light">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div class="service-block-v3 servive-block-blue">
                            <i class="icon-screen-desktop"></i>
                            <span class="service-heading">Overall Notification</span>
                            <span class="counter"><c:out value="${requestScope.countRequest}"/></span>

                            <div class="clearfix margin-bottom-10"></div>


                            <div class="statistics">
                                <h3 class="heading-xs">Statistics in Progress Bar <span class="pull-right">89%</span></h3>
                                <div class="progress progress-u progress-xxs">
                                    <div style="width: 89%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="89" role="progressbar" class="progress-bar progress-bar-light">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div><!--/end row-->
                <!--End Service Block v3-->

                <hr>

                <div class="row margin-bottom-20">

                    <!--Profile Event-->
                    <div class="col-sm-6 md-margin-bottom-20">
                        <div class="panel panel-profile no-bg">
                            <div class="panel-heading overflow-h">
                                <h2 class="panel-title heading-sm pull-left"><i class="fa fa-briefcase"></i>Posted Book List</h2>
                                <a href="#"><i class="fa fa-cog pull-right"></i></a>
                            </div>
                            <div id="scrollbar2" class="panel-body contentHolder">
                                <c:if test="${requestScope.userBook != null}">
                                    <c:forEach var="userBook" items="${requestScope.userBook}" varStatus="item">
                                        <div class="profile-event">
                                            <div class="date-formats">

                                                <small><c:out value="${userBook.date}"/></small>
                                            </div>
                                            <div class="overflow-h">
                                                <h3 class="heading-xs"><a href="singleBook?bookId=${userBook.bookId}"><c:out value="${userBook.title}"/></a></h3>
                                                <p>Price : <c:out value="${userBook.price}"/></p>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </c:if>

                            </div>
                        </div>
                    </div>
                    <!--End Profile Event-->
                   <!-- Notification-->
                    <div class="col-sm-6">
                        <div class="panel panel-profile no-bg">
                            <div class="panel-heading-v2 overflow-h">
                                <h2 class="heading-xs pull-left"><i class="fa fa-bell-o"></i> Notification</h2>
                                <a href="#"><i class="fa fa-cog pull-right"></i></a>
                            </div>
                            <ul id="scrollbar5" class="list-unstyled contentHolder margin-bottom-20">
                                <c:if test="${requestScope.requestResult != null}">
                                    <c:forEach var="requestResult" items="${requestScope.requestResult}" varStatus="item">
                                        <li class="notification">
                                            <i class="icon-custom icon-sm rounded-x icon-bg-red icon-line icon-envelope"></i>
                                            <div class="overflow-h">
                                                <span><strong><c:out value="${requestResult.title}"/></strong> is available now </span>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </c:if>
                            </ul>
                            <button type="button" class="btn-u btn-u-default btn-u-sm btn-block">Load More</button>
                        </div>
                     </div>
                    <!--End Notification-->
                </div><!--/end row-->

                <hr>


            </div>
            <!--End Profile Body-->
        </div>
    </div><!--/end row-->
</div><!--/container-->
<!--=== End Profile ===-->
</body>
</html>
