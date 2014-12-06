<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 12/5/14
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!--=== Search Block Version 2 ===-->
<div class="search-block-v2">
    <div class="container">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center color-green">Discover your book ...</h1>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Enter your desired book title ...">
                    <span class="input-group-btn">
                        <button class="btn-u" type="button"><i class="fa fa-search"></i></button>
                    </span>
            </div>
        </div>
    </div>
</div><!--/container-->
<!--=== End Search Block Version 2 ===-->


<!--=== Search Results ===-->
<div class="container s-results margin-bottom-50">
    <div class="row">
        <!-- Begin Sidebar Menu -->
        <jsp:include page="begin_sidebar.jsp"/>

        <!-- Begin Content -->

        <div class="col-md-9">
            <ul>
                <c:if test="${requestScope.divisionBook != null}">
                    <c:forEach var="divisionBookList" items="${requestScope.divisionBook}" varStatus="item">
                        <li class="col-md-3 col-sm-6 col-xs-12 mix category_3 category_2">

                            <div class="item">
                                <div class="thumbnails thumbnail-style thumbnail-kenburn">
                                    <div class="thumbnail-img">
                                        <div class="overflow-hidden">
                                            <img class="img-responsive" src="uploads/books/<c:out value="${divisionBookList.photo}"/>" alt="">
                                        </div>
                                        <a class="btn-more hover-effect" href="singleBook?bookId=${divisionBookList.bookId}">Details</a>
                                    </div>
                                    <div class="caption">
                                        <p><c:out value="${divisionBookList.title}"/></p>
                                        <p>Price: <c:out value="${divisionBookList.price}"/></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>

            </ul>
        </div>

        <!-- End Content -->
    </div>
</div><!--/container-->
<!--=== End Search Results ===-->
</body>
</html>
