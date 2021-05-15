<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/details/headTag.jsp" />
<body id="page-top">
<script src='<c:url value="/js/orderAjax.js" />'></script>
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
       	<jsp:include page="/WEB-INF/views/details/sidebar.jsp" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
             	<h1>주문 내역</h1>
             	<table>
             		<thead>
					    <tr>
					      <th scope="col">신청 부서</th>
					      <th scope="col">약품 이름</th>
					      <th scope="col">규격</th>
					      <th scope="col">신청 수량</th>
					      <th scope="col">신청 날짜</th>
					      <th scope="col">희망 날짜</th>
					      <th scope="col">처리</th>
					    </tr>
			    	</thead>
					<tbody>
						<c:forEach var="orderList" items="${orderList}">
							<tr>
								<th scope="row">${orderList.getDepartment()}</th>
								<td>${orderList.getName()}</td>
								<td>${orderList.getType()}</td>
								<td>${orderList.getOrderCount()}</td>
								<td>${orderList.getApplicationDate()}</td>
								<td>${orderList.getWantedDate()}</td>
								<td><input type="button" value="승인" onclick="buy(${orderList.getOrderNo()});"></input>
								<input type="button" value="취소" onclick="reject(${orderList.getOrderNo()});"></input></td>
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