package com.bo.team.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bo.team.vo.TeamVO;

public class TeamDaoImplForOracle extends SqlSessionDaoSupport implements TeamDao {

	@Override
	public List<TeamVO> selectAll(TeamVO teamVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("TeamDao.selectAll", teamVO);
	}


}
