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
                    <ol class="carousel-indicators">
                        <li class="rounded-x active" data-target="#carousel-example-generic" data-slide-to="0"></li>
                        <li class="rounded-x" data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li class="rounded-x" data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img alt="" src="assets/img/job/high-rated-job-1.1.jpg">
                        </div>
                        <div class="item">
                            <img alt="" src="assets/img/job/high-rated-job-1.2.jpg">
                        </div>
                        <div class="item">
                            <img alt="" src="assets/img/job/high-rated-job-1.3.jpg">
                        </div>
                    </div>
                </div>
                <div class="overflow-h">
                    <h3><c:out value="${book.title}"/></h3>
                    <div class="star-vote pull-right">
                        <ul class="list-inline">
                            <li><i class="color-green fa fa-star"></i></li>
                            <li><i class="color-green fa fa-star"></i></li>
                            <li><i class="color-green fa fa-star"></i></li>
                            <li><i class="color-green fa fa-star-half-o"></i></li>
                            <li><i class="color-green fa fa-star-o"></i></li>
                        </ul>
                    </div>
                </div>
                <ul class="list-unstyled">
                    <li><span class="color-green">Author:</span><c:out value="${book.author}"/></li>
                    <li><span class="color-green">Price(Tk):</span><c:out value="${book.price}"/></li>
                </ul>
                <a class="btn-u btn-u-sm" href="#"><c:out value="${book.book_id}"/></a>
            </div>
        </div>
        <!-- End Easy Block -->
        </c:forEach>
        </c:if>

    </div>
    <!-- End Easy Blocks v1 -->



    <!-- Job Content -->
    <div class="headline"><h2>Job Categories</h2></div>
    <div class="row job-content margin-bottom-40">
        <div class="col-md-3 col-sm-3 md-margin-bottom-40">
            <ul class="list-unstyled categories">
                <h3 class="heading-md"><strong>Accounting &amp; Finance</strong></h3>
                <li><a href="#">Accounting</a> <small class="hex">(342 jobs)</small></li>
                <li><a href="#">Admin &amp; Clerical</a> <small class="hex">(143 jobs)</small></li>
                <li><a href="#">Banking &amp; Finance</a> <small class="hex">(66 jobs)</small></li>
                <li><a href="#">Contract &amp; Freelance</a> <small class="hex">(12 jobs)</small></li>
                <li><a href="#">Business Development</a> <small class="hex">(212 jobs)</small></li>
            </ul>
        </div>
        <div class="col-md-3 col-sm-3 md-margin-bottom-40">
            <ul class="list-unstyled categories">
                <h3 class="heading-md"><strong>Medicla &amp; Health</strong></h3>
                <li><a href="#">Nurse</a> <small class="hex">(546 jobs)</small></li>
                <li><a href="#">Health Care</a> <small class="hex">(82 jobs)</small></li>
                <li><a href="#">General Labor</a> <small class="hex">(11 jobs)</small></li>
                <li><a href="#">Pharmaceutical</a> <small class="hex">(109 jobs)</small></li>
                <li><a href="#">Human Resources</a> <small class="hex">(401 jobs)</small></li>
            </ul>
        </div>
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
        <div class="col-md-3 col-sm-3">
            <ul class="list-unstyled categories">
                <h3 class="heading-md"><strong>Sales &amp; Marketing</strong></h3>
                <li><a href="#">Advertising</a> <small class="hex">(123 jobs)</small></li>
                <li><a href="#">Email Marketing</a> <small class="hex">(544 jobs)</small></li>
                <li><a href="#">Telemarketing &amp; Telesales</a> <small class="hex">(564 jobs)</small></li>
                <li><a href="#">Market Research &amp; Surveys</a> <small class="hex">(345 jobs)</small></li>
                <li><a href="#">SEM - Search Engine Marketing</a> <small class="hex">(32 jobs)</small></li>
            </ul>
        </div>
    </div>
    <!-- End Job Content -->

</div>
<!--=== End Content Part ===-->



</body>
</html>
