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
    <div class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="fa fa-bars"></span>
                </button>
                <h1 class="text-center">BookSale</h1>
            </div>
        </div>
    </div>
</div>
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
    <!--=== End Copyright ===-->
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

<!-- JS Page Level -->

<script src="<c:url value="/assets/js/app.js"/>"></script>
<script src="<c:url value="/assets/js/plugins/owl-carousel.js"/>"></script>
<script src="<c:url value="/assets/js/pages/index.js"/>"></script>


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