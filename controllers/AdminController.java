package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class AdminController {
	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = new MemberBean(); // 서비스와 마찬가지로 하나만 생성하니까..!
		MemberBean[] members = new MemberBean[3]; //몇명을 받을지 알수없어서 일단 만들었다. 제대로하려면 인원수부터 파악하는 메소드를 만들던가 해야할듯..
		String temp = "";
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료 \n"
					+ "1.회원목록\n"
					+ "2.아이디검색\n"
					+ "3.이름검색\n"
					+ "4.유저메뉴 전환"
					)) {
			case "0" : return;
			case "1" : 
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "2" :
				member = service.searchId(JOptionPane.showInputDialog("검색할 아이디를 입력하세요."));
				JOptionPane.showMessageDialog(null, member.toString());
				break;
			case "3" :
				members = service.findByName(JOptionPane.showInputDialog("검색할 이름을 입력하세요."));
				for (int i = 0; i < members.length; i++) {
					if (members[i].getId() != null) {
						temp += members.toString() + "\n";// 멤버스인스턴스배열을 대충 3칸만 만들었기때문에 사용하는것만 파악해서 저장.
					}
				}
				JOptionPane.showMessageDialog(null, temp);
				break;
			case "4" :
				service.userMenu();
				return;
			}
		}

	}

}