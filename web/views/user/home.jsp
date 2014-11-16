<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
<div class="basic-grey">
    This is HOME
</div>
<table>
    <th>University List</th>
    <c:if test="${requestScope.uniList != null}">
    <c:forEach var="uni" items="${requestScope.uniList}" varStatus="item">
            <tr>
                <form action="#" method="post">
                    <td><c:out value="${uni.uniName}"/></td>

                </form>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>
