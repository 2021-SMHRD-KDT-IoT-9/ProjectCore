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

table {
	margin: 0 auto;
}
</style>
</head>
<body>
	<form action="tJoin" method="post">
		<fieldset>
			<legend>
				<h2>회원가입</h2>
			</legend>

			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="id"></td>
					<td rowspan="3"><input type="submit" value="test가입"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="text" name="pw"></td>
					<td rowspan="3"><a href="Login.jsp">로그인 화면으로</a></td>
				</tr>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>