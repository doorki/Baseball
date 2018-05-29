package com.bo.baseball.dao;

import java.util.List;

import com.bo.baseball.vo.BaseballSearchVO;
import com.bo.baseball.vo.BaseballVO;


public interface BaseballDao {
	
	public int selectCountAll(BaseballSearchVO baseballSearchVO);
	
	public List<BaseballVO> selectAll(BaseballSearchVO baseballSearchVO);

	public BaseballVO selectOne(int id);
	
	
	public int insertBaseball(BaseballVO baseballVO);
	
	public int incrementViewCount(int id);
	
	public int incrementRecommendCount(int id);
	
	public int deletePage(int id);

	
	
}
