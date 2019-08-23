package com.bitcamp.services;
import javax.swing.JOptionPane;

import com.bitcamp.domains.MemberBean;
/**
 * 요구사항(기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지
 * 3. 비밀번호 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 로그인
 * **************
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디 검색
 * 3. 이름 검색
 * 4. 전체 회원 수
 */
public class MemberService {
	private MemberBean[] members;
	private int count;
	
	public MemberService() {
		members = new MemberBean[3];
		count = 0;
	}
	/********************************************************************
	 * 		사용자 기능
	 ********************************************************************/
	/**
	 * 1. 회원가입
	 */
	public String join(MemberBean param) {
		String msg = "회원가입 성공";
		members[count] = param;
		count++;
		return msg;
	}
	/**
	 * 2.마이페이지
	 */
	public String getMyPage(MemberBean param) {
		return param.toString();
	}
	/**
	 * 3. 비밀번호 수정 (ID, 기존 비밀번호, 신규 비밀번호를 입력받아서 기존 비밀번호를 체크 후 일치하면 신규 비밀번호로 변경)
	 * 비밀번호 변경 후 로그인을 실행해서 새로 바뀐 비밀번호가  로그인 성공, 기존 비밀번호는 로그인 실패
	 */
	public String changePassword(MemberBean param) {
		String msg = "비밀번호가 변경되었습니다.";
		String id = param.getId();
		String pas = param.getPas();
		String[] pws = pas.split(",");
		String oldPas = pws[0];
		String newPas = pws[1];		
		
		for(int i=0; i<count; i++) {
			if(param.getId().equals(members[i].getId())
				&& param.getPas().equals(members[i].getPas())){
				members[i].setPas(newPas);
				break;
			}
			}
			return msg;
		
			}
		
			
		
		
	
	/**
	 * 4. 회원탈퇴
	 */
	public String withdrawal(MemberBean param) {
		String msg = "회원탈퇴 완료";
		return msg;
	}	
	/**
	 * 5. 아이디 체크
	 */
	public String existId(String id) {
		String msg = "가입 가능한 아이디 입니다.";
		//이미 존재하는 아이디.
		MemberBean member = new MemberBean();
		
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].getId())) {
				break;
								
			}
			
		}
		return msg;	
	}
	/**
	 * 6. 로그인(파라미터로 ID, PW 만 입력받은 상태)
	 * */
	public String login(MemberBean param) {
		String id = param.getId();
		String pas = param.getPas();
		String msg = "로그인 실패";
		
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].getId())&&pas.equals(members[i].getPas())) {
				msg = "로그인 성공";
				
				break;
			}
			}
					
			return msg;
	
	}
	
	
/********************************************************************
 * 		관리자 기능
 ********************************************************************/
	/** 
	 * 1. 회원목록
	 * 
	*/
	public String list(MemberBean param) {
		String msg = "";
		for(int i=0; i<count; i++) {
			msg += members[i].toString()+ ", \n";
		}
		return msg;
	}
	/** 2. 아이디 검색
	 */
	public MemberBean findById(String id){
		MemberBean member = new MemberBean();
		for(int i=0; i<count; i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];	
			break;
			}
		}
		return member;	
	}
	/**
	 * 3.이름 검색
	 */
	public MemberBean[] findByName(String name) {	
		int j = 0;
		for(int i=0; i<count; i++) {
		if(name.equals(this.members[i].getName())) {
			j++;
		}
		}
		
		MemberBean[] members = new MemberBean[j];
		
		for(int i=0; i<count; i++) {					
			if(name.equals(this.members[i].getName())) {
					members[j] = this.members[i];}
			j++;
			if(members.length == j) {
				break;
		
			}
							
		
		}
		return members;
	}
	
	public String countAll() {
		return "총 회원 수 : " + count;
	}
}	
	


		
		
	

	


