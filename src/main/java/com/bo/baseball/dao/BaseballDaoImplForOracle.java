package com.bo.baseball.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.bo.baseball.vo.BaseballVO;

public class BaseballDaoImplForOracle extends SqlSessionDaoSupport implements BaseballDao {
	/**
	 * SqlSessionDaoSupport sqlSessionTemplate Bean 객체를 가지고 있음.
	 *
	 */
	@Override
	public List<BaseballVO> selectAll() {
		return getSqlSession().selectList("BaseballDao.selectAll");
	}

	@Override
	public BaseballVO selectOne(int id) {
		return getSqlSession().selectOne("BaseballDao.selectOne", id);
	} // 인터페이스 명 //메소드명 붙여 넣기
}