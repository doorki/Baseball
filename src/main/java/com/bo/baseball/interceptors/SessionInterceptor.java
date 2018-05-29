package com.bo.baseball.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bo.member.constants.Member;


public class SessionInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String contextPath = request.getContextPath();

		if (request.getSession().getAttribute(Member.USER) == null) {
			
			response.sendRedirect(contextPath + "/login"); // 멤버 유저가 null이면 로그인 하고와!
			return false;
		}

			return true; 	

	}

}
