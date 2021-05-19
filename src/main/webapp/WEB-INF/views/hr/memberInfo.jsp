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

	 	</form>
	 		<input type= "button" value="저장" onclick="send_save()"/>
	 </div>
</body>
</html>