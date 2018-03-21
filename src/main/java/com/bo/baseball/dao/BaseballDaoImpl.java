package com.bo.baseball.dao;

import java.util.ArrayList;
import java.util.List;

import com.bo.baseball.vo.BaseballVO;

public class BaseballDaoImpl implements BaseballDao {
	
	private List<BaseballVO> baseballList;
	
	public BaseballDaoImpl() {
		baseballList = new ArrayList<BaseballVO>();
	}
	
	@Override
	public List<BaseballVO> selectAll() {
	return baseballList;
	}

	@Override
	public BaseballVO selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}

