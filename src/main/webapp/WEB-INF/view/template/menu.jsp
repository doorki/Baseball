<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/static/css/bootstrap-theme.css"/>" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <header class="header dark-bg">
      <div style="width:80%; display:inline-block;" >
      <div>
      <a href="/"><img style="width:120px;height:70px; padding:7px;"
      	 src="//www.mlbstatic.com/mlb.com/builds/site-core/9705dfe35c043124f196bf30fedd22dbcfc6f80b_1522693329/images/logos/league-on-dark/1.svg" /></a>
      </div>	 
      </div>	 
      <div style="display:inline-block; vertical-align:middle; text-align:right; width:19%;">
			<ul style=" display:inline-block; color:#000000;">
			<c:if test="${empty sessionScope.__USER__}">
				<li>
				<a href="<c:url value="/login"/>" style="color:#FFFFFF; font-size:17px;">로그인</a>
				</li>
			</c:if>
			
			<c:if test="${not empty sessionScope.__USER__}">
				<li>
				<a href="<c:url value="/logout"/>" style="color:#FFFFFF;">(${sessionScope.__USER__.nickname}님) Logout</a>
				</li>
			</c:if>	
			
		</ul>		
	</div>
      
    </header>

    <!--sidebar start-->
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu">
          <li class="active">
            <a class="" href="/" ">
            <i class="icon_house_alt"></i>
                          <span>Rank</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
            </a>
          </li>
          <li class="sub-menu">
            <a href="/team" class="">
                          <i class="icon_document_alt"></i>
                          <span>Team</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
                      </a>
          </li>
          <li class="sub-menu">
            <a href="/column" class="">
                          <i class="icon_desktop"></i>
                          <span>BOARD</span>
                          <span class="menu-arrow arrow_carrot-right"></span>
            </a>
          </li>

        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->

		<div>
			<ul style=" display:inline-block; margin:0px; ">
			<c:if test="${empty sessionScope.__USER__}">
				<li>
				<a href="<c:url value="/login"/>">Login</a>
				</li>
			</c:if>
			
			<c:if test="${not empty sessionScope.__USER__}">
				<li>
				<a href="<c:url value="/logout"/>">(${sessionScope.__USER__.nickname}님) Logout</a>
				</li>
			</c:if>	
			
			<c:if test="${not empty sessionScope.__USER__}">
				<li>
					<a href="<c:url value="/delete"/>">회원탈퇴</a>
				</li>
			</c:if>
		</ul>		
	</div>
