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
  <title>게시판</title>

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
<script>
$().ready(function(){
	$("#searchKeyword").keyup(function(event){
		console.log(event);
		if ( event == "enter"){
			movePage('0');
		}
	});
});
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
                <h2><i class="fa fa-play"></i><strong>쑤아리질러!~~</strong></h2>
               		<a href="<c:url value="/write"/>">응원하기</a>
              </div>
              <div class="panel-body-map">
                <div id="map">
                	<table class="table bootstrap-datatable">
                		<thead> 
	                		<tr>
	                			<th>글번호</th>
	                			<th>팀</th>
	                			<th>제목</th>
	                			<th>작성자</th>
	                			<th>작성일</th>
	                			<th>조회수</th>
	                			<th>추천수</th>
	                		</tr>
	                	</thead>
                		<tbody>
                	<c:forEach items="${pageExplorer.list}" var="baseball">
	                		<tr style="font-size:15px;">
	                			<td>${baseball.id}</td>
	                			<td><a><img style="height:30px;"src="${baseball.teamVO.img}"/></a></td>
	                		    <td><a href="<c:url value="/read/${baseball.id}"/>">${baseball.title}</a></td>
	                			<td>${baseball.memberVO.nickname}</td>
	                			<td>${baseball.writeDate}</td>
	                			<td>${baseball.viewCount}</td>
	                			<td>${baseball.recommendCount}</td>
	                		</tr>
                	</c:forEach>	
	                	</tbody>
	                	<c:if test="${empty pageExplorer.list}"><!-- 비어있으면  안비어 있으면 not empty-->
							<tr>
								<td colspan="5">등록된 게시글이 없습니다.</td>
							</tr>
						</c:if>	
                	</table>
                			<form id="searchForm">
							${pageExplorer.make()}		
		
					<div>
						<select id="searchType" name="searchType">
							<option value="1" ${search.searchType eq 1 ? 'selected' : '' }>글제목</option>
							<option value="2" ${search.searchType eq 2 ? 'selected' : '' }>내용 </option>
							<option value="3" ${search.searchType eq 3 ? 'selected' : '' }>제목 + 글제목</option>
							<option value="4" ${search.searchType eq 4 ? 'selected' : '' }>작성자 Nickname</option>
							<option value="5" ${search.searchType eq 5 ? 'selected' : '' }>작성자 Email </option>
						</select>
						
							<input type="text" id="searchKeyword" name="searchKeyword"
							value="${search.searchKeyword}"/>
					 		<a href="<c:url value="/reset"/>">검색 초기화</a>
					 </div>
					 </form>
							
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
              
