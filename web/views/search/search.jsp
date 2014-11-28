<%--

  User: mithunshawon
  Date: 11/28/14
  Time: 12:35 PM

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
    <style>
        .fa{
            line-height: 1.6;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function(){

        });
    </script>
</head>
<body>
<div class="search-block parallaxBg" style="background-position: 50% 16px;">
    <div class="container">
        <div class="col-md-6 col-md-offset-3">
            <h1>Discover <span class="color-green">new</span> things ...</h1>
            <form action="search" class="sky-form page-search-form" method="POST">
            <div class="input-group">
                <input type="text" name="key" class="form-control" placeholder="Search what you need ...">
                    <span class="input-group-btn">
                        <button id="btn" class="btn-u" type="submit" name="submit"><i class="fa fa-search"></i></button>

                    </span>
            </div>

            <div class="inline-group">
                <label class="checkbox"><input type="radio" name="search_key" value="title" id="title"><i></i>Title</label>
                <label class="checkbox"><input type="radio" name="search_key" value="author" id="author"><i></i>Author</label>
                <label class="checkbox"><input type="radio" name="search_key" value="publisher" id="publisher"><i></i>Publisher</label>
            </div>
            </form>
        </div>

    </div>
</div>


<!--/container-->
<div class="container content">
    <div class="row">
        <c:if test="${requestScope.bookList != null}">
            <c:forEach var="book" items="${requestScope.bookList}" varStatus="item">
                <div class="col-md-3">
                    <div class="view view-tenth">
                        <img class="img-responsive" src="uploads/<c:out value="${book.photo}"/>.jpg" alt="" />
                        <div class="mask">
                            <h2><c:out value="${book.title}"/></h2>
                            <h4><c:out value="${book.author}"/></h4>
                            <a href="singleBook?bookId=${book.bookId}" class="info">View Details</a>
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
