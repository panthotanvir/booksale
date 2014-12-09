<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/29/14
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <!-- start left sideber-->
            <jsp:include page="left_sidebar.jsp"/>
            <!--End Left Sidebar-->

            <div class="col-md-9">
                <div class="shadow-wrapper margin-bottom-60">
                    <div class="tag-box tag-box-v1 box-shadow shadow-effect-2">
                        <h2>Request For Your Desired Book</h2>
                        <form class="footer-subsribe" action="request" method="post">

                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Title of your book" name = "title">
                            <span class="input-group-btn">
                                <button class="btn-u"  type="submit">Go</button>
                            </span>
                            </div>
                        </form>
                    </div>
                </div>
                <!--Profile Event-->

                <div class="col-sm-6 md-margin-bottom-20">
                    <div class="panel panel-profile no-bg">
                        <div class="panel-heading overflow-h">
                            <h2 class="panel-title heading-sm pull-left"><i class="fa fa-briefcase"></i>Requested Book List</h2>
                            <a href="#"><i class="fa fa-cog pull-right"></i></a>
                        </div>
                        <div id="scrollbar2" class="panel-body contentHolder">
                            <c:if test="${requestScope.requestInfo != null}">
                                <c:forEach var="requestBook" items="${requestScope.requestInfo}" varStatus="item">
                                    <div class="profile-event">
                                        <div class="date-formats">

                                            <small><c:out value="${requestBook.book.date}"/></small>
                                        </div>
                                        <div class="overflow-h">
                                            <h3 class="heading-xs"><c:out value="${requestBook.book.title}"/></h3>

                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                        </div>
                    </div>
                </div>
                <!--End Profile Event-->

            </div>
        </div>
    </div>
</div>

</body>
</html>
