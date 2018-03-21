<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
 	.topList{
 	 margin-top:20px;
 	 margin-left:20px;
	 font-size:30px;
	 border:2px solid;
	}
</style>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/view/template/menu.jsp" />
		<table>
			<tr>
				<th>ID</th> <!-- th는 글자가 센터로 -->
				
			</tr>
		<c:forEach items="${baseballList}" var="baseball">
			<tr>
				<td>${baseball.id}</td> <!-- td는 글자가 모두 left -->
			</tr>
		</c:forEach>
		<!-- <!-- 전체 div
		<div id="wrapper">
			 위쪽  
			<div>
				로고
				<div style="display:inline-block; border:1px solid;">
					<img style=" width:150px;" height=80px; src="static/img/file.jpg"/>
				</div>	
			<div style="display:inline-block; vertical-align:top;">
					<div class="topList">
						
						<span>|선수 등록|</span>
						<span>|선수 검색|</span>
						<span>|선수 |</span>
					</div>
				</div>
			</div>	
				아래
			<div style=" display:inline-block;">
				기타목록
				<div style=" display:inline-block; margin-left:10px; width:250px;">
					<table>
					     <tr>
							<th>ID</th>
						</tr>
						<tr>
							<th>TEAM</th>
						</tr>
						<tr>
							<th>BackNum</th>
						</tr>
					</table>
				</div>
					데이터 테이블
				<div style="display:inline-block;">
					
				 </div>	
			  </div>
		 </div>	 -->
</body>
</html>