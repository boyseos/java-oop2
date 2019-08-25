package com.bitcamp.services;

import javax.swing.JOptionPane;

import com.bitcamp.controllers.AdminController;
import com.bitcamp.controllers.MemberController;
import com.bitcamp.domains.MemberBean;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지
 * 3. 비번 수정
 * 4. 회원탈퇴
 * 5. 중복 아이디 체크
 * 6. 로그인(유저변경)
 * 7. 관리자메뉴 전환
 * **********
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체 회원수
 * 5. 유저메뉴 전환
 * */
public class MemberService {
	private MemberBean[] members;
	private int count;

	public MemberService() {
		members = new MemberBean[10];
		count = 0;
	}
	
	/******************************************
	 * 	사용자 기능
	 ******************************************/	
	/**
	 * 1. 회원가입
	 * */
	public String join(MemberBean param) {
			param.setIndex(count);
			members[count] = param;
			count++;
			return "가입 되었습니다.";
	}
	/**
	 * 2. 마이페이지
	 * */
	public String getMyPage(MemberBean param) {
		return param.toString();
	}
	/**
	 *  3. 비번 수정(ID, 옛날비번, 신규비번 입력받아서 옛날비번을 체크 후 일치하면 신규비번으로 변경 )
	 *  비번변경후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공, 옛날비번 로그인 실패
	 * */
	public MemberBean changePw(MemberBean param) {
		String[] pwn = param.getPw().split("-");
		int num = 0;
		for (int i = 0; i < count; i++,num++) {
			if (param.getId().equals(members[i].getId())&&(pwn[0].equals(members[i].getPw()))) {
				members[i].setPw(pwn[1]);
				return members[num];
			}
		}
		return null;
	}
	/**
	 *  4. 회원탈퇴
	 * */
	public MemberBean withDrawal(MemberBean param) {
		int delUser = 0;
		for (int i = 0; i < count; i++,delUser++) {
			if(param.getId().equals(members[i].getId())){
				break;
			}
		}
		count--;
		members[delUser] = members[count];
		members[count] = null;
		return members[count-1];
	}
	
	/**
	 *  5. 중복 아이디체크
	 * */
	public String existId(String id) {
		String result = "없는 아이디";
		for (int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())){
				result = "존재하는 아이디";
				break;
			}
		}
		return result;
	}
	// 6.로그인 파라미터로 id와 pw만 입력받은 상태.
	
	public MemberBean login(MemberBean param) {
		for (int i = 0; i < count; i++) {
			if (param.getId().equals(members[i].getId()) && param.getPw().equals(members[i].getPw())) {
				param = members[i];
				break;
			}
		}
		return param;
	}
	
	/**
	 * 7. 관리자메뉴 전환 
	  어드민컨트롤러 메소드 실행*/
	public void adminMenu() {
		AdminController.main(null);
	}
	/** 
	 * 8. indexPlus
	 */
	public MemberBean indexPlus(MemberBean param) {
		for(int i = 0; i < count; i++) {
			if(param.getId().equals(members[i].getId())) {
				return members[i+1];
			}
		}
		return param;
	}
	/**
	 * 9. indexMinus 
	 */
	public MemberBean indexMinus(MemberBean param) {
		for(int i = 0; i < count; i++) {
			if(param.getId().equals(members[i].getId())) {
				return members[i-1];
			}
		}
		return param;
	}

	/**************************************************************
	 * 관리자기능
	 *  * 개발자메뉴 
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색
 * 4. 전체회원수
 * 5. 유저메뉴
	 */
	
	
	
	
	/******************************************
	 * 	관리자 기능
	 ******************************************/
	/**
	 *  1.회원목록
	 * */
	public String list() {
		String msg = "";
		for(int i=0;i<count;i++) {
			msg += members[i].toString()+"\n";
		}
		return msg;
	}
	/**
	 *  2.아이디검색
	 * */
	public MemberBean searchId(String id) {
		for(int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())) {
				return members[i];
			}
		}
		return null;
	}
	/**
	 *  3.이름검색
	 * */
	public MemberBean[] findByName(String name) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if(name.equals(this.members[i].getName())){
				num++;//동명이인 수
			}
		}
		MemberBean[] members = new MemberBean[num];
		num = 0;
		for(int i = 0; i < count; i++) {
			if(name.equals(this.members[i].getName())){
				members[num] = this.members[i];
				num++;
				if(members.length == num)
					break;
			}
		}
		return members;
	}
	/**
	 * 전체회원수
	 * 4	 */
	public String countAll() {
		return "총회원수 : "+count;
	}
	
	/**
	 * 5. 유저메뉴 전환   보류. 메인메소드 자체가 애드민컨트롤쪽으로 넘어가야하는데 어떻게함...!? 메인메소드도 메소드라 호출하니까 알아서 바뀜..
	 * 실행은 되나 전환시 정보교환이 전혀 안되는듯. 
	 */
	public void userMenu() {
		MemberController.main(null);
	}

}
