package com.bo.baseball.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bo.baseball.service.BaseballService;
import com.bo.baseball.vo.BaseballVO;

@Controller
public class BaseballController {
	
	private BaseballService baseballService;
	
	public void setBaseballService(BaseballService baseballService) {
		this.baseballService = baseballService;
	}

	@RequestMapping("/")
	public ModelAndView viewListPage(HttpSession session) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName("baseball/list");

		List<BaseballVO> baseballList = baseballService.getAll();

		view.addObject("baseballList", baseballList);
		
		return view;
	}
	@RequestMapping("/view/{id}") // id 이름 같아야함
	public ModelAndView viewViewPage(HttpSession session, @PathVariable int id) {
		ModelAndView view = new ModelAndView();

		view.setViewName("baseball/view");

		BaseballVO baseball = baseballService.getOne(id);
		view.addObject("baseball", baseball);
		return view;

	}

}
