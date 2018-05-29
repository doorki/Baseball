package com.bo.stats.service;

import java.util.List;

import com.bo.stats.dao.StatsDao;
import com.bo.stats.vo.StatsVO;

public class StatsServiceImpl implements StatsService {
		
	private StatsDao statsDao;
	
	public void setStatsDao(StatsDao statsDao) {
		this.statsDao = statsDao;
	}

	@Override
	public boolean createStats(StatsVO statsVO) {
		
		int insertCount = statsDao.insertStats(statsVO);
		return insertCount > 0;
		
	}

	@Override
	public List<StatsVO> getAll(StatsVO statsVO) {
		
		return statsDao.selectAll(statsVO);
	}

	@Override
	public int removeStats() {
		// TODO Auto-generated method stub
	 return statsDao.deleteStats();
	}

}
