<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 12/13/14
  Time: 9:23 PM
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
            <jsp:include page="begin_sidebar.jsp"/>
            <!--End Left Sidebar-->

            <div class="col-md-9">

                <!--Profile Event-->
                <div class="col-md-12">
                    <div class="panel panel-sea margin-bottom-40">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-edit"></i> Exchange List</h3>
                        </div>
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>User Name</th>
                                <th>Date</th>
                                <th>Exchange To</th>
                                <th>Exchange With</th>
                                <th>Detail</th>
                                <th>Contact No</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${requestScope.exchangeList!= null}">
                                <c:forEach var="exchangeList" items="${requestScope.exchangeList}" varStatus="item">
                                    <form class="sky-form" method="post" action="deleteRequest">
                                        <tr>
                                            <td><c:out value="${exchangeList.user.userName}"/></td>
                                            <td><c:out value="${exchangeList.book.exchangeDate}"/></td>
                                            <td><c:out value="${exchangeList.book.exchangeTo}"/></td>
                                            <td><c:out value="${exchangeList.book.exchangeWith}"/></td>
                                            <td><c:out value="${exchangeList.book.detail}"/></td>
                                            <td><c:out value="${exchangeList.user.contactNo}"/></td>

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
