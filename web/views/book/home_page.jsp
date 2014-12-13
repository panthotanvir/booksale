<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/29/14
  Time: 12:36 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <h2>Tanvir Ahmed</h2>
            <h2>Computer Science & Engneering</h2>

        </div>
    </div>
</div><!--/container-->
<!--=== End Search Block Version 2 ===-->

<!--=== Search Results ===-->
<div class="container s-results margin-bottom-50">
    <div class="row">
        <!-- Begin Sidebar Menu -->
        <!-- jsp:include page="begin_sidebar.jsp"/ -->

        <!-- Begin Content -->
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <ul>
                <c:if test="${requestScope.bookList != null}">
                    <c:forEach var="book" items="${requestScope.bookList}" varStatus="item">
                        <li class="col-md-3 col-sm-6 col-xs-12 mix category_3 category_2">

                            <div class="item">
                                <div class="thumbnails thumbnail-style thumbnail-kenburn">
                                    <div class="thumbnail-img">
                                        <div class="overflow-hidden">
                                            <img class="img-responsive" src="uploads/books/<c:out value="${book.photo}"/>" alt="">
                                        </div>
                                        <a class="btn-more hover-effect" href="singleBook?bookId=${book.bookId}">Details</a>
                                    </div>
                                    <div class="caption">
                                        <h3><c:out value="${book.title}"/></h3>
                                        <p>price: <c:out value="${book.price}"/></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>

            </ul>
        </div>
        <div class="col-md-2"></div>
        <!-- End Content -->
    </div>
</div><!--/container-->
<!--=== End Search Results ===-->
</body>
</html>
