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
  <title>팀/구단</title>

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
                <h2><i class="fa fa-play"></i><strong>팀/ 구단</strong></h2>
              </div>
              <div class="panel-body-map">
                <div id="map">
                	<table class="table bootstrap-datatable">
                		<thead style="font-size:16px;"> 
	                		<tr>
	                			<th>엠블럼</th>
	                			<th>팀</th>
	                			<th>역대 우승 횟수</th>
	                			<th>연고지</th>
	                			<th>창단년도</th>
	                		</tr>
	                	</thead>
                	<c:forEach items="${teamList}" var="team">
                		<tbody>
	                		<tr style="font-size:15px;">
	                			<td><a><img style="width:37%; height:55%;" src="${team.img}"/></a></td>
	                			<td>${team.name}</td>
	                			<td>&nbsp ${team.victory} 회</td>
	                			<td>${team.home}</td>
	                			<td>${team.birth}</td>
	                		</tr>
	                	</tbody>	
                	</c:forEach>	
                	</table>
					
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
              
