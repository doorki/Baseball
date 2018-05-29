package com.bo.member.service;

import com.bo.baseball.dao.BaseballDao;
import com.bo.member.dao.MemberDao;
import com.bo.member.vo.MemberVO;
import com.bo.utill.SHA256Util;

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
		String salt = SHA256Util.generateSalt();
		memberVO.setSalt(salt);
		
		String password = memberVO.getPassword();
		password = SHA256Util.getEncrypt(password, salt);
		memberVO.setPassword(password);
		
		return memberDao.insertMember(memberVO) > 0;
	}
	@Override
	public MemberVO readMember(MemberVO memberVO) {
		//솔트 암호화
		//사용자의id로 salt가져오기
		String salt = memberDao.selectSalt(memberVO.getEmail());
		System.out.println(salt+" : salt test");
	
		if( salt == null) {
			salt = "";
		}
		//솔트로 암호화하기 
		String password = memberVO.getPassword();
		System.out.println(password+" : password test 1");
		
		password = SHA256Util.getEncrypt(password, salt);
		memberVO.setPassword(password);
		
		System.out.println(password+" : password test 2");
		
		return memberDao.selectMember(memberVO);
	}

	@Override
	public boolean deleteMember(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readCountMemberNickname(String nickname) {
		return memberDao.selectCountMemberNickname(nickname) > 0;
	}

	@Override
	public boolean readCountMemberEmail(String email) {
		return memberDao.selectCountMemberEmail(email) > 0;
	}
}

//로그인절차
