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
       window.onload = function(){
           $('#check').on('click', function () {
               var IsChecked = !! $('.category:checked').length;
               var value = $('#key').val();
               if(IsChecked && value.length > 0){
                   return true;
               }
               else
               {
                   if(!IsChecked){
                       $('#msg').show();
                   }
                   if(value.length==0){
                       $('#msg_len').show();
                   }
                   return false;
               }
               return true;
           });
       }
    </script>
</head>
<body>
<div class="search-block parallaxBg" style="background-position: 50% 16px;">
    <div class="container">
        <div class="col-md-6 col-md-offset-3">
            <h1>Discover <span class="color-green">new</span> things ...</h1>
            <form id="interviewForm" action="search" class="sky-form page-search-form" method="POST">
            <div class="input-group">
                <%--<div class="form-group">--%>
                    <input type="text" id="key" name="key" class="form-control" placeholder="Search what you need ..."/>
                <%--</div>--%>
                        <span class="input-group-btn">
                            <button id="check" class="btn-u" type="submit" name="submit"><i class="fa fa-search"></i></button>
                        </span>

            </div>
                <div class="inline-group">
                    <label class="checkbox"><input type="radio" name="search_key" value="title" id="title" class="category"><i></i>Title</label>
                    <label class="checkbox"><input type="radio" name="search_key" value="author" id="author" class="category"><i></i>Author</label>
                    <label class="checkbox"><input type="radio" name="search_key" value="publisher" id="publisher" class="category"><i></i>Publisher</label>
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
                        <img class="img-responsive" src="uploads/books/<c:out value="${book.photo}"/>" alt="" />
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
<c:if test="${requestScope.message!=null}">
<div class="alert alert-info">
    <button type="button" class="close" data-dismiss="alert">×</button>
    <strong>Sorry, </strong><c:out value="${requestScope.message}" />
</div>
</c:if>
<div class="alert alert-warning" id="msg" style="display: none">
    <button type="button" class="close" data-dismiss="alert">×</button>
    Please choose any category you are trying to search
</div>
<div class="alert alert-warning" id="msg_len" style="display: none">
    <button type="button" class="close" data-dismiss="alert">×</button>
    Please enter any search keyword
</div>
<!--=== End Content Part ===-->

</body>
</html>
