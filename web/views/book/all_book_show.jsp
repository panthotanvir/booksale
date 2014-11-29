<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/23/14
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title></title>
</head>
<body>
<!--=== Content Part ===-->
<div class="container content">

    <div class="headline margin-bottom-35"><h2>Top Rated Books</h2></div>



    <!-- Easy Blocks v1 -->
    <div class="row high-rated margin-bottom-20">

            <c:if test="${requestScope.bookList != null}">
            <c:forEach var="book" items="${requestScope.bookList}" varStatus="item">

                <!-- Easy Block -->
                <div class="col-md-3 col-sm-6 md-margin-bottom-40">
                    <div class="easy-block-v1">
                        <div class="easy-block-v1-badge rgba-default"><c:out value="${book.type}"/></div>
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">

                            <div class="carousel-inner">
                                <div class="item active">
                                    <img alt="book" class="img-responsive" src="uploads/<c:out value="${book.photo}"/>.jpg" height="340" width="260">
                                </div>

                            </div>
                        </div>
                        <div class="overflow-h">
                            <h3><c:out value="${book.title}"/></h3>

                        </div>

                        <ul class="list-unstyled">
                            <li><span class="color-green">Author:</span><c:out value="${book.author}"/></li>
                            <li><span class="color-green">Price(Tk):</span><c:out value="${book.price}"/></li>
                        </ul>
                        <a class="btn-u btn-u-sm" href="singleBook?bookId=${book.bookId}">View Details</a>
                    </div>
                </div>

        <!-- End Easy Block -->
        </c:forEach>
        </c:if>

    </div>
    <!-- End Easy Blocks v1 -->



    <!-- Content -->
    <div class="headline"><h2>Another Categories</h2></div>
    <div class="row job-content margin-bottom-40">
        <div class="col-md-3 col-sm-3 md-margin-bottom-40">
            <ul class="list-unstyled categories">
                <h3 class="heading-md"><strong>Web Development</strong></h3>
                <li><a href="#">Ecommerce</a> <small class="hex">(958 jobs)</small></li>
                <li><a href="#">Web Design</a> <small class="hex">(576 jobs)</small></li>
                <li><a href="#">Web Programming</a> <small class="hex">(543 jobs)</small></li>
                <li><a href="#">Other - Web Development</a> <small class="hex">(67 jobs)</small></li>
                <li><a href="#">Website Project Management</a> <small class="hex">(45 jobs)</small></li>
            </ul>
        </div>
    </div>
    <!-- End Content -->

</div>
<!--=== End Content Part ===-->


</body>
</html>
