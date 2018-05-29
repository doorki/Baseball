<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="img/favicon.png">
  <title>main</title>

  <!-- Bootstrap CSS -->
  <link href="<c:url value="/static/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
  <!-- bootstrap theme -->
  <link href="<c:url value="/static/css/bootstrap-theme.css"/>" rel="stylesheet" type="text/css">
  <!--external css-->
  <!-- font icon -->
   <link href="<c:url value="/static/css/elegant-icons-style.css"/>" rel="stylesheet" type="text/css">
   <link href="<c:url value="/static/css/font-awesome.css"/>" rel="stylesheet" type="text/css">
  
   <link href="<c:url value="/static/css/style.css"/>" rel="stylesheet" type="text/css">
   <link href="<c:url value="/static/css/style-responsive.css"/>" rel="stylesheet" type="text/css">

<script type="text/javascript" 
		src="<c:url value ="/static/js/jquery-3.3.1.min.js" />">
</script>
</head>
<body>
  <section id="container" class="">
	
	<!--  메뉴 불러오기 -->
    <jsp:include page="/WEB-INF/view/template/menu.jsp"/>
   
    <section id="main-content">
      <section class="wrapper">
        <!--overview start-->
		
		<!--메인 콘텐츠.  -->
        <div class="row">
          <div class="col-lg-9 col-md-12">
            <div class="panel panel-default">
              <div class="panel-heading">
                <h2><i class="fa fa-play"></i><strong>League</strong></h2>
              </div>
              <div class="panel-body-map">
                <div id="map">
					<h4>
				 		<a><img style="width:5%; height:5%;" src="${baseball.teamVO.img}"/></a> ${baseball.memberVO.nickname} 님 (${baseball.memberVO.email})
					</h4>
					
						<p> 제목 : ${baseball.title}</p>	
						<p> 내용 : ${baseball.body}</p>	
						
						<p>작성일 : ${baseball.writeDate}</p>
					
						<div>
		 					<p>조회수 : ${baseball.viewCount} </p>
		 					<a href="<c:url value="/recommend/${baseball.id}"/>">추천하기</a>( ${baseball.recommendCount} )
						</div>

						<div>
							<p><a href="<c:url value="/column"/>">목록으로</a></p>
	
							<c:if test="${sessionScope.__USER__.id == baseball.memberVO.id}">
								<a style="text-align:right;" href="<c:url value="/remove/${baseball.id}"/>">삭제하기</a>
							</c:if>
						</div>
                </div>
               
              	
              	</div>
          </div>

        </div>
	</div>
      </section>
    </section>
  </section>

</body>

</html>
              
