package com.bo.baseball.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bo.baseball.vo.BaseballSearchVO;
import com.bo.baseball.vo.BaseballVO;

public class BaseballDaoImplForOracle extends SqlSessionDaoSupport implements BaseballDao {
	/**
	 * SqlSessionDaoSupport sqlSessionTemplate Bean 객체를 가지고 있음.
	 *
	 */
	@Override
	public List<BaseballVO> selectAll(BaseballSearchVO baseballSearchVO) {
		return getSqlSession().selectList("BaseballDao.selectAll", baseballSearchVO);
	}

	@Override
	public BaseballVO selectOne(int id) {
		return getSqlSession().selectOne("BaseballDao.selectOne", id);
	} // 인터페이스 명 //메소드명 붙여 넣기

	@Override
	public int insertBaseball(BaseballVO baseballVO) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("BaseballDao.insertBaseball", baseballVO);
	}

	@Override
	public int incrementViewCount(int id) {
		// TODO Auto-generated method stub
		return getSqlSession().update("BaseballDao.incrementViewCount", id);
	}

	@Override
	public int incrementRecommendCount(int id) {
		return getSqlSession().update("BaseballDao.incrementRecommendCount", id);
	}

	@Override
	public int deletePage(int id) {
		return getSqlSession().delete("BaseballDao.deletePage", id);
	}

	@Override
	public int selectCountAll(BaseballSearchVO baseballSearchVO) {
		return getSqlSession().selectOne("BaseballDao.selectCountAll", baseballSearchVO);
	}
}