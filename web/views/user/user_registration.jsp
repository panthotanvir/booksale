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
</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id= "sky-form" class="sky-form" method="post" action="adduser" enctype="multipart/form-data">
                <header>User Registration</header>

                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="user_name" placeholder="User name">
                            </label>
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
                            <label class="input">

                                <input type="text" name="email" placeholder="email">
                            </label>
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
                            <label class="input">

                                <input type="text" name="phone" placeholder="phone no">
                            </label>
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

                            <label class="input">
                                <input type="file" name="photo">
                            </label>

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
