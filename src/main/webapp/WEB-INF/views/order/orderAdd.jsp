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
             	<h1>주문 신청</h1>
             	<div>
             		<form action="<c:url value="/order/order.do"/>" method="POST" onsubmit="return orderSubmit();">
             			<input type="text" id="name" name="name" onkeyup="drugSearch();" placeholder="약품 이름" />
             			<button id="check" type="button" onclick="drugSearch();">검색</button><br><br>
	             		<div id="drugInfo" class="drugInfo"></div>             		
	             		<label>주문 수량    : </label><input type="number" id="orderCount" name="orderCount" />개<br>
	             		<label>신청 부서 : </label><input type="text" id="department" name="department" /><br>
	             		<label>희망 입고 날짜 : </label>
	             		<input type="text" name="wantedDate" id="wantedDate" size="12" readonly />
						<input type="button" value="달력" onclick="$('#wantedDate').datepicker('show');" /><br>
						
	             		<input type="submit" value="주문 등록" />
             		</form>
            	</div>
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