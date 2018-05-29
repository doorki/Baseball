package com.bo.team.dao;

import java.util.List;

import com.bo.team.vo.TeamVO;

public interface TeamDao {

	public List<TeamVO> selectAll(TeamVO teamVO);
}
