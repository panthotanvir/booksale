<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/23/14
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">

            <form class="reg-page"  class="form-horizontal" role="form" style="padding-top: 21px;" method="post" action="login" >
                <div class="reg-header">
                    <h2>Login to your account</h2>
                </div>

                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" placeholder="Username" name="userEmail"  class="form-control">
                </div>
                <div class="input-group margin-bottom-20">
                    <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                    <input type="password" placeholder="Password" name="userPassword" class="form-control">
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
