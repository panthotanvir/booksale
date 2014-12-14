<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/22/14
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post</title>
    <style>
        .has-feedback .form-control-feedback{
            top:0;
        }
        .sky-form{
            border: 1px solid #2ecc71;
        }
        .sky-form header{
            background-color: #2ecc71;
            color: #ffffff;
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
                    title: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            }
                        }
                    },
                    type: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            }
                        }
                    },
                    author: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            }
                        }
                    },
                    publisher: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            }
                        }
                    },
                    edition: {
                        validators: {
                            regexp: {
                                regexp: /^[a-z\s]+$/i,
                                message: 'Alphabetical characters and spaces only'
                            }
                        }
                    },
                    price: {
                        validators: {
                            integer: {
                                message: 'Enter valid price'
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
            function GiveAlert(){
                alert("You are successfully registered");
            }
        }
    </script>

</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id= "regexpForm" class="sky-form" method="post" action="addbook" enctype="multipart/form-data">
                <header>Post Book Ad</header>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="title" placeholder="Title">
                                </label>
                            </div>
                        </section>

                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="type" placeholder="Category">
                                </label>
                            </div>
                        </section>
                    </div>

                    <div class="row">
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="author" placeholder="Author">
                                </label>
                            </div>
                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="publisher" placeholder="Publisher">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <select name="division" class="form-control">
                                <c:forEach var="division" items="${requestScope.divList}">
                                    <option value="<c:out value="${division.divisionId}"/>">
                                        <c:out value="${division.divisionName}"/></option>
                                </c:forEach>
                            </select>
                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="price" placeholder="Price">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section>
                            <label class="textarea textarea-expandable">
                                <textarea placeholder="Book Description" name="description" rows="3"></textarea>
                            </label>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                       <section class="col col-6">
                            <div class="form-group">
                            <label class="input input-file">
                                <div class="button">
                                    <input type="file" id="file" name="photo"
                                           onchange="this.parentNode.nextSibling.value = this.value">Browse
                                </div>
                                <input type="text" readonly="" value="Less then 1 MB">
                            </label>
                            </div>
                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="edition" placeholder="Edition">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <button class="btn-u"  name="add"  type="submit" onclick="GiveAlert()">Submit</button>
                        </section>
                    </div>
                </fieldset>
            </form>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-warning">
                    <button data-dismiss="alert" class="close" type="button">×</button>
                    <strong>Warning! </strong> <c:out value="${requestScope.message}" />
                </div>
            </c:if>
        </div>
    </div>
</div>


</body>
</html>
