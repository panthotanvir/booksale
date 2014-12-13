<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 12/12/14
  Time: 12:11 PM
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
                <!-- exchange -->
                <form action="exchange" method="post" id="sky-form3" class="sky-form">
                    <header>Exchange My Book</header>

                    <fieldset>
                        <section>
                            <label class="label">Exchange To</label>
                            <label class="input">
                                <i class="icon-append fa fa-book"></i>
                                <input type="text" name="exchange_to"  placeholder="Give your book name . . .">
                            </label>
                        </section>
                        <section>
                            <label class="label">Exchange With</label>
                            <label class="input">
                                <i class="icon-append fa fa-book"></i>
                                <input type="text" name="exchange_with"  placeholder="Give your book name . . .">
                            </label>
                        </section>

                        <section>
                            <label class="label">Exchange Details</label>
                            <label class="textarea">
                                <i class="icon-append fa fa-comment"></i>
                                <textarea rows="4" name="detail"></textarea>
                            </label>
                        </section>
                    </fieldset>

                    <footer>
                        <button type="submit" class="button" name="submit">Submit</button>
                    </footer>

                </form>
                <!-- Exchange book -->
                <!--Profile Event-->


                    <div class="col-md-12">
                        <div class="panel panel-sea margin-bottom-40">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-edit"></i> My Exchange List</h3>
                            </div>
                            <table class="table table-hover">
                                <thead>
                                <tr>

                                    <th>Exchange To</th>
                                    <th>Exchange With</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${requestScope.exchangeList != null}">
                                    <c:forEach var="exchangeBook" items="${requestScope.exchangeList}" varStatus="item">
                                        <form class="sky-form" method="post" action="deleteExchange">
                                            <tr>
                                                <input type="hidden" name="exchange_id" value="<c:out value="${exchangeBook.exchangeId}"/>">
                                                <td><c:out value="${exchangeBook.exchangeTo}"/></td>
                                                <td><c:out value="${exchangeBook.exchangeWith}"/></td>
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
