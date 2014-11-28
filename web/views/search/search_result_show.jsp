<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/28/14
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div class="container content">
    <div class="row">
        <c:if test="${requestScope.bookList != null}">
        <c:forEach var="book" items="${requestScope.bookList}" varStatus="item">
        <div class="col-md-4">
            <div class="view view-tenth">
                <img class="img-responsive" src="uploads/<c:out value="${book.photo}"/>.jpg" alt="" />
                <div class="mask">
                    <h2><c:out value="${book.title}"/></h2>
                    <p>At vero eos et accusamus et iusto odio dignissimos dolores et quas molestias excepturi sint occaecati cupiditate non provident.</p>
                    <a href="portfolio_item.html" class="info">Read More</a>
                </div>
            </div>
        </div>
        </c:forEach>
        </c:if>
    </div><!--/row-->
</div><!--/container-->
<!--=== End Content Part ===-->
</body>
</html>
