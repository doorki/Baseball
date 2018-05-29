<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %><!--spring validation check 스프링  %@디렉티브-->  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<!-- static 폴더명 아님 이후부터 폴더명 -->
<script type="text/javascript" 
		src="<c:url value="/static/js/jquery-3.3.1.min.js"/>">
</script>
<script type="text/javascript">
		$().ready(function(){
		   
		   
		      $("#writeBtn").click(function() {
			  

		         $("#writeForm").attr({
		            "method" : "post",
		            "action" : "<c:url value="/write"/>"

		         }).submit();
		      });
		   });


</script>

<style>
	#body {
	
		width : 500px;
		height : 300px;
	
	}
	form {
		
		display : inline-block;
		
	}

</style>


</head>
<body>

	<div id="wrapper">
		<div>
			<form:form modelAttribute="writeForm"> 
				<div>
					<select id="team" name="team">
						<option>KIA 타이거즈</option>
						<option>롯데 자이언츠</option>
						<option>NC 다이노스</option>
						<option>KT 위즈</option>
						<option>LG 트윈스</option>
						<option>SK 와이번즈</option>
						<option>삼성 라이온즈</option>
						<option>두산 베어스</option>
						<option>넥센 히어로즈</option>
						<option>한화 이글스</option>

					</select>
				</div>
				<p>
					제목 : <input type="text" id="title" name="title" placeholder="제목을 입력하시오" />
				</p>
				<div>
					<form:errors path="title"/><!--체크하고자하는 엘리먼트의 name을 적어준다.  -->
				</div>
				
				<div>
				내용:
				<p>
					 <textarea id="body" name="body" placeholder="내용을 입력하세요">${baseballVO.body}</textarea>
				</p>
				</div>
				
				
				<div>
					<form:errors path="body"/>
				</div>
				
				<p>
					<input type="hidden" id="userId" name="userId"  value="${sessionScope.__USER__.id} " placeholder="ID"/>
				</p>
						
				<p>
					<input type="button" id="writeBtn" value="등록"/>
				</p>
			</form:form>
			
		</div>
	
	</div>	
</body>
</html>