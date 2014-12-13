<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/25/14
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!--=== Profile ===-->
<div class="profile">
    <div class="container content">
        <div class="row">
            <!--Left Sidebar-->
            <jsp:include page="left_sidebar.jsp"/>

            <!--End Left Sidebar-->

            <div class="col-md-9">
                <!--Profile Body-->
                <div class="profile-body margin-bottom-20">
                    <div class="tab-v1">
                        <ul class="nav nav-justified nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#profile">Edit Profile</a></li>
                            <li><a data-toggle="tab" href="#password">Change Password</a></li>
                            <li><a data-toggle="tab" href="#contact">Edit Contact information</a></li>
                            <li><a data-toggle="tab" href="#delete">Delete Book Post</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="profile" class="profile-edit tab-pane fade in active">
                                <h2 class="heading-md">Manage your Name, Department and University.</h2>

                                </br>
                                <form class="sky-form" method="post" action="updateuser">
                                    <dl class="dl-horizontal">

                                        <dt>User Name</dt>
                                        <dd>
                                            <section>
                                                <label class="input">
                                                    <i class="icon-append fa fa-envelope"></i>
                                                    <input type="text" name="user_name" value="<c:out value="${requestScope.settingInfo.user.userName}"/>"/>
                                                    <b class="tooltip tooltip-bottom-right">Needed to verify your username</b>
                                                </label>
                                            </section>
                                        </dd>
                                        <dt>Enter Your Department</dt>
                                        <dd>
                                            <section>
                                                <label class="input">

                                                    <select name="dept_id" class="form-control">
                                                        <c:forEach var="dept" items="${requestScope.deptList}" varStatus="deptStatus">
                                                            <option value="<c:out value="${dept.deptId}"/>"><c:out value="${dept.deptName}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                    <b class="tooltip tooltip-bottom-right">Needed to verify your Department</b>
                                                </label>
                                            </section>
                                        </dd>
                                        <dt>Enter Your University</dt>
                                        <dd>
                                            <section>
                                                <label class="input">

                                                    <select name="uni_id" class="form-control">
                                                        <c:forEach var="uni" items="${requestScope.uniList}" varStatus="uniStatus">
                                                            <option value="<c:out value="${uni.id}"/>"><c:out value="${uni.uniName}"/></option>
                                                        </c:forEach>
                                                    </select>
                                                    <b class="tooltip tooltip-bottom-right">Needed to verify your University</b>
                                                </label>
                                            </section>
                                        </dd>
                                    </dl>
                                    <input type="hidden" name="flag" value="1" />
                                    <button type="button" class="btn-u btn-u-default">Cancel</button>
                                    <button class="btn-u" type="submit">Save Changes</button>
                                </form>

                            </div>

                            <div id="password" class="profile-edit tab-pane fade">
                                <h2 class="heading-md">Manage your Security Settings</h2>
                                <p>Change your password.</p>
                                </br>
                                <form class="sky-form"  method="post" action="updateuser">
                                    <dl class="dl-horizontal">

                                        <dt>Email address</dt>
                                        <dd>
                                            <section>
                                                <label class="input">
                                                    <i class="icon-append fa fa-envelope"></i>
                                                    <input type="email" name="email" value="<c:out value="${requestScope.settingInfo.user.email}"/>">
                                                    <b class="tooltip tooltip-bottom-right">Needed to verify your account</b>
                                                </label>
                                            </section>
                                        </dd>
                                        <dt>Enter your password</dt>
                                        <dd>
                                            <section>
                                                <label class="input">
                                                    <i class="icon-append fa fa-lock"></i>
                                                    <input type="password"  name="password" value="<c:out value="${requestScope.settingInfo.user.password}"/>">
                                                    <b class="tooltip tooltip-bottom-right">Don't forget your password</b>
                                                </label>
                                            </section>
                                        </dd>

                                    </dl>
                                    <input type="hidden" name="flag" value="2" />

                                    <button type="button" class="btn-u btn-u-default">Cancel</button>
                                    <button class="btn-u" type="submit">Save Changes</button>
                                </form>
                            </div>

                            <div id="contact" class="profile-edit tab-pane fade">
                                <h2 class="heading-md">Manage your Contact Information</h2>

                                </br>
                                <form class="sky-form" method="post" action="updateuser">
                                    <dl class="dl-horizontal">

                                        <%--<dt>Email</dt>--%>
                                        <%--<dd>--%>
                                            <%--<section>--%>
                                                <%--<label class="input">--%>
                                                    <%--<i class="icon-append fa fa-envelope"></i>--%>
                                                    <%--<input type="email" placeholder="Email address" name="email" value="<c:out value="${requestScope.settingInfo.user.email}"/>">--%>
                                                    <%--<b class="tooltip tooltip-bottom-right">Needed to verify your account</b>--%>
                                                <%--</label>--%>
                                            <%--</section>--%>
                                        </dd>
                                        <dt>Phone No</dt>
                                        <dd>
                                            <section>
                                                <label class="input">
                                                    <i class="icon-append fa fa-lock"></i>
                                                    <input type="text" id="phone" placeholder="Contact" name="phone" value="<c:out value="${requestScope.settingInfo.user.phoneNo}"/>">
                                                    <b class="tooltip tooltip-bottom-right">Needed to verify your Contact</b>
                                                </label>
                                            </section>
                                        </dd>
                                        <dt>Address</dt>
                                        <dd>
                                            <section>
                                                <label class="input">
                                                    <i class="icon-append fa fa-lock"></i>
                                                    <input type="text" placeholder="Address" name="address" value="<c:out value="${requestScope.settingInfo.user.address}"/>">
                                                    <b class="tooltip tooltip-bottom-right">Needed to verify your Address</b>
                                                </label>
                                            </section>
                                        </dd>
                                    </dl>
                                    <input type="hidden" name="flag" value="3" />
                                    <button type="button" class="btn-u btn-u-default">Cancel</button>
                                    <button class="btn-u" type="submit">Save Changes</button>
                                </form>
                            </div>

                            <div id="delete" class="profile-edit tab-pane fade">
                                <div class="col-md-12">
                                    <div class="panel panel-sea margin-bottom-40">
                                        <div class="panel-heading">
                                            <h3 class="panel-title"><i class="fa fa-edit"></i> My Exchange List</h3>
                                        </div>
                                        <table class="table table-hover">
                                            <thead>
                                            <tr>

                                                <th>Book Title</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:if test="${requestScope.bookList != null}">
                                                <c:forEach var="bookList" items="${requestScope.bookList}" varStatus="item">
                                                    <form class="sky-form" method="post" action="updateuser">
                                                        <tr>
                                                            <input type="hidden" name="flag" value="4" />
                                                            <input type="hidden" name="book_id" value="<c:out value="${bookList.bookId}"/>">

                                                            <td><c:out value="${bookList.title}"/></td>

                                                            <td><button class="btn btn-danger btn-xs" type="submit"><i class="fa fa-trash-o"></i> Delete</button></td>
                                                        </tr>
                                                    </form>
                                                </c:forEach>
                                            </c:if>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!--End Profile Body-->
            </div>
        </div><!--/end row-->
    </div><!--/container-->
</div>
<!--=== End Profile ===-->
</body>
</html>
