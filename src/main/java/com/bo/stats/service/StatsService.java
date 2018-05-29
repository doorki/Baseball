package com.bo.stats.service;

import java.util.List;

import com.bo.stats.vo.StatsVO;

public interface StatsService {
	
	public boolean createStats(StatsVO statsVO);
	public int removeStats();
	public List<StatsVO> getAll(StatsVO statsVO);
}
