<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/details/headTag.jsp" />
<body id="page-top">
	<script src='<c:url value="/js/itemAjax.js" />'></script>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       	<jsp:include page="/WEB-INF/views/details/sidebar.jsp" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content" style="padding-left: 10px">
             	<h1>총 현황</h1>
             	<table>
             		<thead>
					    <tr>
					      <th scope="col">의약품 명</th>
					      <th scope="col">고유 코드</th>
					      <th scope="col">규격</th>
					      <th scope="col">총 합계</th>
					      <th scope="col">부서</th>
					    </tr>
			    	</thead>
					<tbody>
						<c:forEach var="inventory" items="${inventoryList}">
							<tr>
								<th scope="row">${inventory.getName()}</th>
								<td>${inventory.getCode()}</td>
								<td>${inventory.getType()}</td>
								<td>${inventory.getTotalCount()}</td>
								<td>${inventory.getDepartment()}</td>
							</tr>	
						</c:forEach>
					</tbody>
					</tbody>
             	</table>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="/WEB-INF/views/details/footer.jsp" />

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
</body>

</html>