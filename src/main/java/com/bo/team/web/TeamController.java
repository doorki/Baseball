package com.bo.team.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bo.team.service.TeamService;
import com.bo.team.vo.TeamVO;

@Controller
public class TeamController {

	private TeamService teamService;
	private List<TeamVO> teamList;
	
	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}
	@RequestMapping("/team") 
	   public ModelAndView viewTeamPage(TeamVO teamVO) {
		  
		ModelAndView view = new ModelAndView();
		  
		  view.setViewName("baseball/team");
		  
		  List<TeamVO> teamList = teamService.getAll(teamVO);
		  
		  view.addObject("teamList", teamList);
		  
		  return view;
	   }
}
