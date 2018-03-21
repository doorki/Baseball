package com.bo.baseball.service;

import java.util.List;

import com.bo.baseball.vo.BaseballVO;

public interface BaseballService {

	List<BaseballVO> getAll();

	public BaseballVO getOne(int id);

	public boolean incrementVC(int id);

	public void incrementRC(int id);

	public boolean createBaseball(BaseballVO baseballVO);

	public boolean deleteBaseball(int id);

	public boolean updateBaseball(BaseballVO baseballVO);
}
