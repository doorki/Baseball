package com.bo.member.dao;

import com.bo.member.vo.MemberVO;

public interface MemberDao {
		//	전달된 파라미터를 넣는다 
public int insertMember(MemberVO memberVO);  

public MemberVO selectMember(MemberVO memberVO);

public String selectSalt(String email);

public int deleteMember(int id);

public int selectCountMemberNickname(String nickname);

public int selectCountMemberEmail(String email);
}
