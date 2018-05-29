package com.bo.member.service;

import com.bo.member.vo.MemberVO;

public interface MemberService {

	public boolean createMember(MemberVO memberVO);
	public MemberVO readMember(MemberVO memberVO);
	public boolean deleteMember(int id);
	public boolean readCountMemberNickname(String nickname);
	public boolean readCountMemberEmail(String email);
}
