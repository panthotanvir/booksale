<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 11/25/14
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Overview</title>
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
                <!--Service Block v3-->
                <div class="row margin-bottom-10">
                    <div class="col-sm-6 sm-margin-bottom-20">
                        <div class="service-block-v3 servive-block-u">
                            <i class="icon-users"></i>
                            <span class="service-heading">Overall Requested books</span>
                            <span class="counter">52</span>

                            <div class="clearfix margin-bottom-10"></div>

                            <div class="statistics">
                                <h3 class="heading-xs">Statistics in Progress Bar <span class="pull-right">67%</span></h3>
                                <div class="progress progress-u progress-xxs">
                                    <div style="width: 67%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="67" role="progressbar" class="progress-bar progress-bar-light">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <div class="service-block-v3 servive-block-blue">
                            <i class="icon-screen-desktop"></i>
                            <span class="service-heading">Overall Posted Book</span>
                            <span class="counter">3</span>

                            <div class="clearfix margin-bottom-10"></div>


                            <div class="statistics">
                                <h3 class="heading-xs">Statistics in Progress Bar <span class="pull-right">89%</span></h3>
                                <div class="progress progress-u progress-xxs">
                                    <div style="width: 89%" aria-valuemax="100" aria-valuemin="0" aria-valuenow="89" role="progressbar" class="progress-bar progress-bar-light">
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div><!--/end row-->
                <!--End Service Block v3-->

                <hr>

                <div class="row margin-bottom-20">
                    <!--Profile Post-->
                    <div class="col-sm-6">
                        <div class="panel panel-profile no-bg">
                            <div class="panel-heading overflow-h">
                                <h2 class="panel-title heading-sm pull-left"><i class="fa fa-pencil"></i>Requested Book List</h2>
                                <a href="#"><i class="fa fa-cog pull-right"></i></a>
                            </div>
                            <div id="scrollbar" class="panel-body contentHolder">
                                <div class="profile-post color-one">
                                    <span class="profile-post-numb">01</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Creative Blog</a></h3>
                                        <p>How to market yourself as a freelance designer</p>
                                    </div>
                                </div>
                                <div class="profile-post color-two">
                                    <span class="profile-post-numb">02</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Codrops Collective #117</a></h3>
                                        <p>Web Design &amp; Development News</p>
                                    </div>
                                </div>
                                <div class="profile-post color-three">
                                    <span class="profile-post-numb">03</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Sketch Toolbox</a></h3>
                                        <p>Basic prototype of a package manager for Sketch</p>
                                    </div>
                                </div>
                                <div class="profile-post color-four">
                                    <span class="profile-post-numb">04</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Amazing Portfolio</a></h3>
                                        <p>Create a free online portfolio lookbook with Readz</p>
                                    </div>
                                </div>
                                <div class="profile-post color-five">
                                    <span class="profile-post-numb">05</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Discover New Features</a></h3>
                                        <p>More than 100+ amazing add-ons coming soon...</p>
                                    </div>
                                </div>
                                <div class="profile-post color-six">
                                    <span class="profile-post-numb">06</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Corporation Plans</a></h3>
                                        <p>Discussion of new corporation plans</p>
                                    </div>
                                </div>
                                <div class="profile-post color-seven">
                                    <span class="profile-post-numb">07</span>
                                    <div class="profile-post-in">
                                        <h3 class="heading-xs"><a href="#">Project Updates</a></h3>
                                        <p>New features of coming update</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End Profile Post-->

                    <!--Profile Event-->
                    <div class="col-sm-6 md-margin-bottom-20">
                        <div class="panel panel-profile no-bg">
                            <div class="panel-heading overflow-h">
                                <h2 class="panel-title heading-sm pull-left"><i class="fa fa-briefcase"></i>Posted Book List</h2>
                                <a href="#"><i class="fa fa-cog pull-right"></i></a>
                            </div>
                            <div id="scrollbar2" class="panel-body contentHolder">
                                <div class="profile-event">
                                    <div class="date-formats">
                                        <span>25</span>
                                        <small>05, 2014</small>
                                    </div>
                                    <div class="overflow-h">
                                        <h3 class="heading-xs"><a href="#">GitHub seminars in Japan.</a></h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry printing.</p>
                                    </div>
                                </div>
                                <div class="profile-event">
                                    <div class="date-formats">
                                        <span>31</span>
                                        <small>06, 2014</small>
                                    </div>
                                    <div class="overflow-h">
                                        <h3 class="heading-xs"><a href="#">Bootstrap Update</a></h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry printing.</p>
                                    </div>
                                </div>
                                <div class="profile-event">
                                    <div class="date-formats">
                                        <span>07</span>
                                        <small>08, 2014</small>
                                    </div>
                                    <div class="overflow-h">
                                        <h3 class="heading-xs"><a href="#">Apple Conference</a></h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry printing.</p>
                                    </div>
                                </div>
                                <div class="profile-event">
                                    <div class="date-formats">
                                        <span>22</span>
                                        <small>10, 2014</small>
                                    </div>
                                    <div class="overflow-h">
                                        <h3 class="heading-xs"><a href="#">Backend Meeting</a></h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry printing.</p>
                                    </div>
                                </div>
                                <div class="profile-event">
                                    <div class="date-formats">
                                        <span>14</span>
                                        <small>11, 2014</small>
                                    </div>
                                    <div class="overflow-h">
                                        <h3 class="heading-xs"><a href="#">Google Conference</a></h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry printing.</p>
                                    </div>
                                </div>
                                <div class="profile-event">
                                    <div class="date-formats">
                                        <span>05</span>
                                        <small>12, 2014</small>
                                    </div>
                                    <div class="overflow-h">
                                        <h3 class="heading-xs"><a href="#">FontAwesome Update</a></h3>
                                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry printing.</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End Profile Event-->
                </div><!--/end row-->

                <hr>


            </div>
            <!--End Profile Body-->
        </div>
    </div><!--/end row-->
</div><!--/container-->
<!--=== End Profile ===-->
</body>
</html>
