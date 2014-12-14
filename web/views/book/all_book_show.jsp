<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/23/14
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Books</title>

</head>
<body>

<!--=== Search Results ===-->
<div class="container content">
    <div class="row">
        <!-- Begin Sidebar Menu -->
        <jsp:include page="begin_sidebar.jsp"/>

        <!-- Begin Content -->

        <div class="container content">
            <div class="row">
                <c:if test="${requestScope.bookList != null}">
                    <c:forEach var="book" items="${requestScope.bookList}" varStatus="item">
                        <div class="col-md-3">
                            <div class="view view-tenth">
                                <img class="img-responsive" src="uploads/books/<c:out value="${book.photo}"/>" alt="" />
                                <div class="mask">

                                    <a href="singleBook?bookId=${book.bookId}" class="info">View Details</a>
                                    <h2><c:out value="${book.title}"/></h2>
                                    <h4><c:out value="${book.author}"/></h4>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div><!--/row-->
        </div><!--/container-->

        <!-- End Content -->
    </div>
</div><!--/container-->
<!--=== End Search Results ===-->

</body>
</html>
