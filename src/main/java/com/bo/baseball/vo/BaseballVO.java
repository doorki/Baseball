package com.bo.baseball.vo;

import javax.validation.constraints.NotEmpty;

import com.bo.member.vo.MemberVO;
import com.bo.team.vo.TeamVO;

public class BaseballVO {

		private int id;
		
		@NotEmpty(message = "제목은 필수 입력입니다.")
		private String title;
		@NotEmpty(message = "내용은 필수 입니다.")
		private String body;
//		@NotEmpty(message = "로그인이 필요합니다.")
//		private String nickname;
		private int userId;
		private String writeDate;
		private int viewCount;
		private int recommendCount;
		private String team;
		private MemberVO memberVO; //작성자의 정보 테이블을 조인하면 vo도 조인해야함.
		private TeamVO	teamVO;
		
		public String getTeam() {
			return team;
		}
		public void setTeam(String team) {
			this.team = team;
		}
		public TeamVO getTeamVO() {
			return teamVO;
		}

		public void setTeamVO(TeamVO teamVO) {
			this.teamVO = teamVO;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getWriteDate() {
			return writeDate;
		}

		public void setWriteDate(String writeDate) {
			this.writeDate = writeDate;
		}

		public int getViewCount() {
			return viewCount;
		}

		public void setViewCount(int viewCount) {
			this.viewCount = viewCount;
		}

		public int getRecommendCount() {
			return recommendCount;
		}

		public void setRecommendCount(int recommendCount) {
			this.recommendCount = recommendCount;
		}

		public MemberVO getMemberVO() {
			return memberVO;
		}

		public void setMemberVO(MemberVO memberVO) {
			this.memberVO = memberVO;
		}
	
		
}
