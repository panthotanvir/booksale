<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/25/14
  Time: 3:12 PM
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

        <div class="col-md-9">
            <!--Profile Body-->
            <div class="profile-body">
                <!--Timeline-->
                <ul class="timeline-v2">
                    <li>
                        <time class="cbp_tmtime" datetime=""><span>4/1/08</span> <span>January</span></time>
                        <i class="cbp_tmicon rounded-x hidden-xs"></i>
                        <div class="cbp_tmlabel">
                            <h2>Book Title</h2>
                            <div class="row">
                                <div class="col-md-4">
                                    <img class="img-responsive" src="assets/img/job/high-rated-job-3.1.jpg" alt="">
                                    <div class="md-margin-bottom-20"></div>
                                </div>
                                <div class="col-md-8">
                                    <h3>Price : 550</h3>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <time class="cbp_tmtime" datetime=""><span>4/1/08</span> <span>January</span></time>
                        <i class="cbp_tmicon rounded-x hidden-xs"></i>
                        <div class="cbp_tmlabel">
                            <h2>Book Title</h2>
                            <div class="row">
                                <div class="col-md-4">
                                    <img class="img-responsive" src="assets/img/job/high-rated-job-3.1.jpg" alt="">
                                    <div class="md-margin-bottom-20"></div>
                                </div>
                                <div class="col-md-8">
                                    <h3>Price : 550</h3>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <time class="cbp_tmtime" datetime=""><span>4/1/08</span> <span>January</span></time>
                        <i class="cbp_tmicon rounded-x hidden-xs"></i>
                        <div class="cbp_tmlabel">
                            <h2>Book Title</h2>
                            <div class="row">
                                <div class="col-md-4">
                                    <img class="img-responsive" src="assets/img/job/high-rated-job-3.1.jpg" alt="">
                                    <div class="md-margin-bottom-20"></div>
                                </div>
                                <div class="col-md-8">
                                    <h3>Price : 550</h3>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
                <!--End Timeline-->
            </div>
            <!--End Profile Body-->
        </div>
    </div><!--/end row-->
</div><!--/container-->
<!--=== End Profile ===-->
</body>
</html>
