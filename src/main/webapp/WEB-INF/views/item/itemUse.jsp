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
             	<h1>사용 등록 처리</h1><br>
             	<div>
             		<form action="<c:url value="/item/use.do"/>" method="POST" onsubmit="return itemUseSubmit();">
             			<input type="text" id="name" name="name" placeholder="약품 이름" />
             			<button id="check" type="button" onclick="drugSearch();">검색</button><br><br>
	             		<div id="drugInfo" class="drugInfo"></div>             		
	             		<label>수량    : </label><input type="number" id="useCount" name="useCount" />개<br>
	             		<input type="submit" value="사용 등록" />
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