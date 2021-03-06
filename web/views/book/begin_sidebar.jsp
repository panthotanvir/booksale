<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-3">
    <ul class="list-group sidebar-nav-v1" id="sidebar-nav">
        <!-- Typography -->

        <!-- End Typography -->

        <!-- Buttons UI -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-buttons">University</a>
            <ul id="collapse-buttons" class="collapse">
                <li><a href="university?uniType=1"><i class="fa fa-university"></i> Public University</a></li>
                <li><a href="university?uniType=2"><i class="fa fa-university"></i> Private University</a></li>
                <li><a href="university?uniType=3"><i class="fa fa-university"></i> Engineering University</a></li>
            </ul>
        </li>
        <!-- End Buttons UI -->

        <!-- Icons -->
        <li class="list-group-item list-toggle">
            <a data-toggle="collapse" data-parent="#sidebar-nav" href="#collapse-icons">Locations</a>
            <ul id="collapse-icons" class="collapse">
                <c:if test="${requestScope.divisionList != null}">
                    <c:forEach var="division" items="${requestScope.divisionList}" varStatus="item">
                        <li><a href="division?divisionId=${division.divisionId}"><i class="fa fa-university"></i><c:out value="${division.divisionName}"/></a></li>
                    </c:forEach>
                </c:if>
            </ul>
        </li>
        <!-- End Icons -->




    </ul>
</div>
