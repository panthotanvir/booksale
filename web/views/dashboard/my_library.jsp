<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/25/14
  Time: 12:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!--=== Profile ===-->
<div class="profile container content">
    <div class="row">
        <!--Left Sidebar-->
        <jsp:include page="left_sidebar.jsp"/>
        <!--End Left Sidebar-->
        <div class="col-md-8">
            <ul>
                <c:if test="${requestScope.libraryBook != null}">
                    <c:forEach var="book" items="${requestScope.libraryBook}" varStatus="item">
                        <li class="col-md-3 col-sm-6 col-xs-12 mix category_3 category_2">

                            <div class="item">
                                <div class="thumbnails thumbnail-style thumbnail-kenburn">
                                    <div class="thumbnail-img">
                                        <div class="overflow-hidden">
                                            <img class="img-responsive" src="uploads/books/<c:out value="${book.photo}"/>" alt="">
                                        </div>
                                        <a class="btn-more hover-effect" href="singleBook?bookId=${book.bookId}">Details</a>
                                    </div>
                                    <div class="caption">
                                        <h3><c:out value="${book.title}"/></h3>
                                        <p>price: <c:out value="${book.price}"/></p>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                </c:if>

            </ul>
        </div>

            <!--End Profile Body-->
        </div>
    </div><!--/end row-->
</div><!--/container-->
<!--=== End Profile ===-->
</body>
</html>
