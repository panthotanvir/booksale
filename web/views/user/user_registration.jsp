<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/22/14
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
    <style>
        .has-feedback .form-control-feedback{
            top:0;
        }
    </style>
    <script>
        window.onload = function(){
            $('#regexpForm').bootstrapValidator({
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    user_name: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            }
                        }
                    },
                    email: {
                        validators: {
                            regexp: {
                                regexp: '^[^@\\s]+@([^@\\s]+\\.)+[^@\\s]+$',
                                message: 'Enter valid email address'
                            }
                        }
                    },
                    phone: {
                        validators: {
                            regexp: {
                                regexp: '^([0-9\(\)\/\+ \-]*)$',
                                message: 'Enter valid phone number'
                            }
                        }
                    },
                    photo: {
                        validators: {
                            file: {
                                extension: 'jpg,jpeg,png',
                                type: 'image.jpg,image/jpeg,image/png',
                                maxSize: 1048576,   // 1048 * 1024
                                message: 'The selected file is not valid'
                            }
                        }
                    }
                }
            });
        }
    </script>


</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id= "regexpForm" class="sky-form" method="post" action="adduser" enctype="multipart/form-data">
                <header>User Registration</header>

                <fieldset>
                    <div class="row">
                            <section class="col col-6">
                                <div class="form-group">
                                <label class="input">
                                    <input type="text" name="user_name" placeholder="User name">
                                </label>
                                </div>
                            </section>
                        <section class="col col-6">
                                <select name="uni_id" class="form-control">
                                    <c:forEach var="uni" items="${requestScope.uniList}" varStatus="uniStatus">
                                        <option value="<c:out value="${uni.id}"/>"><c:out value="${uni.uniName}"/></option>
                                    </c:forEach>
                                </select>

                        </section>
                    </div>

                    <div class="row">
                        <section class="col col-6">

                                <select name="dept_id" class="form-control">
                                    <c:forEach var="dept" items="${requestScope.deptList}" varStatus="deptStatus">
                                        <option value="<c:out value="${dept.deptId}"/>"><c:out value="${dept.deptName}"/></option>
                                    </c:forEach>
                                </select>

                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                            <label class="input">
                                <input type="text" name="email" placeholder="email">
                            </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="password" name="password" placeholder="password">
                            </label>
                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                            <label class="input">
                                <input type="text" name="phone" placeholder="phone no">
                            </label>
                            </div>
                        </section>
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="address" placeholder="address">
                            </label>
                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                            <label class="input input-file">
                                <div class="button">
                                    <input type="file" id="file" name="photo">Browse
                                </div>
                                <input type="text" readonly="" value="Less then 1 MB">
                            </label>
                            </div>
                        </section>

                    </div>

                    <div class="row">
                        <section class="col col-6">

                            <label class="input">
                                <button type="submit" name="submit" class="btn-u">Submit</button>
                            </label>

                        </section>

                    </div>
                </fieldset>
            </form>

        </div>
    </div>
</div>


</body>
</html>
