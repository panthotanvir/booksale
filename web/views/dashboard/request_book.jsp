<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/29/14
  Time: 11:45 PM
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
            <!-- start left sideber-->
            <jsp:include page="left_sidebar.jsp"/>
            <!--End Left Sidebar-->

            <div class="col-md-9">
                <div class="shadow-wrapper margin-bottom-60">
                    <div class="tag-box tag-box-v1 box-shadow shadow-effect-2">
                        <h2>Request For Your Desired Book</h2>
                        <form class="footer-subsribe" action="request" method="post">

                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Title of your book" name = "title">
                            <span class="input-group-btn">
                                <button class="btn-u"  type="submit">Go</button>
                            </span>
                            </div>
                        </form>
                    </div>
                </div>
                <!--Profile Event-->
                <div class="col-md-12">
                    <div class="panel panel-sea margin-bottom-40">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-edit"></i> My Request List</h3>
                        </div>
                        <table class="table table-hover">
                            <thead>
                            <tr>

                                <th>Date</th>
                                <th>Book Title</th>
                                <th>Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${requestScope.requestInfo != null}">
                                <c:forEach var="requestBook" items="${requestScope.requestInfo}" varStatus="item">
                                    <form class="sky-form" method="post" action="deleteRequest">
                                        <tr>
                                            <input type="hidden" name="request_id" value="<c:out value="${requestBook.requestId}"/>">
                                            <td><c:out value="${requestBook.date}"/></td>
                                            <td><c:out value="${requestBook.title}"/></td>
                                            <td><button class="btn btn-danger btn-xs" type="submit"><i class="fa fa-trash-o"></i> Delete</button></td>
                                        </tr>
                                    </form>
                                </c:forEach>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>


                <!--End Profile Event-->

            </div>
        </div>
    </div>
</div>

</body>
</html>
