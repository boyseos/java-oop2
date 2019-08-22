package com.bitcamp.services;

import com.bitcamp.domains.MemberBean;
/**
 * 요구사항 (기능정의)
 * 1. 회원가입
 * 2. 마이페이지 회원정보보기
 * 3. 비번수정
 * 4. 회원탈퇴
 *******************
 * 개발자메뉴 
 * 5. 회원목록
 * 6. 아이디검색
 **/
public class MemberService {
	private MemberBean[] members;
	private int count;

	public MemberService() {
		members = new MemberBean[5];
		count = 0;
	}
	public String join(MemberBean param) {
			members[count] = param;
			count++;
			return String.format("%d명의 회원이 있습니다.", count);
	}
	public String getmypage(MemberBean param) {
		return toString();
	}
	public String changePw(String pw) {
		members[count-1].setPw(pw);
		return members[count-1].getPw();
	}
	public MemberBean withDrawal() {
		count--;
		members[count] = null;
		// 인스턴스생성후 카운트가 +1됨으로 현재 members의 공간은 -1한 공간이며 이곳의 주소(공간)를 비워버리면 실제 인스턴스는 살아있...지만? 어느공간인지를 알수없으니 사용은 못할듯싶다.
		return members[count-1];
	}
	public String list() {
		String result = "";
		for(int i = 0; i < count; i++) {
			result += members[i].toString();
		}
		return result;
	}
	public MemberBean searchId(String id) {
		for(int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())) {
				System.out.println(id);
				System.out.println(i);
				return members[i];
			}
		}
		return null;
	}
}
