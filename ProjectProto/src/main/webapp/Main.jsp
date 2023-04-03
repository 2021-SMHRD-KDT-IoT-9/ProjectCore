<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.eclipse.paho.client.mqttv3.*"%>
<%@ page
	import="java.util.Timer, java.util.TimerTask, java.sql.*, java.text.SimpleDateFormat"%>

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
				<td><a href="Login.jsp">로그인 화면으로</a></td>
			</tr>
			<tr>
				<td><a href="Join.jsp">회원가입 화면으로</a></td>
			</tr>
		</table>
	</fieldset>

	<span id=concentB>콘센트 ID</span>
	<button id="on" value="concentC">ON</button>
	<button id="off">OFF</button>





</body>

<script src="mqttws31-min.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script>



document.getElementById('on').addEventListener('click', () => {
	let conid = document.getElementById('on').value;
	let num = 1;
	console.log(conid);
	console.log('1');
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'tOnoff', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    let data = 'conid=' + encodeURIComponent(conid) + '&num=' + encodeURIComponent(num);
    xhr.send(data);

})

document.getElementById('off').addEventListener('click', () => {
	
	let conid = document.getElementById('concentB').id;
	let num = 0;
	console.log(conid);
	console.log('0');
    let xhr = new XMLHttpRequest();
    xhr.open('POST', 'tOnoff', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    let data = 'conid=' + encodeURIComponent(conid) + '&num=' + encodeURIComponent(num);
    xhr.send(data);
})

</script>
</html>