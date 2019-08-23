package com.bitcamp.controllers;
import javax.swing.JOptionPane;

import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
public class MemberController {

	public static void main(String[] args) {
		MemberService service = new MemberService();
		MemberBean member = null;
		String [] arr = null;
		String temp = "";
		while(true) {
			switch (JOptionPane.showInputDialog("0.종료 \n"
					+ "1.회원가입 \n"
					+ "2.마이페이지 \n"
					+ "3.비밀번호 수정 \n"
					+ "4.회원탈퇴 \n"
					+ "5.회원목록 \n"
					+ "6.아이디 검색 \n"
					+ "7.이름 검색 \n"
					+ "8.로그인")) {
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1" :
				String spec = JOptionPane.showInputDialog("이름, 아이디, 비밀번호, 주민번호, 혈액형, 키 , 몸무게");
				System.out.println("****" + spec);
				arr = spec.split(",");
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPas(arr[2]);
				member.setBirth(arr[3]);
				member.setBld(arr[4]);
				member.setHei(Double.parseDouble(arr[5]));
				member.setWei(Double.parseDouble(arr[6]));
				
				JOptionPane.showMessageDialog(null, service.join(member));

				break;
			case "2" :
				JOptionPane.showMessageDialog(null, service.getMyPage(member));
			
			break;
			
			case "3" : 
				temp = JOptionPane.showInputDialog("ID, 기존 비밀번호, 신규 비밀번호");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPas(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null, service.changePassword(member));
				
				
				break;
				
			case "4" : 
				
				break;
				
			case "5" : 
				JOptionPane.showMessageDialog(null, service.list(member));
			
			break;
			
			case "6" : 
				String searchId = JOptionPane.showInputDialog("검색 ID");
				member = service.findById(searchId);
				JOptionPane.showMessageDialog(null, member);
				
				break;
				
			case "7" :
				String searchName = JOptionPane.showInputDialog("이름 검색");
				//member = service.findByName(searchName);
				//JOptionPane.showMessageDialog(null, mamber);
				break;
				
			case "8" :
				String loginValue = JOptionPane.showInputDialog("로그인 ID, PW");
				String[] loginValues = loginValue.split(",");
				String loginId = loginValues[0];
				String loginpas = loginValues[1];
				member = new MemberBean();
				member.setId(loginId);
				member.setPas(loginpas);
				String msg = service.login(member);
				JOptionPane.showMessageDialog(null, msg);
			default:
				break;
			}
		}
		

	}

}
