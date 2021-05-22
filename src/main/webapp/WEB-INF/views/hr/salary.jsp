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
            <div id="content">
             	<h1>급여 관리</h1>
             	<table border="1" bordercolor="blue" width ="600" height="200" align = "center" >
				    <tr bgcolor="skybule" align ="center">
				    	<p><td rowspan="2" span="1" span style="color:black">지급 일자</td></p>
				  	    <p><td rowspan="2" span="1" span style="color:black">지급 총액</td></p>
						<p><td colspan="8" span style="color:black">공제금액</td></p>
				   		<p><td rowspan="2" span style="color:black">실지급액</td></p>
				    </tr>
			    <tr align = "center" bgcolor="skyblue">
					<td>국민연금</td>
					<td>건강보험</td>
					<td>장기요양</td>
					<td>고용보험</td>
					<td>소득세</td>
					<td>주민세</td>
					<td>기타공제</td>
					<td>공제총액</td>
			    </tr>
				<!-- 금액 내용 추가 예정 -->
			    <tr>
					<td align = "center" bgcolor="skyblue">총 합계</td>
					<td>지급액총합</td>
					<td>국민연금</td>
					<td>건강보험</td>
					<td>장기요양</td>
					<td>고용보험</td>
					<td>소득세</td>
					<td>주민세</td>
					<td>기타공제</td>
					<td>공제총액</td>
					<td>실지급총액</td>
			    </tr>
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