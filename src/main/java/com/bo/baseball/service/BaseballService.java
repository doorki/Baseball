package com.bo.baseball.service;

import com.bo.baseball.vo.BaseballSearchVO;
import com.bo.baseball.vo.BaseballVO;

import io.github.seccoding.web.pager.explorer.PageExplorer;

public interface BaseballService {

	public PageExplorer getAll(BaseballSearchVO baseballSearchVO);
	
	public BaseballVO getOne(int id);

	public boolean createBaseball(BaseballVO baseballVO);
	
	public void incrementRC(int id);
	
	public boolean incrementVC(int id);
	
	public boolean deleteBaseball(int id);
}
