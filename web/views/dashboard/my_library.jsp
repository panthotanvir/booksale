<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/25/14
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
                <!--Projects-->
                <div class="row">
                    <c:if test="${requestScope.libraryBook != null}">
                        <c:forEach var="library" items="${requestScope.libraryBook}" varStatus="item">
                            <div class="col-sm-6">
                                <div class="easy-block-v1">
                                    <img alt="book" class="img-responsive" src="uploads/<c:out value="${library.photo}"/>.jpg">
                                    <div class="easy-block-v1-badge rgba-red"><c:out value="${library.type}"/></div>
                                </div>
                                <div class="projects">
                                    <h2><c:out value="${library.title}"/></h2>
                                    <ul class="list-unstyled list-inline blog-info-v2">
                                        <li>Authored By: <a class="color-green" href="#"><c:out value="${library.author}"/></a></li>
                                        <li>Edition 13</li>
                                        <li><i class="fa fa-clock-o"></i> <c:out value="${library.date}"/></li>
                                    </ul>
                                    <h3 class="heading-xs">Price<span class="pull-right"><c:out value="${library.price}"/></span></h3>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div><!--/end row-->
                <!--End Projects-->

                <hr>

                <button type="button" class="btn-u btn-u-default btn-u-sm btn-block">Load More</button>
            </div>
            <!--End Profile Body-->
        </div>
    </div><!--/end row-->
</div><!--/container-->
<!--=== End Profile ===-->
</body>
</html>
