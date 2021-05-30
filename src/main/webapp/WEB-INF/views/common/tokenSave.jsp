<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 토큰 저장</title>
</head>
<body>
<script type="text/javascript">
	var token = new String("${token}");
	localStorage.setItem("user", token);

	document.location.href = "/erpsystem/";
</script>
</body>
</html>