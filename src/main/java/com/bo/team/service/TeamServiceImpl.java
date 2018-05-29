package com.bo.team.service;

import java.util.List;

import com.bo.team.dao.TeamDao;
import com.bo.team.vo.TeamVO;

public class TeamServiceImpl implements TeamService {

	private TeamDao teamDao;
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	@Override
	public List<TeamVO> getAll(TeamVO teamVO) {
		
		return teamDao.selectAll(teamVO);
	}
}
