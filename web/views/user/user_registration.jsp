<%--
  Created by IntelliJ IDEA.
  User: mithunshawon
  Date: 11/22/14
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<div class="container content">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form id= "sky-form" class="sky-form" method="post" action="adduser">
                <header>User Registration</header>

                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="user_name" placeholder="User name">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">
                                <!-- select option will use  , drop down usable-->
                                <input type="text" name="uni_id" placeholder="uni_id">
                            </label>
                        </section>
                    </div>

                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="dept_id" placeholder="Dept id">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="email" placeholder="email">
                            </label>
                        </section>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="password" name="password" placeholder="password">
                            </label>
                        </section>
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="phone" placeholder="phone no">
                            </label>
                        </section>
                    </div>

                </fieldset>
                <fieldset>
                    <div class="row">
                        <section class="col col-6">
                            <label class="input">

                                <input type="text" name="address" placeholder="address">
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
