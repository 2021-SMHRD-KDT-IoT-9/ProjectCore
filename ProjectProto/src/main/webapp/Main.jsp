<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background: whitesmoke;
	text-align: center;
}

fieldset {
	border: 3px dotted blue;
}

div>button {
	width: 100px;
	height: 100px;
}
</style>
</head>
<body>

	<h2>Test Success</h2>

	<fieldset>
		<legend>
			<h2>Test 메인화면</h2>
		</legend>

		<table>		
			<tr>
				<td><a href="Schedule.jsp">스케줄 등록하기</a></td>
			</tr>
			<tr>
				<td><a href="tScheduleSelect.jsp">스케줄 확인하기</a></td>
			</tr>
			
			
			<tr>
				<td><a href="Login.jsp">로그인 화면으로</a></td>
			</tr>
			<tr>
				<td><a href="Join.jsp">회원가입 화면으로</a></td>
			</tr>
		</table>
	</fieldset>

</body>
</html>