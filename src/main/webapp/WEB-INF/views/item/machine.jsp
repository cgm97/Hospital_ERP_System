<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/details/headTag.jsp" />

<body id="page-top">
	
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       	<jsp:include page="/WEB-INF/views/details/sidebar.jsp" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content" style="padding-left: 10px">
             	<h1>기계 현황</h1>
             	<table>
             		<thead>
					    <tr>
					      <th scope="col">기계명</th>
					      <th scope="col">고유 코드</th>
					      <th scope="col">현재 위치</th>
					      <th scope="col">담당 부서</th>
					      <th scope="col">구매 일자</th>
					      <th scope="col">점검 일자</th>
					    </tr>
			    	</thead>
					<tbody>
						<c:forEach var="machineList" items="${machineList}">
							<tr>
								<th scope="row">${machineList.getName()}</th>
								<td>${machineList.getCode()}</td>
								<td>${machineList.getLocation()}</td>
								<td>${machineList.getDepartment()}</td>
								<td>${machineList.getBuyDate()}</td>
								<td>${machineList.getInspectionDate()}</td>
							</tr>	
						</c:forEach>
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