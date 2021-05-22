<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<script src='<c:url value="/js/hrAjax.js" />'></script>
	<script src='<c:url value="/js/AjaxSerializeObject.js" />'></script>
		<title>직원 정보</title>
</head>
<body style="text-align: center">
	 <div>
	 	<h1>${memberInfo.getName()}님의 정보</h1>
	 </div>
	 <div>
	 	<form id="memberInfo">
			<label>소속 부서  : </label><input type="text" id="department" name="department" value="${memberInfo.getDepartment()}" /><br>
			<label>직급  : </label><input type="text" id="department" name="department" value="${memberInfo.getRank()}" /><br>
	 		<label>연락처  : </label><input type="text" id="department" name="department" value="${memberInfo.getPhone()}" /><br>
	 	</form>
	 		<input type= "button" value="수정" onclick="updateInfo();"/>
	 </div>
</body>
</html>