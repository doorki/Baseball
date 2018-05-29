package com.bo.baseball.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bo.baseball.service.BaseballService;
import com.bo.baseball.vo.BaseballSearchVO;
import com.bo.baseball.vo.BaseballVO;
import com.bo.member.constants.Member;
import com.bo.member.vo.MemberVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

@Controller
public class BaseballController {
	
	private BaseballService baseballService;
	
	public void setBaseballService(BaseballService baseballService) {
		this.baseballService = baseballService;
	}
		 
		@RequestMapping("/view/{id}") // id 이름 같아야함
		public ModelAndView viewViewPage(HttpSession session, @PathVariable int id) {
		// 로그인한 회원만 들어올 수 있다 아이디값 변수
		// if (session.getAttribute(Member.USER) == null) {
		// // /WEB-INF/view/community/list.jsp
		// return new ModelAndView("redirect:/login");
		// }
		ModelAndView view = new ModelAndView();

		view.setViewName("baseball/view");

		// TODO id 로 게시글 얻어오기
		BaseballVO baseball = baseballService.getOne(id);
		view.addObject("baseball", baseball);
		return view;

	}

	@RequestMapping("/reset")
	public String viewInitListPage(HttpSession session) {
		session.removeAttribute("__SEARCH__");
		return "redirect:/column";
	}
	
	
	@RequestMapping("/column") // id 이름 같아야함
	public ModelAndView viewColumn(BaseballSearchVO baseballSearchVO, HttpSession session) {
		
		//데이터가 안넘어왔을 때 
				//1. 리스트페이지에 처음 접근했을 때
				//2. 글 내용을 보고, 목록보기 링크를 클릭했을 때
			
			if ( baseballSearchVO.getPageNo() < 0 ) {
				System.out.println("1");
				//Session 에 저장된 CommunitySerachVO를 가져옴
				baseballSearchVO = (BaseballSearchVO) session.getAttribute("__SEARCH__");
				System.out.println(baseballSearchVO+"@@@@@@@@@@@@값");
				//Session 에 저장된 CommunitySerachVO가 없을 경우, PageN = 0으로 초기화
				if ( baseballSearchVO == null ) {
					System.out.println("2");
					baseballSearchVO = new BaseballSearchVO();
					baseballSearchVO.setPageNo(0);
				}
					
				}
				session.setAttribute("__SEARCH__", baseballSearchVO);
				
				ModelAndView view = new ModelAndView();
				view.setViewName("baseball/column");
				view.addObject("search", baseballSearchVO);
				
				PageExplorer pageExplorer = baseballService.getAll(baseballSearchVO);
				System.out.println(pageExplorer.getTotalCount());
				view.addObject("pageExplorer", pageExplorer);
				
				return view;
	}
		@RequestMapping(value = "/write", method = RequestMethod.GET) // get
		public String viewWritePage(HttpSession session) { 
			
			return "/baseball/write";

	}

	@RequestMapping(value ="/write", method = RequestMethod.POST) // post
	// @PostMapping("/write")
	public ModelAndView doWrite(@ModelAttribute("writeForm") @Valid // valid 다음 errors 순서 중요.(뒤에 와야함)
	BaseballVO baseballVO, Errors errors, HttpSession session, HttpServletRequest request) {

//	if (session.getAttribute(Member.USER) == null) {
//	    return new ModelAndView("redirect:/");
//	}
//	
		ModelAndView view = new ModelAndView();
		if (errors.hasErrors()) {
		view.setViewName("baseball/write");
		view.addObject("baseballVO", baseballVO);
		return view;
	}
//		MemberVO member = (MemberVO)session.getAttribute(Member.USER);
//		baseballVO.setUserId(member.getId());
//		baseballService.createBaseball(baseballVO);
		
		boolean isSuccess = baseballService.createBaseball(baseballVO);
		if (isSuccess) {
			return new ModelAndView("redirect:/reset");
		}
		return new ModelAndView("redirect:/write");
	}

	
//		return new ModelAndView("redirect:/column");
//	}
//	
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable int id, HttpSession session) {
		
		MemberVO member = (MemberVO)session.getAttribute(Member.USER);
		BaseballVO baseball = baseballService.getOne(id);
		
		boolean isMyBaseball = member.getId() == baseball.getUserId();
		//내가 쓴건지 확인
		if( isMyBaseball && baseballService.deleteBaseball(id) ) {
			return "redirect:/";
		}
		
		return "/WEB-INF/view/error/404";
		
	}
		
	@RequestMapping("/read/{id}")
	public String incrementViewCountFunc(@PathVariable int id, HttpSession session) {


		if (baseballService.incrementVC(id)) {
			return "redirect:/view/" + id;
		}
		return "redircet:/column";
	}
	
	@RequestMapping("/recommend/{id}")
	public String recommendCount(@PathVariable int id) {
		
		baseballService.incrementRC(id);

		return "redirect:/view/" + id;
	}
}
