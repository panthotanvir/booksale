<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/24/14
  Time: 3:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
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
                        <img alt="" src="uploads/<c:out value="${requestScope.bookInfo.photo}"/>.jpg" height="400px" width="300px">
                        <!--div class="carousel-caption">
                            <p><c:out value="${requestScope.bookInfo.tag}"/></p>
                        </div-->
                    </div>
                    <!--div class="item">
                        <img alt="" src="assets/img/main/12.jpg">
                        <div class="carousel-caption">
                            <p>photo2.</p>
                        </div>
                    </div>
                    <div class="item">
                        <img alt="" src="assets/img/main/13.jpg">
                        <div class="carousel-caption">
                            <p>photo3</p>
                        </div>
                    </div-->
                </div>

                <!--div class="carousel-arrow">
                    <a data-slide="prev" href="#myCarousel" class="left carousel-control">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a data-slide="next" href="#myCarousel" class="right carousel-control">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div-->
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
                            <h2 class="heading-md"> <i class="icon-book-open"></i> <c:out value="${requestScope.bookInfo.title}"/></h2>
                            <p><i class="fa-times-circle"></i>Date: <c:out value="${requestScope.bookInfo.date}"/></p>

                            <p><i class="fa fa-mobile-phone"></i> Contact No: <span><c:out value="${requestScope.bookInfo.contactNo}"/></span></p>
                            <p><i class="fa fa-home"></i> Contact Address: <span><c:out value="${requestScope.bookInfo.contactAddress}"/></span></p>
                            <h5>Price: <span class="label label-info"><c:out value="${requestScope.bookInfo.price}"/></span></h5>


                        </div>

                        <div id="specification" class="profile-edit tab-pane fade">
                            <h2 class="heading-md"> <i class="icon-book-open"></i> <c:out value="${requestScope.bookInfo.title}"/></h2>

                            </br>
                            <p><i class="icon-user-follow"></i>  <span><c:out value="${requestScope.bookInfo.author}"/></span></p>
                            <p><i class="icon-user"></i>  <span><c:out value="${requestScope.bookInfo.publisher}"/></span></p>
                            <p><i class="fa fa-list"></i>  <span><c:out value="${requestScope.bookInfo.type}"/></span></p>

                        </div>

                        <div id="owner" class="profile-edit tab-pane fade">
                            <h2 class="heading-md"> <i class="icon-book-open"></i> <c:out value="${requestScope.bookInfo.title}"/></h2>
                            </br>
                            <h3 class="heading-md"> <i class=" icon-user"></i> <c:out value="${requestScope.bookInfo.userName}"/></h3>
                            <p><i class="fa fa-envelope"></i>  <span><c:out value="${requestScope.bookInfo.email}"/></span></p>
                            <p><i class="fa fa-university"></i>  <span><c:out value="${requestScope.bookInfo.deptName}"/></span></p>
                            <p><i class="fa fa-university"></i>  <span><c:out value="${requestScope.bookInfo.uniName}"/></span></p>
                            <p><i class="fa fa-phone"></i>  <span><c:out value="${requestScope.bookInfo.phoneNo}"/></span></p>
                            <p><i class="fa fa-home"></i> <span><c:out value="${requestScope.bookInfo.address}"/></span></p>

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
        <p><c:out value="${requestScope.bookInfo.description}"/></p>
    </div>



    <div class="margin-bottom-20 clearfix"></div>

    <!-- Recent Works -->
    <div class="owl-carousel-v1 owl-work-v1 margin-bottom-40">
        <div class="headline"><h2 class="pull-left">Recommendened Books</h2>
            <div class="owl-navigation">
                <div class="customNavigation">
                    <a class="owl-btn prev-v2"><i class="fa fa-angle-left"></i></a>
                    <a class="owl-btn next-v2"><i class="fa fa-angle-right"></i></a>
                </div>
            </div><!--/navigation-->
        </div>

        <div class="owl-slider-v2">
            <div class="item">
                <a href="#">
                    <em class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/main/1.jpg" alt="">
                    </em>
                           <span>
                               <strong>Happy New Year</strong>
                               <i>Anim pariatur cliche reprehenderit</i>
                           </span>
                </a>
            </div>
        </div>
    </div>
    <!-- End Recent Works -->
</div>

</body>
</html>
