<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>가입</title>

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
  <link href="<c:url value="/static/css/input.css"/>" rel="stylesheet" type="text/css">
<script type="text/javascript" 
		src="<c:url value ="/static/js/jquery-3.3.1.min.js" />">		
</script>
<script type="text/javascript">
	$().ready(function(){
		$("#email").keyup(function(){
			var value = $(this).val();
			if(value !=""){
				
			$.post("<c:url value="/api/exists/email"/>",{
				email : value
			}, function(response){
				console.log(response.response);
				
				if( response.response){
					alert("작성한 이메일은 사용할 수 없습니다.");
					$("#email").removeClass("valid");
					$("#email").addClass("invalid");
				}
				else{
					$("#email").removeClass("invalid");
					$("#email").addClass("valid");
				 }
				});
			}	
				else{
					$(this).removeClass("invalid");
					$(this).addClass("valid");
			}
		});
		
		$("#nickname").keyup(function(){
			var value = $(this).val();
			if( value != ""){
				
				$.post("<c:url value="/api/exists/nickname"/>",{
					nickname : value }, function(response){
						console.log(response.response);
						
						if(response.response){
							alert("작성한 닉네임이 이미 존재합니다.");
							$("#nickname").removeClass("valid");
							$("#nickname").addClass("invalid");
						}
						else{
							$("#nickname").removeClass("invalid");
							$("#nickname").addClass("valid");
						}
					});
				  }	
				else{
				   	$(this).removeClass("valid");
				   	$(this).addClass("invalid");
				  }
			});
			$("#password").keyup(function(){
				var value = $(this).val();
				if(value != " "){
					$(this).removeClass("inValid");
					$(this).addClass("valid");
				}else{
					$(this).removeClass("valid");
					$(this).addClass("invalid");
				}
				
				var password = $("#password-confirm").val();
				
				if( value != password){
					$(this).removeClass("valid");
					$(this).addClass("invalid");
					$("#password-confirm").removeClass("valid");
					$("#password-confirm").addClass("invalid");
				}
				else{
					$(this).removeClass("invalid");
					$(this).addClass("valid");
					$("#password-confirm").removeClass("invalid");
					$("#password-confirm").addClass("valid");
				}
			});
			
			$("#password-confirm").keyup(function(){
				var value = $(this).val();
				var password = $("#password").val();
				
			if( value != password){
			$(this).removeClass("valid");
			$(this).addClass("invalid");
			$("#password").removeClass("valid");
			$("#password").addClass("invalid");
			return false;
			}
			else{
			$(this).removeClass("invalid");
			$(this).addClass("valid");
			$("#password").removeClass("invalid");
			$("#password").addClass("valid");
				}
			});
		$("#registBtn").click(function(){
			
			if( $("#email").val() == ""){
			alert("이메일을 작성하세요.");
			$("#email").focus();
			$("#email").addClass("invalid");
			return false;
			}
			
			if( $("email").hasClass("invalid") ) {
			alert("작성한 이메일은 사용할 수 없습니다.");
			$("#email").focus();
			return false;
			}
			
			else{
			 $.post("<c:url value="/api/exists/email"/>",{
				 email :$("#email").val() }
			 , function(response){
				 console.log(response.response);
			
			if( response.response){
				alert("해당 이메일은 사용할 수 없습니다.");
				$("#email").focus();
				return false;
				}
			if( $("#nickname").val() ==""){
				alert("Nickname을 입력하세요.!");
				$("#nickname").focus();
				$("#nickname").addClass("invalid");
				return false;
			}
			else{
				$.post("<c:url value="/api/exists/nickname"/>",{
					nickname : $("#nickname").val() }
				, function(response){
				
				console.log(reponse.response);
				
				if(response.response){
				alert("작성한 이메일은 사용할 수 없습니다.");
				$("#nickname").focus();
				return false;
				}
			 }
				)};
		if($("#password").val() ==""){
			alert("PassWord를 입력하세요 ");
			$("#password").focus();
			$("#password").addClass("invalid");
			return false;
			}
	   if($("#agree").is(":checked")){
		
		$(".regist-form").attr({
			"action" : "<c:url value="/regist"/>",
			"method" : "post"
				}).submit();
		}
		else{
			alert("약관에 동의해주세요");
			return false;
		}
			 });
			}
		});
	}); 
</script>

<body class="regist-img3-body">
		<div class="container">
			<form:form modelAttribute="regist-Form" class="regist-form">  
		<div class="regist-wrap">
        <p class="regist-img"><i class="icon_group"></i></p>
        
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input type="email" class="form-control" id="email" name="email" placeholder="Email" autofocus/>
        <div>
			<form:errors path="email"/>
  		</div>	 
        </div>
        
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_profile"></i></span>
          <input class="form-control" id="nickname" name="nickname" 
          		 placeholder="Nickname"/>
        <div>
			<form:errors path="nickname" />
		</div>
        </div>
        
		
        <div class="input-group">
          <span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" class="form-control" id="password" name="password" placeholder="Password"/>
        <div>
		  <form:errors path="password"/>
		</div>
        </div>
        
		
        <div class="input-group">
        	<span class="input-group-addon"><i class="icon_key_alt"></i></span>
          <input type="password" class="form-control" id="password-confirm" name="password-confirm" placeholder="Password-confirm">
        </div>
          <label class="checkbox">
                <input type="checkbox" id="agree">I understand and agree to be bound by the MLB.com Terms of Use and Privacy Policy
           </label>     
        <input class="btn btn-primary btn-lg btn-block" type="button" id="registBtn" value="Regist"/>
      </div>
    </form:form>
    	<div class="text-right">
          <a>Hit</a> & <a>Run</a>
        </div>
    </div>


</body>
</html>