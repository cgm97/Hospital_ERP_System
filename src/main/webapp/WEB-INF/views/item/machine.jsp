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
						<tr>
							<th scope="row">MRI</th>
						    <td>000001</td>
						    <td>1층</td>
						    <td>응급실</td>
						    <td>2020-02-25</td>
						    <td>2021-04-09</td>
						</tr>
						<tr>
							<th scope="row">MRI</th>
						    <td>000001</td>
						    <td>1층</td>
						    <td>응급실</td>
						    <td>2020-02-25</td>
						    <td>2021-04-09</td>
						</tr>
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