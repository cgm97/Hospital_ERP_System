<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/details/headTag.jsp" />
<body id="page-top">
<script src='<c:url value="/js/hrAjax.js" />'></script>
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
       	<jsp:include page="/WEB-INF/views/details/sidebar.jsp" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
             	<h1>직원 목록</h1>
             	<table id="orderList">
             		<thead>
					    <tr>
					      <th scope="col">직원 이름</th>
					      <th scope="col">연락처</th>
					      <th scope="col">부서</th>
					      <th scope="col">직급</th>
					      <th scope="col">입사 날짜</th>
					      <th scope="col">연봉</th>
					      <th scope="col">급여 지급 여부</th>					
					    </tr>
			    	</thead>
					<tbody id="tbody">
					<c:forEach var="memberList" items="${memberList}">
						<tr>
							<th scope="row" onclick="memberSearch(${memberList.getMemberNo()})">${memberList.getName()}</th>
							<td>${memberList.getPhone()}</td>
							<td>${memberList.getDepartment()}</td>
							<td>${memberList.getRank()}</td>
							<td>${memberList.getJoinDate()}</td>
							<td>${memberList.getSalary()}</td>							
							<td>
								<c:if test="${memberList.getPayment() eq 1 }">
									<b style="color:green; text-align: center;">O</b>
								</c:if>
								<b style="color:red; text-align: center;">X</b>
							</td>
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