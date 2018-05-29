package com.bo.baseball.service;

import java.util.List;

import com.bo.baseball.dao.BaseballDao;
import com.bo.baseball.vo.BaseballSearchVO;
import com.bo.baseball.vo.BaseballVO;

import io.github.seccoding.web.pager.Pager;
import io.github.seccoding.web.pager.PagerFactory;
import io.github.seccoding.web.pager.explorer.ClassicPageExplorer;
import io.github.seccoding.web.pager.explorer.PageExplorer;

public class BaseballServiceImpl implements BaseballService {
	
	private BaseballDao baseballDao;
	
	public void setBaseballDao(BaseballDao baseballDao) {
		this.baseballDao = baseballDao;
	}
	
	@Override
	public PageExplorer getAll(BaseballSearchVO baseballSearchVO) {
		
		Pager pager = PagerFactory.getPager(Pager.ORACLE, baseballSearchVO.getPageNo()+"", baseballDao.selectCountAll(baseballSearchVO));
		
		PageExplorer pageExplorer = pager.makePageExplorer(ClassicPageExplorer.class, baseballSearchVO);
		
		pageExplorer.setList(baseballDao.selectAll(baseballSearchVO));
		
		return pageExplorer;
	}

	@Override
	public BaseballVO getOne(int id) {
		// TODO Auto-generated method stub
		return baseballDao.selectOne(id);
	}

	@Override
	public boolean createBaseball(BaseballVO baseballVO) {
		
		String body = baseballVO.getBody();
		
		body = body.replace("\n", "<br/>");
		//body다시 넣어주기
		baseballVO.setBody(body);
		
//		if( filter(body) || filter(communityVO.getTitle())) {
//			
//			return false;
//			
//		}
		
		int insertCount = baseballDao.insertBaseball(baseballVO);
		return insertCount > 0;
		
	}

	@Override
	public void incrementRC(int id) {
		
	baseballDao.incrementRecommendCount(id);
		
	}
	
	@Override
	public boolean deleteBaseball(int id) {
		
		if( baseballDao.deletePage(id) > 0 ) {
			return true;
		}
		
			return false;
	}
		
	@Override
	public boolean incrementVC(int id) {
		// TODO Auto-generated method stub
	return baseballDao.incrementViewCount(id) > 0 ;
	}


}