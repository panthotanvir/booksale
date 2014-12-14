<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/24/14
  Time: 3:43 AM

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <style>
        /**/
        /* ratings */
        /**/
        .sky-form .rating {
            margin-bottom: 4px;
            font-size: 15px;
            line-height: 27px;
            color: #404040;
        }
        .sky-form .rating:last-child {
            margin-bottom: 0;
        }
        .sky-form .rating input {
            position: absolute;
            left: -9999px;
        }
        .sky-form .rating label {
            display: block;
            float: right;
            height: 17px;
            margin-top: 5px;
            padding: 0 2px;
            font-size: 17px;
            line-height: 17px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<!--=== Content Part ===-->
<div class="container content">
    <div class="row portfolio-item margin-bottom-50">
        <!-- Carousel -->
        <div class="col-md-5">
            <div class="carousel slide carousel-v1" id="myCarousel">
                <div class="carousel-inner">
                    <div class="item active">
                        <img alt="" src="uploads/books/<c:out value="${requestScope.bookInfo.book.photo}"/>" >
                            <p><c:out value="${requestScope.bookInfo.book.title}"/></p>

                    </div>

                </div>
            </div>
        </div>
        <!-- End Carousel -->
        <!-- Content Info -->
        <div class="col-md-7">
            <div class="profile-body margin-bottom-20">
                <div class="tab-v1">
                    <ul class="nav nav-justified nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#overview">Overview</a></li>
                        <li><a data-toggle="tab" href="#specification">Full Specification</a></li>
                        <li><a data-toggle="tab" href="#owner">Owner Details</a></li>


                    </ul>
                    <div class="tab-content">
                        <div id="overview" class="profile-edit tab-pane fade in active">
                            <h2 class="heading-md"> <i class="icon-book-open"></i> <c:out value="${requestScope.bookInfo.book.title}"/></h2>
                            <p><i class="fa fa-calendar"></i>   <c:out value="${requestScope.bookInfo.book.date}"/></p>

                            <p><i class="fa fa-mobile-phone"></i>  <span><c:out value="${requestScope.bookInfo.user.phoneNo}"/></span></p>
                            <p><i class="fa fa-home"></i>   <span><c:out value="${requestScope.bookInfo.user.address}"/></span></p>
                            <h5>Price: <span class="label label-info">  <c:out value="${requestScope.bookInfo.book.price}"/></span></h5>


                        </div>

                        <div id="specification" class="profile-edit tab-pane fade">
                            <h2 class="heading-md"> <i class="icon-book-open"></i> <c:out value="${requestScope.bookInfo.book.title}"/></h2>

                            </br>
                            <p><i class="icon-user-follow"></i>  <span><c:out value="${requestScope.bookInfo.book.author}"/></span></p>
                            <p><i class="icon-user"></i>  <span><c:out value="${requestScope.bookInfo.book.publisher}"/></span></p>
                            <p><i class="fa fa-list"></i>  <span><c:out value="${requestScope.bookInfo.book.type}"/></span></p>
                            <p><i class="fa fa-list"></i>  <span><c:out value="${requestScope.bookInfo.book.edition}"/></span></p>


                        </div>

                        <div id="owner" class="profile-edit tab-pane fade">

                            <h2 class="heading-md"> <i class="icon-book-open"></i> <c:out value="${requestScope.bookInfo.book.title}"/></h2>
                            </br>
                            <div class="col-md-7">
                                <h3 class="heading-md"> <i class=" icon-user"></i> <c:out value="${requestScope.bookInfo.user.userName}"/></h3>
                                <p><i class="fa fa-envelope"></i>  <span><c:out value="${requestScope.bookInfo.user.email}"/></span></p>
                                <p><i class="fa fa-university"></i>  <span><c:out value="${requestScope.bookInfo.university.deptName}"/></span></p>
                                <p><i class="fa fa-university"></i>  <span><c:out value="${requestScope.bookInfo.university.uniName}"/></span></p>
                                <p><i class="fa fa-phone"></i>  <span><c:out value="${requestScope.bookInfo.user.phoneNo}"/></span></p>
                                <p><i class="fa fa-home"></i> <span><c:out value="${requestScope.bookInfo.user.address}"/></span></p>
                            </div>
                            <div class="col-md-5">
                                <c:if test="${sessionScope.isUser}">
                                    <form action="rating" id="sky-form2" class="sky-form" method="post">
                                        <header>Rate This User</header>
                                        <fieldset>
                                            <section>
                                                <div class="rating">

                                                    <input type="radio" name="rate" id="quality-5" value="5">
                                                    <label for="quality-5"><i class="fa fa-star"></i></label>
                                                    <input type="radio" name="rate" id="quality-4" value="4">
                                                    <label for="quality-4"><i class="fa fa-star"></i></label>
                                                    <input type="radio" name="rate" id="quality-3" value="3">
                                                    <label for="quality-3"><i class="fa fa-star"></i></label>
                                                    <input type="radio" name="rate" id="quality-2" value="2">
                                                    <label for="quality-2"><i class="fa fa-star"></i></label>
                                                    <input type="radio" name="rate" id="quality-1" value="1">
                                                    <label for="quality-1"><i class="fa fa-star"></i></label>
                                                    <input type="hidden" name="userId" value="<c:out value="${requestScope.bookInfo.user.userId}"/>"/>

                                                </div>
                                                <button type="submit" class="btn-u" name="submit">Rate</button>
                                            </section>
                                        </fieldset>
                                    </form>
                                </c:if>

                              </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--End Profile Body-->
        </div>
        <!-- End Content Info -->
    </div><!--/row-->
    <div class="tag-box tag-box-v2">
        <h3>Description</h3>
        <p><c:out value="${requestScope.bookInfo.book.description}"/></p>
    </div>
    <div class="margin-bottom-20 clearfix"></div>

    <!-- Recent Works -->
    <div class="owl-carousel-v1 owl-work-v1 margin-bottom-40">
        <div class="headline"><h2 class="pull-left">You May Like</h2>
            <div class="owl-navigation">
                <div class="customNavigation">
                    <a class="owl-btn prev-v2"><i class="fa fa-angle-left"></i></a>
                    <a class="owl-btn next-v2"><i class="fa fa-angle-right"></i></a>
                </div>
            </div><!--/navigation-->
        </div>

        <div class="owl-slider-v2">
            <c:if test="${requestScope.recommendedBook != null}">
                <c:forEach var="recommend" items="${requestScope.recommendedBook}" varStatus="item">
                    <div class="item">
                        <a href="#">
                            <em class="overflow-hidden">
                                <img alt="" src="uploads/books/<c:out value="${recommend.photo}"/>" height="200px" width="270px">
                            </em>
                                <span>
                                    <strong><a class="btn-u btn-u-sm" href="singleBook?bookId=${recommend.bookId}"><c:out value="${recommend.title}"/></a></strong>
                                    <i><span class="color-green">Price(Tk):</span><c:out value="${recommend.price}"/></i>
                                </span>
                        </a>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <!-- End Recent Works -->
</div>

</body>
</html>
