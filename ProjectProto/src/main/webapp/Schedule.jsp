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
	<form action="tSchedule" method="post">
		<fieldset>
			<legend>
				<h2>스케줄 설정하기</h2>
			</legend>

			<table>
				<tr>
					<td>콘센트 이름</td>
					<td><input type="text" name="scheduleName"></td>
				</tr>
			
				<tr>
					<td>기기 선택</td>
					<td>
						<select name="appliance">
							<option value="computer">컴퓨터</option>
							<option value="tv">TV</option>
							<option value="charger">충전기</option>
						</select>
					</td>
				</tr>
			
				<tr>
					<td>날짜 지정하기</td>
					<td><input type="date" name="date"></td>
				</tr>
				<tr>
					<td colspan="2">시간 지정하기</td>
					<td></td>
				</tr>
				<tr>
					<td>설정 시간</td>
					<td><input type="time" name="onTime" value="09:00:00"></td>
				</tr>
				<tr>
					<td>ON/OFF 설정</td>
					<td>ON<input type="radio" name="onOff" value="1"></td>
					<td>OFF<input type="radio" name="onOff" value="0"></td>
				</tr>
				
				
				<tr>
					<td><input type="reset" value="다시 설정"></td>
					<td><input type="submit" value="등록하기"></td>
				</tr>
				
			</table>
		</fieldset>
	</form>
</body>
</html>