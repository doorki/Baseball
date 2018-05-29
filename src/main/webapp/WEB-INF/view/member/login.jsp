<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="/static/img/favicon.png">
<!-- Bootstrap CSS -->
  <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
  <!-- bootstrap theme -->
  <link href="<c:url value="/static/css/bootstrap-theme.css"/>" rel="stylesheet" type="text/css">
  <!--external css-->
  <!-- font icon -->
  <link href="<c:url value="/static/css/elegant-icons-style.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="/static/css/font-awesome.css"/>" rel="stylesheet" type="text/css">
  <!-- Custom styles -->
  <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css">
  <link href="<c:url value="/static/css/style-responsive.css"/>" rel="stylesheet" type="text/css">
<script type="text/javascript" 
		src="<c:url value ="/static/js/jquery-3.3.1.min.js" />">		
</script>
<script type="text/javascript">

	$().ready(function(){
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
</style>
</head>
<body class="login-img3-body">
		<div class="container">
		<form:form modelAttribute="loginForm" class="login-form">  
				<!-- <img style=" width:130px; height:80px;" src="static/img/file.jpg"/> -->
		<div class="login-wrap">
        <p class="login-img"><i class="icon_lock_alt"></i></p>
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input type="text" class="form-control" id="email" name="email" placeholder="Email" autofocus>
        </div>
        	<div>
				<form:errors path="email"/><!--체크하고자하는 엘리먼트의 name을 적어준다.  -->
			</div>
			
			<div id="errorId" style="display:none">아이디를 입력하세요!!</div>
			
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
       
       	<div>
			<form:errors path="password"/><!--체크하고자하는 엘리먼트의 name을 적어준다.  -->
		</div>
		
		<div id="errorPassword" style="display:none">아이디를 입력하세요!!</div>
      		
      		<label class="checkbox">
               <input type="checkbox" value="remember-me"> Remember me
            </label>
       
        <input class="btn btn-primary btn-lg btn-block" type="button" id="loginBtn" value="Login"/>
        
        <a href="<c:url value="/regist"/>">Join us?</a>
      </div>
    </form:form>
    
    <div class="text-right">
          <a>Hit</a> & <a>Run</a>
    </div>
    </div>


</body>
</html>