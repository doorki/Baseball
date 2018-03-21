package com.bo.member.service;

import com.bo.baseball.dao.BaseballDao;
import com.bo.member.dao.MemberDao;
import com.bo.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	private BaseballDao baseballDao;
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void setBaseballDao(BaseballDao baseballDao) {
		this.baseballDao = baseballDao;
	}

	@Override
	public boolean createMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return memberDao.insertMember(memberVO) > 0;
	}
	@Override
	public MemberVO readMember(MemberVO memberVO) {
		return memberDao.selectMember(memberVO);
	}

	@Override
	public boolean deleteMember(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}

//로그인절차
