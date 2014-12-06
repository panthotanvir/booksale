<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/23/14
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Login </title>
    <script type="text/javascript">
        window.onload = function() {

            $('#regexpEmailForm')
                    .bootstrapValidator({
                        feedbackIcons: {
                            valid: 'glyphicon glyphicon-ok',
                            invalid: 'glyphicon glyphicon-remove',
                            validating: 'glyphicon glyphicon-refresh'
                        },
                        fields: {
                            email: {
                                validators: {
                                    emailAddress: {
                                        message: 'The value is not a valid email address'
                                    },
                                    regexp: {
                                        regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                        message: 'The value is not a valid email address'
                                    }
                                }
                            }
                        }
                    })
                    .on('error.validator.bv', function(e, data) {
                        // data.bv        --> The BootstrapValidator instance
                        // data.field     --> The field name
                        // data.element   --> The field element
                        // data.validator --> The current validator name

                        if (data.field === 'email') {
                            // The email field is not valid
                            data.element
                                    .data('bv.messages')
                                // Hide all the messages
                                    .find('.help-block[data-bv-for="' + data.field + '"]').hide()
                                // Show only message associated with current validator
                                    .filter('[data-bv-validator="' + data.validator + '"]').show();
                        }
                    });
        }

    </script>
</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">

            <form id="regexpEmailForm" class="reg-page"  class="form-horizontal" role="form" style="padding-top: 21px;" method="post" action="login" >

                    <div class="reg-header">
                        <h2>Login to your account</h2>
                    </div>
                    <div class="form-group ">
                        <div class="input-group margin-bottom-20" >
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" placeholder="User Email" name="email"  class="form-control">
                        </div>
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
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-warning">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <strong>Warning! </strong> <c:out value="${requestScope.message}" />
                </div>
            </c:if>
        </div>
    </div><!--/row-->
</div><!--/container-->
</body>
</html>
