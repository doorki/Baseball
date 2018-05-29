package com.bo.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping("/api/exists/email")
	@ResponseBody
	public Map<String, Boolean> apiIsExistsEmail(@RequestParam String email){
		
		boolean isExists = memberService.readCountMemberEmail(email);
		
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		
		response.put("response", isExists);
		
		return response;
	}
	@RequestMapping("/api/exists/nickname")
	@ResponseBody
	public Map<String, Boolean> apiIsExistsNickname(@RequestParam String nickname){
		
		boolean isExists = memberService.readCountMemberNickname(nickname);
		
		Map<String, Boolean> response = new HashMap<String,Boolean>();
		
		response.put("response", isExists);
		
		return response;
	}
	
	@RequestMapping(value= "/regist", method= RequestMethod.GET)
	public String viewRegistPage() {
		return "member/regist";
	}
	@RequestMapping(value ="/regist", method= RequestMethod.POST)
	public ModelAndView doRegistPage(@ModelAttribute("regist-Form") @Valid MemberVO memberVO, Errors errors)
	{
		if (errors.hasErrors()) {
			return new ModelAndView("member/regist");
			
		}
		System.out.println(memberVO.getPassword());
		if( memberService.createMember(memberVO) ) {
			System.out.println(memberVO.getPassword() + "컨트롤러의 비밀번호");
			
			return new ModelAndView("redirect:/login");
			
		}
		return new ModelAndView("member/regist");
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage(HttpSession session) { //세션을 바로 가지고 올 수 있음
		
		if( session.getAttribute(Member.USER) != null ) {
			return "redirect:/";
		}//로그인이 필요한 페이지에 모두 넣어주면됨
		
		return "member/login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLoginAction(@ModelAttribute("loginForm") MemberVO memberVO, HttpSession session
								,Errors errors, HttpServletRequest request) {
		
		MemberVO loginMember= memberService.readMember(memberVO);
		
		if (loginMember != null) {
			session.setAttribute(Member.USER, loginMember);
			
			return "redirect:/";		
			}
			return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String doLogoutAction(MemberVO id, HttpSession session) {
		//삭제는 하나의 키만 지우는 것
		//세션 소멸 - 세션자체를 날림
		session.invalidate();
			
		return "redirect:/";
		
	}
		
	}
	
	