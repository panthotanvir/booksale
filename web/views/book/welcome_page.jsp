<%--
  Created by IntelliJ IDEA.
  User: pmithunshawon
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
            <h2>Search Your Book</h2>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search words with regular expressions ...">
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
<div class="col-md-3">
    <ul class="list-group sidebar-nav-v1" id="sidebar-nav">
        <!-- Typography -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-typography">University</a>
            <ul id="collapse-typography" class="collapse">
                <li><a href="feature_typo_general.html"><i class="fa fa-sort-alpha-asc"></i>University of Dhaka</a></li>
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_typo_headings.html"><i class="fa fa-magic"></i>Jahangir Nagor University</a>
                </li>
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_typo_dividers.html"><i class="fa fa-ellipsis-h"></i>Rajshahi University</a>
                </li>
                <li><a href="feature_typo_blockquote.html"><i class="fa fa-quote-left"></i>Chittagong University</a></li>
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_typo_boxshadows.html"><i class="fa fa-asterisk"></i>Buet</a>
                </li>
                <li><a href="feature_typo_testimonials.html"><i class="fa fa-comments"></i>Comilla University</a></li>

            </ul>
        </li>
        <!-- End Typography -->

        <!-- Buttons UI -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-buttons">Department</a>
            <ul id="collapse-buttons" class="collapse">
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Computer Science & Engineering</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Computer Science & Engineering</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Computer Science & Engineering</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Computer Science & Engineering</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Computer Science & Engineering</a></li>

            </ul>
        </li>
        <!-- End Buttons UI -->

        <!-- Icons -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-icons">Author</a>
            <ul id="collapse-icons" class="collapse">
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_icon_general.html"><i class="fa fa-chevron-circle-right"></i>Andru Markson</a>
                </li>
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_icon_general.html"><i class="fa fa-chevron-circle-right"></i>Andru Markson</a>
                </li>
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_icon_general.html"><i class="fa fa-chevron-circle-right"></i>Andru Markson</a>
                </li>
                <li>
                    <span class="badge badge-u">New</span>
                    <a href="feature_icon_general.html"><i class="fa fa-chevron-circle-right"></i>Andru Markson</a>
                </li>
            </ul>
        </li>
        <!-- End Icons -->

        <!-- Content Boxes -->
        <li class="list-group-item list-toggle">
            <a class="accordion-toggle" href="#collapse-content-boxes" data-toggle="collapse">Publisher</a>
            <ul id="collapse-content-boxes" class="collapse">

                <li><a href="feature_box_colored.html"><i class="fa fa-align-center"></i> Andru Markson</a></li>
                <li><a href="feature_box_funny.html"><i class="fa fa-bars"></i> Funny Boxes</a></li>
            </ul>
        </li>
        <!-- End Content Boxes -->

        <!-- Thumbails -->
        <li class="list-group-item"><a href="feature_thumbails.html">All Books</a></li>
        <!-- End Thumbails -->


    </ul>
</div>
<!-- End Sidebar Menu -->

<!-- Begin Content -->
<div class="col-md-9">
<!-- Recent Works -->
<div class="owl-carousel-v1 owl-work-v1 margin-bottom-40">
    <div class="headline"><h2 class="pull-left">Recent Works</h2>
        <div class="owl-navigation">
            <div class="customNavigation">
                <a class="owl-btn prev-v2"><i class="fa fa-angle-left"></i></a>
                <a class="owl-btn next-v2"><i class="fa fa-angle-right"></i></a>
            </div>
        </div><!--/navigation-->
    </div>

    <div class="owl-slider-v2">
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Recent Works -->
<!-- Recent Works -->
<div class="owl-carousel-v1 owl-work-v1 margin-bottom-40">
    <div class="headline"><h2 class="pull-left">Recent Works</h2>
        <div class="owl-navigation">
            <div class="customNavigation">
                <a class="owl-btn prev-v1"><i class="fa fa-angle-left"></i></a>
                <a class="owl-btn next-v1"><i class="fa fa-angle-right"></i></a>
            </div>
        </div><!--/navigation-->
    </div>

    <div class="owl-slider">
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnails thumbnail-style thumbnail-kenburn">
                <div class="thumbnail-img">
                    <div class="overflow-hidden">
                        <img class="img-responsive" src="assets/img/5.jpg" alt="">
                    </div>
                    <a class="btn-more hover-effect" href="#">Details</a>
                </div>
                <div class="caption">
                    <h3><a class="hover-effect" href="#">Project Three</a></h3>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, justo sit amet risus etiam porta sem.</p>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- End Recent Works -->
</div>
</div>
</div><!--/container-->
<!--=== End Search Results ===-->
</body>
</html>
