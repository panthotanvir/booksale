<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
    <title><decorator:title/></title>


    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/bootstrap/css/bootstrap.min.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/style.css" />" media="all">


    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/line-icons/line-icons.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/font-awesome/css/font-awesome.min.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/flexslider/flexslider.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/parallax-slider/css/parallax-slider.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/owl-carousel/owl-carousel/owl.carousel.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/sky-forms/version-2.0.1/css/custom-sky-forms.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/scrollbar/src/perfect-scrollbar.css" />" media="all">

    <!-- CSS Page Style -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/pages/page_log_reg_v1.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/pages/profile.css" />" media="all">

    <!-- CSS Theme -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/themes/default.css" />" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/sky-forms/version-2.0.1/css/custom-sky-forms.css" />" media="all">


    <!-- CSS Customization -->

    <link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/custom.css" />" media="all">

    <!-- CSS End -->
    <style>
        .container > .navbar-header,
        .container-fluid > .navbar-header,
        .container > .navbar-collapse,
        .container-fluid > .navbar-collapse {
            margin-top: -20px;
        }
    </style>


<decorator:head/>
</head>
<body>

<!--=== Style Switcher ===-->
<i class="style-switcher-btn fa fa-cogs hidden-xs"></i>
<div class="style-switcher animated fadeInRight">
    <div class="theme-close"><i class="icon-close"></i></div>
    <div class="theme-heading">Theme Colors</div>
    <ul class="list-unstyled">
        <li class="theme-default theme-active" data-style="default" data-header="light"></li>
        <li class="theme-blue" data-style="blue" data-header="light"></li>
        <li class="theme-orange" data-style="orange" data-header="light"></li>
        <li class="theme-red" data-style="red" data-header="light"></li>
        <li class="theme-light last" data-style="light" data-header="light"></li>

        <li class="theme-purple" data-style="purple" data-header="light"></li>
        <li class="theme-aqua" data-style="aqua" data-header="light"></li>
        <li class="theme-brown" data-style="brown" data-header="light"></li>
        <li class="theme-dark-blue" data-style="dark-blue" data-header="light"></li>
        <li class="theme-light-green last" data-style="light-green" data-header="light"></li>
    </ul>
    <div style="margin-bottom:18px;"></div>
    <div class="theme-heading">Layouts</div>
    <div class="text-center">
        <a href="javascript:void(0);" class="btn-u btn-u-green btn-block active-switcher-btn wide-layout-btn">Wide</a>
        <a href="javascript:void(0);" class="btn-u btn-u-green btn-block boxed-layout-btn">Boxed</a>
    </div>
</div><!--/style-switcher-->
<!--=== End Style Switcher ===-->
<!--=== Header ===-->
<div class="header">
    <!-- Topbar -->
    <div class="topbar">
        <div class="container">
            <!-- Topbar Navigation -->
            <ul class="loginbar pull-right">
                <li><a href="home">home page</a></li>
                <li><a href="adduser">User Form</a></li>
                <li><a href="addbook">Add Post</a></li>
            </ul>
            <!-- End Topbar Navigation -->
        </div>
    </div>
    <!-- End Topbar -->
    <!-- Navbar -->
    <jsp:include page="/views/menu/menu.jsp"/>
    <!-- end navber -->
</div><!--header-->
<div class="wrapper">
    <decorator:body/>
    <!--=== Copyright ===-->
    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <p class="text-center">
                        Copyright &copy 2014 Department of Computer Science & Engineering, University of Dhaka
                        <a target="_blank" href="#">BookSale</a> | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a>
                    </p>
                </div>

            </div>
        </div>
    </div><!--/copyright-->
</div> <!-- Wrapper -->


<!-- JS Global Compulsory -->

<script src="<c:url value="/assets/plugins/jquery-1.10.2.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/jquery-migrate-1.2.1.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/jquery-1.10.2.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/back-to-top.js"/>"></script>


<!-- JS Implementing Plugins -->

<script src="<c:url value="/assets/plugins/back-to-top.js"/>"></script>
<script src="<c:url value="/assets/plugins/flexslider/jquery.flexslider-min.js"/>"></script>
<script src="<c:url value="/assets/plugins/parallax-slider/js/modernizr.js"/>"></script>
<script src="<c:url value="/assets/plugins/parallax-slider/js/jquery.cslider.js"/>"></script>
<script src="<c:url value="/assets/plugins/countdown/jquery.countdown.js"/>"></script>
<script src="<c:url value="/assets/plugins/backstretch/jquery.backstretch.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/bxslider/jquery.bxslider.js"/>"></script>
<script src="<c:url value="/assets/plugins/owl-carousel/owl-carousel/owl.carousel.js"/>"></script>
<script src="<c:url value="/assets/plugins/counter/waypoints.min.js"/>"></script>
<script src="<c:url value="/assets/plugins/counter/jquery.counterup.min.js"/>"></script>

<!-- Datepicker Form -->
<script src="<c:url value="/assets/plugins/sky-forms/version-2.0.1/js/jquery-ui.min.js"/>"></script>


<!-- Scrollbar -->
<script src="<c:url value="/assets/plugins/scrollbar/src/jquery.mousewheel.js"/>"></script>
<script src="<c:url value="/assets/plugins/scrollbar/src/perfect-scrollbar.js"/>"></script>

<!-- JS Page Level -->

<script src="<c:url value="/assets/js/app.js"/>"></script>
<script src="<c:url value="/assets/js/plugins/owl-carousel.js"/>"></script>
<script src="<c:url value="/assets/js/pages/index.js"/>"></script>
<script src="<c:url value="/assets/js/plugins/datepicker.js"/>"></script>


<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        App.initCounter();
        Datepicker.initDatepicker();
    });
</script>
<script>
    jQuery(document).ready(function ($) {
        "use strict";
        $('.contentHolder').perfectScrollbar();
    });
</script>


<script type="text/javascript">
    jQuery(document).ready(function() {
        App.init();
        App.initSliders();
        Index.initParallaxSlider();
    });
</script>

<script type="text/javascript">
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-29166220-1']);
    _gaq.push(['_setDomainName', 'htmlstream.com']);
    _gaq.push(['_trackPageview']);
    (function() {
        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
    })();
</script>

</body>
</html>