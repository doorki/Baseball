package com.bo.baseball.service;

import java.util.List;

import com.bo.baseball.dao.BaseballDao;
import com.bo.baseball.vo.BaseballVO;

public class BaseballServiceImpl implements BaseballService {
	
	private BaseballDao baseballDao;
	
	public void setBaseballDao(BaseballDao baseballDao) {
		this.baseballDao = baseballDao;
	}
	
	@Override
	public List<BaseballVO> getAll() {
		return baseballDao.selectAll();
	}

	@Override
	public BaseballVO getOne(int id) {
		return baseballDao.selectOne(id);
	}

	@Override
	public boolean incrementVC(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void incrementRC(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean createBaseball(BaseballVO baseballVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBaseball(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBaseball(BaseballVO baseballVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
