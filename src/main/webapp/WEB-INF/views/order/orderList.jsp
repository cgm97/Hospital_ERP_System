<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/details/headTag.jsp" />
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
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
             	<table id="orderList">
             		<thead>
					    <tr>
					      <th scope="col">신청 부서</th>
					      <th scope="col">약품 이름</th>
					      <th scope="col">규격</th>
					      <th scope="col">신청 수량</th>
					      <th scope="col">신청 날짜</th>
					      <th scope="col">희망 날짜</th>
					      <th scope="col">처리 날짜</th>
					      <th scope="col" >결제 상태
					      	<span style='vertical-align: middle;' id='icon'>
					      		<i id="upIcon" class="fas fa-sort-up" onclick="orderBy('asc');"></i>	
					      		<i id="downIcon" class="fas fa-sort-down" onclick="orderBy('desc');"></i>				      					      						      	
					      	</span>
					      </th>
					    </tr>
			    	</thead>
					<tbody id="tbody">
						<c:forEach var="orderList" items="${orderList}">
							<tr>
								<th scope="row">${orderList.getDepartment()}</th>
								<td>${orderList.getName()}</td>
								<td>${orderList.getType()}</td>
								<td>${orderList.getOrderCount()}</td>
								<td>${orderList.getApplicationDate()}</td>
								<td>${orderList.getWantedDate()}</td>
								<td>${orderList.getCompleteDate()}</td>
								<td>
									<c:if test="${orderList.getState() eq 1}">
										<b style="color:green">승인됨</b>
									</c:if>
									<c:if test="${orderList.getState() eq 2}">
										<b style="color:red">거절됨</b>
									</c:if>
									<c:if test="${orderList.getState() eq 0}">
										<input type="button" value="승인" onclick="buy(${orderList.getOrderNo()});"></input>
										<input type="button" value="거절" onclick="reject(${orderList.getOrderNo()});"></input>
									</c:if>
								</td>
							</tr>	
						</c:forEach>
					</tbody>
             	</table>
             	<div>
				  <ul id="paging">
				    <c:if test="${pageMaker.prev}">
				    	<li><a href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
				    </c:if> 
				
				    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				    	<li><a href="list${pageMaker.makeQuery(idx)}">${idx}</a></li>
				    </c:forEach>
				
				    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				    	<li><a href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
				    </c:if> 
				  </ul>
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