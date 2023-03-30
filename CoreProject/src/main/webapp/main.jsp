
<%@page import="java.util.List"%>
<%@page import="com.smhrd.model.WebMessageDAO"%>
<%@page import="com.smhrd.model.WebMember"%>
<%@page import="com.smhrd.model.WebMessage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body>

	<%
	// 세션값 가져오기
	WebMember loginMember = (WebMember) session.getAttribute("loginMember");
	if (loginMember != null) {
		System.out.print(loginMember.getEmail());
	}
	%>
	

	
	<!-- Wrapper -->
	<div id="wrapper">
		<!-- Header -->
		<header id="header" class="alt"> <a href="index.html"
			class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a> <nav>
		<%if(loginMember==null){ %>
		<a href="#menu">로그인</a>
		<%}else{ //로그인이 되었는지 %>
		<!-- 관리자계정(email : admin)로그인 : 회원정보확인/개인정보수정/로그아웃 -->
		<!-- 일반 계정 로그인 : 개인정보수정 / 로그아웃 -->
		
		<%if(loginMember.getEmail().equals("admin")){ %>
		<a href="select.jsp">회원정보확인</a>
		<%} %>
		
		<a href="update.jsp">개인정보수정</a>
		<a href="logoutService.do">로그아웃</a>
		<%}; %>
		</nav> </header>

		<!-- Menu -->
		<nav id="menu">
		<ul class="links">
			<li><h5>로그인</h5></li>
			<form action="LoginService.do" method="post">
				<li><input type="text" name="email" placeholder="Email을 입력하세요"></li>
				<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
				<li><input type="submit" value="LogIn" class="button fit"></li>
			</form>
		</ul>
		<ul class="actions vertical">
			<li><h5>회원가입</h5></li>
			<form action="JoinService.do" method="post">
				<li><input type="text" name="email" id="input" placeholder="Email을 입력하세요"></li>
				<li><input type="button" value="Email중복체크" onclick="checkE()"></li>
				<li><input type="button" value="Email중복체크(object)" onclick="checkE2()"></li>
				<li><span id="result"></span></li>
				<!-- 이 부분 테이블 문제임 -->
				<li><table id="resultTable"></table></li>
				<li><input type="password" name="pw" placeholder="PW를 입력하세요"></li>
				<li><input type="text" name="tel" placeholder="전화번호를 입력하세요"></li>
				<li><input type="text" name="address" placeholder="집주소를 입력하세요"></li>
				<li><input type="submit" value="JoinUs" class="button fit"></li>
			</form>
		</ul>
		</nav>
		<!-- Banner -->
		<section id="banner" class="major">
		<div class="inner">
			<header class="major"> <!-- 로그인 후 로그인 한 사용자의 세션아이디로 바꾸시오.ex)smart님 환영합니다 -->
			</header>
			<%if (loginMember==null){ %>
			<h1>로그인 한 세션아이디를 출력해주세요</h1>
			<% }else{ %>
			<h1><%=loginMember.getEmail()%>님 환영합니다.</h1>
			<%}; %>
			<div class="content">
				<p>
					아래는 지금까지 배운 웹 기술들입니다.<br>
				</p>
				<ul class="actions">
					<li><a href="#one" class="button next scrolly">확인하기</a></li>
				</ul>
			</div>
		</div>
		</section>

		<!-- Main -->
		<div id="main">
			<!-- One -->
			<section id="one" class="tiles"> <article> <span
				class="image"> <img src="images/pic01.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">HTML</a>
			</h3>
			<p>홈페이지를 만드는 기초 언어</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic02.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">CSS</a>
			</h3>
			<p>HTML을 디자인해주는 언어</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic03.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">Servlet/JSP</a>
			</h3>
			<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic04.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">JavaScript</a>
			</h3>
			<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic05.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">MVC</a>
			</h3>
			<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
			</header> </article> <article> <span class="image"> <img
				src="images/pic06.jpg" alt="" />
			</span> <header class="major">
			<h3>
				<a href="#" class="link">Web Project</a>
			</h3>
			<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
			</header> </article> </section>
			
			
			
			<!-- Two -->
			<section id="two">
			<div class="inner">
				<header class="major">
				<h2>나에게 온 메세지 확인하기</h2>
				</header>
				<p></p>
				<ul class="actions">
				<!-- 1. 로그인 이메일 출력 -->
					<%if (loginMember==null){ %>
					<li>로그인을 하세요.</li>
					<% }else{ %>
					<li><%=loginMember.getEmail()%>님 환영합니다.</li>
					<%}; %>
					
				<!-- 나에게 온 메시지 전체 삭제 기능 -->	
					<%if (loginMember==null){ %>
					<li><a href="#" class="button next scrolly">전체삭제하기</a></li>
					<% }else{ %>
					<li><a href="DeleteAll.do?email=<%=loginMember.getEmail()%>" class="button next scrolly">전체삭제하기</a></li>
					<%}; %>
				</ul>

				<!-- 나에게온 메시지 조회 기능 -> table형태 (번호,보낸사람,내용,시간,삭제) -->
				<div id="board">
					<table id="list">
						<tr>
							<td>번호</td>
							<td>보내는 사람</td>
							<td>내용</td>
							<td>시간</td>
							<td>삭제</td>
						</tr>
						
						<%if(loginMember != null){ 
							WebMessage reciveEmail = new WebMessage(loginMember.getEmail());
							WebMessageDAO dao = new WebMessageDAO();
							List<WebMessage> list = dao.select(reciveEmail);
							for(int i=0;i<list.size();i++){ %>
						<tr>
							<td><%=list.get(i).getNum() %></td>
							<td><%=list.get(i).getSendName() %></td>
							<td><%=list.get(i).getMessage() %></td>
							<td><%=list.get(i).getM_date() %></td>
							<td><a href="DeleteMessage.do?num=<%=list.get(i).getNum()%>">삭제</a></td>
						</tr>
						<%}} else{}%>  
						
					</table>
				</div>
				<!-- 메시지 개별 삭제 기능 -->
			</div>
			
			
	
			</section>
		</div>

		<!-- Contact -->
		<section id="contact">
		<div class="inner">
			<section> <!-- 메시지 보내기 기능 -->
			<form action="MessageService.do" method="post">
				<div class="field half first">
					<label for="name">Name</label> <input type="text" name="name" id="name" placeholder="보내는 사람 이름" />
				</div>
				<div class="field half">
					<label for="email">Email</label> <input type="text" name="email" id="email" placeholder="보낼 사람 이메일" />
				</div>
				<div class="field">
					<label for="message">Message</label>
					<textarea id="message" rows="6" name="message"></textarea>
				</div>
				<ul class="actions">
					<li><input type="submit" value="Send Message" class="special" /></li>
					<li><input type="reset" value="Clear" /></li>
				</ul>
			</form>
			</section>
			
			
			<section class="split"> <section>
			<div class="contact-method">
				<span class="icon alt fa-envelope"></span>
				<h3>Email</h3>
				<%if (loginMember==null){ %>
				<a href="#">로그인 한 사람의 이메일을 출력</a>
				<% }else{ %>
				<a href="#"><%=loginMember.getEmail()%></a>
				<%}; %>
			</div>
			</section> <section>
			<div class="contact-method">
				<span class="icon alt fa-phone"></span>
				<h3>Phone</h3>
				<%if (loginMember==null){ %>
				<span>로그인 한 사람의 전화번호를 출력</span>
				<% }else{ %>
				<span><%=loginMember.getTel()%></span>
				<%}; %>

			</div>
			</section> <section>
			<div class="contact-method">
				<span class="icon alt fa-home"></span>
				<h3>Address</h3>
				<%if (loginMember==null){ %>
				<span>로그인 한 사람의 집주소를 출력</span>
				<% }else{ %>
				<span><%=loginMember.getAddress()%></span>
				<%} %>
			</div>
			</section> </section>
		</div>
		</section>

		<!-- Footer -->
		<footer id="footer">
		<div class="inner">
			<ul class="icons">
				<li><a href="#" class="icon alt fa-twitter"><span
						class="label">Twitter</span></a></li>
				<li><a href="#" class="icon alt fa-facebook"><span
						class="label">Facebook</span></a></li>
				<li><a href="#" class="icon alt fa-instagram"><span
						class="label">Instagram</span></a></li>
				<li><a href="#" class="icon alt fa-github"><span
						class="label">GitHub</span></a></li>
				<li><a href="#" class="icon alt fa-linkedin"><span
						class="label">LinkedIn</span></a></li>
			</ul>
			<ul class="copyright">
				<li>&copy; Untitled</li>
				<li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
			</ul>
		</div>
		</footer>
	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
	<script>
	
		const checkE=()=>{
			let input = document.getElementById('input');
			let url='EmailCheckService?inputE='+input.value;
			fetch(url)
			.then(res => res.json())
			.then((data)=>{
				console.log(data);
				let result =document.getElementById('result');
				
				if(data){ // result <- true (이미 있는 값)
					result.innerText = '사용할 수 없는 이메일'
				}else{ // result <- false (없는 값)
					result.innerText = '사용가능한 이메일'
				}
			})
			.catch((err)=>{
				console.log(err);
			})
		};
		
		const checkE2=()=>{
			let input = document.getElementById('input');
			let url='EmailCheckService?inputE='+input.value;
			fetch(url)
			.then(res => res.json())
			.then((data)=>{
				console.log(data);
				let resultTable = document.getElementById('resultTable');
				let str='<tr>';
				str+='<td>'+data.email+'</td>';
				str+='<td>'+data.pw+'</td>';
				str+='<td>'+data.tel+'</td>';
				str+='<td>'+data.address+'</td>';
				str+='</tr>';
				resultTable.innerHTML = str;
			})
			.catch((err)=>{
				console.log(err);
			})
		}
	</script>

</body>
</html>

