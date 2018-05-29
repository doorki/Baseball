package com.bo.team.service;

import java.util.List;

import com.bo.team.vo.TeamVO;

public interface TeamService{
	public List<TeamVO> getAll(TeamVO teamVO);
}
