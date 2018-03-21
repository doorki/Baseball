package com.bo.baseball.dao;

import java.util.List;

import com.bo.baseball.vo.BaseballVO;


public interface BaseballDao {

	public List<BaseballVO> selectAll();

	public BaseballVO selectOne(int id);


	
	
}
