<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" 
		src="<c:url value ="/static/js/jquery-3.3.1.min.js" />">
</script>
<script type="text/javascript">

	$().ready(function(){
		alert("ok");
		
		<c:if test="${sessionScope.status eq 'emptyId'}">
			$("#errorId").show();
		</c:if>
		
		<c:if test="${sessionScope.status eq 'emptyPassword'}">
			$("#errorPassword").show();
		</c:if>

		
		$("#loginBtn").click(function(){
			
			$("#loginForm").attr({
				"action" : "<c:url value="/login"/>",
				"method" : "post"
			}).submit();
			
		});
		
		
	}); 
	
</script>

<title>Insert title here</title>
<style>
 	#wrapper {
		width : 250px;
		height : 50px;
		position : absolute;
		left : 50%;
		top : 40%;
		margin : -25px 0 0 -125px;
	}
</style>
</head>
<body style="background-color:#FFFFFF;">
		<div id="wrapper">
			<jsp:include page="/WEB-INF/view/template/menu.jsp" />
			<form:form modelAttribute="loginForm"> 
			<img style=" width:150px;" height=80px; src="static/img/file.jpg"/>
				
				<div>
					<input type="email" id="email" name="email" placeholder="Email"/>
				</div>
				<div>
						<form:errors path="email"/><!--체크하고자하는 엘리먼트의 name을 적어준다.  -->
				</div>
				
				<div id="errorId" style="display:none">아이디를 입력하세요!!</div>
		
				<div>
					<input type="password" id="password" name="password" placeholder="Password"/>
				</div>
				<div>
						<form:errors path="password"/><!--체크하고자하는 엘리먼트의 name을 적어준다.  -->
				</div>
				
				<div id="errorPassword" style="display:none"> 비밀번호를 입력하세요 </div>
				
				<div>
					<input type="button" id="loginBtn" name="loginBtn" value="Login"/>  &emsp;  <a href="<c:url value="/regist"/>">Join us?</a>
				</div>
			
			</form:form>
		</div>


</body>
</html>