package com.bitcamp.domains;

public class MemberBean {
	private String name, id, pw, ssn, blood;
	private double weight, height;
	private int index;//관리상 번호가 붙는게 처리하기가 훨씬 편한듯... id와 마찬가지로 유니크한 값을 가져야하는데 회원탈퇴가정하면 어차피 2번 일하게 되는건가.
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPw() {
		return pw;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSsn() {
		return ssn;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public String getBlood() {
		return blood;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return weight;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
	}
	
	@Override
	public String toString() {
		return String.format("이름 : %s\n"
				+ "아이디 : %s\n"
				+ "비번 : %s\n"
				+ "민번 : %s\n"
				+ "혈액형 : %s\n"
				+ "몸무게 : %s\n"
				+ "키 : %s\n " , name, id, pw, ssn, blood,weight, height);
	}
}
