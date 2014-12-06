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
                    tag: {
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
                    price: {
                        validators: {
                            integer: {
                                message: 'Enter valid price'
                            }
                        }
                    },
                    contact_no: {
                        validators: {
                            regexp: {
                                regexp: '^([0-9\(\)\/\+ \-]*)$',
                                message: 'Enter a valid phone number'
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
            <form id= "regexpForm" class="sky-form" method="post" action="addbook" enctype="multipart/form-data">
                <header>Add Post</header>
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
                            <select name="dept_id" class="form-control">
                                <c:forEach var="dept" items="${requestScope.deptList}" varStatus="deptStatus">
                                    <option value="<c:out value="${dept.deptId}"/>"><c:out
                                            value="${dept.deptName}"/></option>
                                </c:forEach>
                            </select>
                        </section>

                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="author" placeholder="Author">
                                </label>
                            </div>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="tag" placeholder="Tag">
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
                                <label class="input">
                                    <input type="text" name="price" placeholder="Price">
                                </label>
                            </div>
                        </section>
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
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <div class="form-group">
                                <label class="input">
                                    <input type="text" name="contact_no" placeholder="Contact No">
                                </label>
                            </div>
                        </section>
                        <section class="col col-6">
                            <div class="form-group">
                            <label class="input">
                                <input type="text" name="contact_address" placeholder="Contact Address">
                            </label>
                            </div>
                        </section>
                    </div>

                </fieldset>
                <fieldset>

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
