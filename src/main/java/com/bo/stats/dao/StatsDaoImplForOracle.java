package com.bo.stats.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bo.stats.vo.StatsVO;

public class StatsDaoImplForOracle extends SqlSessionDaoSupport implements StatsDao {
	
	
	@Override
	public List<StatsVO> selectAll(StatsVO statsVO) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("StatsDao.selectAll", statsVO);
	}

	@Override
	public StatsVO selectOne(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("StatsDao.selectOne", id);
	}

	@Override
	public int insertStats(StatsVO statsVO) {
		return getSqlSession().insert("StatsDao.insertStats", statsVO);
	}

	@Override
	public int deleteStats() {
		// TODO Auto-generated method stub
		return getSqlSession().delete("StatsDao.deleteStats");
	}



}
