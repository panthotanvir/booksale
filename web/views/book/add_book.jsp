<%--
  Created by IntelliJ IDEA.
  User: panthotanvir
  Date: 11/22/14
  Time: 7:01 PM
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
        <div class="col-md-6 col-md-offset-3">
            <form id= "sky-form" class="sky-form" method="post" action="addbook" >
                <header>Add Post</header>

                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="user_id" placeholder="User Id">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">
                                <!-- select option will use  , drop down usable-->
                                <input type="text" name="dept_id" placeholder="Dept Id">
                            </label>
                        </section>
                    </div>

                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="title" placeholder="Title">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="author" placeholder="Author">
                            </label>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="tag" placeholder="Tag">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="publisher" placeholder="Publisher">
                            </label>
                        </section>
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="type" placeholder="Type">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="description" placeholder="Description">
                            </label>
                        </section>
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="price" placeholder="Price">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="photo" placeholder="Photo">
                            </label>
                        </section>
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="contact_no" placeholder="contact_no">
                            </label>
                        </section>
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="contact_address" placeholder="contact_address">
                            </label>
                        </section>

                    </div>

                    <div class="row">
                        <section class="col col-6">

                            <label class="input">
                                <button type="submit" name="submit" class="btn-u">Submit</button>
                            </label>

                        </section>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>
</div>


</body>
</html>
