
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.WebMember"%>
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.WebMemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Forty by HTML5 UP</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	
	<%
	//페이지를 이동하자마자 DB안에서 값만 그대로 가지고와서 출력할 수 있도록
	WebMemberDAO dao = new WebMemberDAO();
	List<WebMember> list = dao.select();
	
	System.out.print(list.get(0).getEmail());
	%>
	
	<body style="text-align: center;">
		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<table>
							<caption><h2>회원관리페이지</h2></caption>
							<tr>
								<td>Email</td>
								<td>Tel</td>
								<td>Address</td>							
							</tr>
							<!-- 회원의 수 만큼 tr 태그 반복 출력 -->
							<% for(int i=0; i<list.size();i++){%>
							<tr>
								<td><%=list.get(i).getEmail()%></td>
								<td><%=list.get(i).getTel()%></td>
								<td><%=list.get(i).getAddress()%></td>
								<!-- url에 데이터를 실어서 보내는 쿼리스트링 방법 이용 -->
								<!-- url?name=value&name=value&... -->
								<td><a href="DeleteService.do?email=<%=list.get(i).getEmail()%>">삭제</a></td>
							</tr>
							<%} %>
							<!-- 확장 for문으로 쓰기, 위랑 결과는 같음 -->
							<%for(WebMember w:list){ %>
							<tr>
								<td><%=w.getEmail()%></td>
								<td><%=w.getTel()%></td>
								<td><%=w.getAddress()%></td>
							</tr>
							<%} %>
							<!-- out객체 사용하기, 결과는 똑같음 -->
							<%for(WebMember w:list){ 
							out.print("<tr>");
							out.print("<td>"+w.getEmail()+"</td>");
							out.print("<td>"+w.getTel()+"</td>");
							out.print("<td>"+w.getAddress()+"</td>");
							out.print("<td><a href=\"DeleteService.do?email="+w.getEmail()+"\">삭제</a></td>");
							out.print("</tr>");
							}%>
							
							<!-- 2.모든 회원의 이메일(email),전화번호(tel),주소(address)를 출력하시오. -->
						</table>
					</nav>		
					<a href="main.jsp" class="button next scrolly">되돌아가기</a>	
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

