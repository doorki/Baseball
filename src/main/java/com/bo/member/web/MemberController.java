package com.bo.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bo.member.constants.Member;
import com.bo.member.service.MemberService;
import com.bo.member.vo.MemberVO;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(HttpSession sesstion) { //세션을 바로 가지고 올 수 있음
		
		if( sesstion.getAttribute(Member.USER) != null ) {
			return "redirect:/";
		}//로그인이 필요한 페이지에 모두 넣어주면됨
		
		return "member/login";
	}
	@RequestMapping(value= "/regist", method= RequestMethod.GET)
	public String viewRegistPage() {
		return "member/regist";
	}
	@RequestMapping(value ="/regist", method= RequestMethod.POST)
	public ModelAndView doRegistPage(@ModelAttribute("registForm") @Valid MemberVO memberVO,Errors errors)
		{
		if (errors.hasErrors()) {
			return new ModelAndView("member/regist");
			
		}
		if( memberService.createMember(memberVO) ) {
			
			return new ModelAndView("redirect:/login");
			
		}
			return new ModelAndView("member/regist");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLoginAction(@ModelAttribute("loginForm") @Valid MemberVO memberVO, 
					Errors errors, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		MemberVO loginMember= memberService.readMember(memberVO);
		if (loginMember != null) {
			session.setAttribute(Member.USER, loginMember);
			return "redirect:/";
		}
		return "redirect:/login";
		}
	/*	if( memberVO.getId() == null || memberVO.getId().length() == 0 ) {
			session.setAttribute("status", "emptyId");
			return new ModelAndView("redirect:/login");
		}
		
		if( memberVO.getPassword() == null || memberVO.getPassword().length() == 0 ) {
			session.setAttribute("status", "emptyPassword");
			return new ModelAndView("redirect:/login");
		}*/
		
		
		
			
//		if( memberVO.getEmail().equals("admin") &&
//			memberVO.getPassword().equals("1234")) {
//			
//			memberVO.setNickname("관리자");
//			
//			session.setAttribute(Member.USER, memberVO);//인터페이스 만들어준거
//			//세션에 로그인 저장 상태유지
//			
//			session.removeAttribute("status");
//			//로그인에 성공하면 세션을 지워줌 
//			
//			return new ModelAndView("redirect:/");
//		}
//		
//		
//		if( error.hasErrors() ) {
//			ModelAndView view = new ModelAndView();
//			view.setViewName("member/login");
//			return view;
//		}
//
//	
//		//로그인이 실패했을때
//		session.setAttribute("status", "fail");
//		
////		return new ModelAndView("redirect:/login");
//		return new ModelAndView("redirect:/login");
//		
//		
//
	
	@RequestMapping("/logout")
	public String doLogoutAction(int id, HttpSession session) {
		//삭제는 하나의 키만 지우는 것
		//세션 소멸 - 세션자체를 날림
	if( memberService.deleteMember(id)) {
			session.invalidate();
	}
		return "redirect:/login";
		
	}
	@RequestMapping("/delete/process1")
	public String viewVerifyPage() {
		
		return "member/delete/process1";
		
	}
	
	@RequestMapping("/delete")
	public String doDeleteAction(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		if ( member == null) {
			return "redirect:/login";
		}
		int id = member.getId();
		
		if(memberService.deleteMember(id)) {
			session.invalidate();
		}
		return "redirect:/login";
	}
}
