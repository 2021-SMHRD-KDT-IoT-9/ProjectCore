<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.ScheduleVO"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.ScheduleDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ScheduleDAO dao= new ScheduleDAO();
		// 오류↓
		List<ScheduleVO> list = dao.tScheduleSelect();		
	%>


	<h2>Test Success</h2>

	<fieldset>
		<legend>
			<h2>스케줄 확인하기</h2>
		</legend>

		<table>		
			<tr>
				<td>스케줄 이름</td>
				<td></td>	
			</tr>
		
			
			<tr>
				<td>설정한 기기</td>
				<td></td>
			</tr>
			<tr>
				<td>날짜</td>
				<td></td>
			</tr>
			<tr>
				<td>ON 시간</td>
				<td></td>
			</tr>
			<tr>
				<td>OFF 시간</td>
				<td></td>
			</tr>
		</table>
	</fieldset>

</body>
</html>