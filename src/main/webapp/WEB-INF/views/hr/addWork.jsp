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
	<script src='<c:url value="/js/AjaxSerializeObject.js" />'></script>
	<script src='<c:url value="/js/hrAjax.js" />'></script>
	<title>근태 기록</title>
</head>
<body style="text-align: center">
	 <div>
	 	<h1>근태 기록</h1>
	 </div>
	 <div>
	 	<form id="addWork">
	 		<div>
	 			시작 날짜 : <input type="text" name="today" id="today" size="12" value="${today}" readOnly />
	 		</div>	
	 		<br>
	 		<div>
	 			출근 시간 : <input type="time" name="startTime" id="startTime" size="12" />
	 		</div>	
	 		<div>
	 			퇴근 시간 : <input type="time" name="endTime" id="endTime" size="12" />
	 		</div>
	 		<br>
	 		<br>
	 	</form>
	 		<input type= "button" value="기록" onclick="workRec()"/>
	 </div>
</body>
</html>