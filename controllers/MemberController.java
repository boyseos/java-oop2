package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;


public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = null;
		String[] arr = null;
		MemberBean[] members = null;
		String result = "";
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 \n"
					+ "1.회원가입\n"
					+ "2.마이페이지\n"
					+ "3.비번 수정\n"
					+ "4.회원탈퇴\n"
					+ "5.중복 아이디체크\n"
					+ "6.로그인(유저변경)\n"
					+ "7.관리자메뉴 전환(사용금지)\n"
					+ "8.+\n"
					+ "9.-\n"
					+ "11.회원목록\n"
					+ "12.아이디검색\n"
					+ "13.이름검색")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				
				return;
			case "1"://회원가입
//				temp = JOptionPane.showInputDialog("이름,아이디,비번,주민번호,혈액형,키,몸무게 ");
//				System.out.println("****" + temp);
//				arr = temp.split(",");
//				member = new MemberBean();
//				member.setName(arr[0]);
//				member.setId(arr[1]);
//				member.setPw(arr[2]);
//				member.setSsn(arr[3]);
//				member.setBlood(arr[4]);
//				member.setHeight(Double.parseDouble(arr[5]));
//				member.setWeight(Double.parseDouble(arr[6]));
//				JOptionPane.showMessageDialog(null, service.join(member));
				String setArr = "바보,id,pw,ssn,blood,155.5,55.5";
				arr = setArr.split(",");
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
			case "2": //마이페이지
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
				break;
			case "3": //비번수정
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("아이디를 입력하세요"));
				member.setPw(JOptionPane.showInputDialog("현재비번-변경할비번"));
				member = service.changePw(member);
				break;
			case "4":
				member = service.withDrawal(member);
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.existId(JOptionPane.showInputDialog("검색 ID")));
				break;
			case "6":
				String loginValue = JOptionPane.showInputDialog("로그인 ID, PW"); 
				arr = loginValue.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPw(arr[1]);
				member = service.login(member);
				JOptionPane.showMessageDialog(null, member.getId()+"유저 로그인"); 
				break;
			case "7":
				arr = new String[7];
				arr[0] = member.getName();
				arr[1] = member.getId();
				arr[2] = member.getPw();
				arr[3] = member.getSsn();
				arr[4] = member.getBlood();
				arr[5] = String.valueOf(member.getHeight());
				arr[6] = String.valueOf(member.getWeight());
				service.adminMenu(arr);
				break;
			case "8":
				member = service.indexPlus(member);	
				break;
			case "9":
				member = service.indexMinus(member);	
				break;
			case "11" : 
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "12" :
				member = service.searchId(JOptionPane.showInputDialog("검색할 아이디를 입력하세요."));
				JOptionPane.showMessageDialog(null, member.toString());
				break;
			case "13" :
				members = new MemberBean[3];
				members = service.findByName(JOptionPane.showInputDialog("검색할 이름을 입력하세요."));
				for (int i = 0; i < members.length; i++) {//검색은 항상 브레이크.
					if (members[i].getId() == null)	{
						break;					
						}
					result += members[i].toString() + "\n";// 멤버스인스턴스배열을 대충 3칸만 만들었기때문에 사용하는것만 파악해서 저장.
				}
				JOptionPane.showMessageDialog(null, result);
				result = "";
				break;
			default:
				break;
			}
		}

	}

}