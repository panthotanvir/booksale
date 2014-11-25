<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/24/14
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!-- Navbar -->
<div class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="fa fa-bars"></span>
            </button>
            <a class="navbar-brand" href="home">
               <!-- <img id="logo-header" src="assets/img/logo1-default.png" alt="Logo">-->
                <h1 class="text-center">BookSale</h1>
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse navbar-responsive-collapse">
            <ul class="nav navbar-nav">
                <!-- Home -->
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        Home
                    </a>

                </li>
                <!-- End Home -->

                <!-- University List -->
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        University
                    </a>
                    <ul class="dropdown-menu">
                        <!-- About Pages -->
                        <li class="dropdown-submenu">
                            <a href="javascript:void(0);">University Name</a>
                            <ul class="dropdown-menu">
                                <li><a href="page_about1.html">department</a></li>

                            </ul>
                        </li>
                    </ul>
                </li>
                <!-- University List -->


                <!-- Category -->
                <li class="dropdown">
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        Category
                    </a>
                    <ul class="dropdown-menu">
                        <!-- About Pages -->
                        <li class="dropdown-submenu">
                            <a href="javascript:void(0);">Author</a>

                        </li>

                        <li>
                            <a href="javascript:void(0);">Publisher</a>
                        </li>
                    </ul>
                </li>
                <!-- Category -->
                <!-- Contact -->
                <li>
                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown">
                        Contact
                    </a>

                </li>
                <!-- Search Block -->
                <li>
                    <i class="search fa fa-search search-btn"></i>
                    <div class="search-open">
                        <div class="input-group animated fadeInDown">
                            <input type="text" class="form-control" placeholder="Search">
                                    <span class="input-group-btn">
                                        <button class="btn-u" type="button">Go</button>
                                    </span>
                        </div>
                    </div>
                </li>
                <!-- End Search Block -->
            </ul>
            </li>
            <!-- Category -->


            </ul>
        </div><!--/navbar-collapse-->
    </div>
</div>
<!-- End Navbar -->
</body>
</html>
