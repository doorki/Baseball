package com.bo.stats.dao;

import java.util.List;

import com.bo.stats.vo.StatsVO;

public interface StatsDao {
	
	public int insertStats(StatsVO statsVO);
	
	public StatsVO selectOne(int id);
	public int deleteStats();
	public List<StatsVO> selectAll(StatsVO statsVO);
}
