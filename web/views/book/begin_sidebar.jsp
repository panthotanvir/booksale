<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3">
    <ul class="list-group sidebar-nav-v1" id="sidebar-nav">
        <!-- Typography -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-typography">Book Category</a>
            <ul id="collapse-typography" class="collapse">
                <li><a href="sidebar"><i class="fa fa-sort-alpha-asc"></i>Latest Book</a></li>
                <li><a href="sidebar"><i class="fa fa-sort-alpha-asc"></i>Rated Book</a></li>
                <li><a href="sidebar"><i class="fa fa-sort-alpha-asc"></i>All Book</a></li>
                <c:if test="${sessionScope.isUser}">
                    <li><a href="userhome"><i class="fa fa-sort-alpha-asc"></i>Departmental Book</a></li>
                </c:if>
            </ul>
        </li>
        <!-- End Typography -->

        <!-- Buttons UI -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-buttons">University</a>
            <ul id="collapse-buttons" class="collapse">
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Public University</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Private University</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Engineering University</a></li>
            </ul>
        </li>
        <!-- End Buttons UI -->

        <!-- Icons -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-icons">Locations</a>
            <ul id="collapse-icons" class="collapse">
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Dhaka</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Khulna</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Chittagong</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Rajshahi</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Barisal</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Sylhet</a></li>
                <li><a href="feature_btn_general.html"><i class="fa fa-flask"></i> Rangpur</a></li>
            </ul>
        </li>
        <!-- End Icons -->




    </ul>
</div>
