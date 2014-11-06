<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>HOME</title>
</head>
<body>

<!--=== Header ===-->
<div class="header">
    <!-- Topbar -->
    <div class="topbar">
        <div class="container">
            <!-- Topbar Navigation -->
            <ul class="loginbar pull-right">
                <li><a href="home">Home</a></li>
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
<div class="container content">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">

            <form class="reg-page" enctype="multipart/form-data" class="form-horizontal" role="form" style="padding-top: 21px;" action="#" >
                <div class="reg-header">
                    <h2>Login to your account</h2>
                </div>

                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" placeholder="Username" name="user_email"  class="form-control">
                </div>
                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" placeholder="Password" name="user_password" class="form-control">
                </div>

                <div class="row">
                    <div class="col-md-offset-6 col-md-6">
                        <button class="btn-u pull-right"  name="user_login"  type="submit">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div><!--/row-->
</div><!--/container-->


</body>
</html>