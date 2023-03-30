<%@page import="com.smhrd.model.WebMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />		
	</head>
	<body style="text-align: center;">
	
	<%
	WebMember loginMember = (WebMember)session.getAttribute("loginMember");
	%>
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
							<li><h5>회원정보수정</h5></li>
								<form action="UpdateService.do" method="post">
									<input type="hidden" value="<%=loginMember.getEmail()%>" name="email">
									<!-- form형식으로 보이지 않지만 값을 전달할 수 있는 히든타입 -->
								    <input type="text" value="<%=loginMember.getEmail()%>" name="email2" readonly>
								    <!-- 보이기만하고 편집은 할 수 없는 readonly명령어 -->
									<li>접속한 Email : <%=loginMember.getEmail() %> </li> 
									<li><input type="password" placeholder="PW를 입력하세요" name="pw" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text" value="<%=loginMember.getTel()%>" placeholder="전화번호를 입력하세요" name="tel" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="text" value="<%=loginMember.getAddress()%>" placeholder="집주소를 입력하세요" name="address" style="width: 500px; margin: 0 auto;"></li>
									<li><input type="submit" value="JoinUs" class="button fit" style="width: 500px; margin: 0 auto;"></li>
								</form>
						</ul>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
	</body>
</html>

