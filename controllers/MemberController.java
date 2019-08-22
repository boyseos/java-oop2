package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
public class MemberController {
	public static void main(String[] args) {
		MemberBean member = null;
		MemberService service = new MemberService();
		while(true) {
			switch (JOptionPane.showInputDialog("0. 종료\n"
					+ "1.회원가입\n "
					+ "2.마이페이지\n "
					+ "3.비번수정\n "
					+ "4.회원탈퇴\n"
					+ "5.목록보기\n"
					+ "6.아이디검색")) {
			case "0":
				return;
			case "1":
//				String[] arr = JOptionPane.showInputDialog("이름,아이디,비번,민번,혈액형,키,몸무게").split(",");
//				member = new MemberBean();
//				member.setName(arr[0]);
//				member.setId(arr[1]);
//				member.setPw(arr[2]);
//				member.setSsn(arr[3]);
//				member.setBlood(arr[4]);
//				member.setHeight(Double.parseDouble(arr[5]));
//				member.setWeight(Double.parseDouble(arr[6]));
//				JOptionPane.showMessageDialog(null, service.join(member));
			String[] arr = {"바보","124","1234","55555","B","155.5","55.5"};
			for(int i = 0; i< 4; i++) {
				member = new MemberBean();//참조변수 멤버의 이름은 같지만 생성자 뉴에의해 공간은 새로 생성되고 생성된 공간은 join을 통해 서비스쪽에서 members배열에 저장된다.
				member.setName(arr[0]+i);
				member.setId(arr[1]+i);
				member.setPw(arr[2]+i);
				member.setSsn(arr[3]+i);
				member.setBlood(arr[4]+i);
				member.setHeight(Double.parseDouble(arr[5])+i);
				member.setWeight(Double.parseDouble(arr[6])+i);
				JOptionPane.showMessageDialog(null, service.join(member));
			}
				break;
			case "2":
				JOptionPane.showMessageDialog(null, member.toString());
				break;
			case "3":
				service.changePw(JOptionPane.showInputDialog("바꿀 비번을 입력하세요"));
				break;
			case "4":
				member = service.withDrawal();
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "6":
				member = service.searchId(JOptionPane.showInputDialog("찾을 아이디를 입력하세요"));
				break;
			default:
				break;
			}
		}
	}
}
