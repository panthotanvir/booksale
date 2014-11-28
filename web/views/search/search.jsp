<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/28/14
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <style>
        .fa{
            line-height: 1.6;
        }
    </style>
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
                        <button class="btn-u" type="submit" name="submit" ><i class="fa fa-search"></i></button>

                    </span>
            </div>


            <div class="inline-group">
                <label class="checkbox"><input type="radio" name="search_key" value="title"><i></i>Title</label>
                <label class="checkbox"><input type="radio" name="search_key" value="author"><i></i>Author</label>
                <label class="checkbox"><input type="radio" name="search_key" value="publisher"><i></i>Publisher</label>
            </div>
            </form>
        </div>

    </div>
</div>

</body>
</html>
