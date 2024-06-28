package com.kh.jdbc.day01.stmt.member.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.day01.stmt.member.controller.MemberController;
import com.kh.jdbc.day01.stmt.member.model.vo.Member;

public class MemberView {

	MemberController mController;

	public MemberView() {
		mController = new MemberController();
	}

	public void StartProgram() {
//		List<Member> mList = mController.listMember();
//		this.displayMemberList(mList);
		int choice = 0;
		끝 :
		while (true) {
			choice = this.printMainMenu();
			switch (choice) {
			case 0:
				break 끝;
			case 1:
				Member member = this.inputMember();
				mController.insertMember(member);
				break;
			case 2:
				List<Member> mList = mController.listMember();
				this.displayMemberList(mList);
				break;
			case 3:
				String memberId = this.inputMemberId();
				member = mController.printOneMember(memberId);
				this.displayOne(member);
				break;
			default : this.displayMessage("메뉴를 다시 선택해주세요.");
			}
		}
	}

	private String inputMemberId() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력 하세요 ");
		String memberId = sc.next();
		return memberId;
	}

	private void displayOne(Member member) {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력 하세요 ");
		System.out.printf("이름 : %s, 나이 : %d" 
		+", 아이디 : %s, 성별 : %s, 이메일 : %s"
		+", 전화번호 : %s, 주소 : %s, 취미 : %s"
		+", 가입날짜 : %s\n"
		,member.getMemberName()
		,member.getAge()
		,member.getMemberId()
		,member.getGender()
		,member.getEmail()
		,member.getPhone()
		,member.getAddress()
		,member.getHobby()
		,member.getRegDate());
		
		
		
		
		String memberId = sc.next();
		
//		for (Member member : mList) {
//		}
		
		
	}

	private Member inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원 정보 전체 출력 =====");
		System.out.println("아이디 :" );
		String memberId = sc.next();
		System.out.println("비밀번호 :" );
		String memberPw = sc.next();
		System.out.println("이름 :" );
		String memberName = sc.next();
		System.out.println("성별 :" );
		String Gender = sc.next();
		System.out.println("나이 :" );
		int Age = sc.nextInt();
		System.out.println("이메일 :" );
		String Email = sc.next();
		System.out.println("전화번호 :" );
		String Phone = sc.next();
		System.out.println("주소 :" );
		sc.nextLine();
		String Address = sc.nextLine();
		System.out.println("취미 :" );
		String Hobby = sc.nextLine();
		Member member = new Member();
		
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setGender(Gender);
		member.setAge(Age);
		member.setEmail(Email);
		member.setPhone(Phone);
		member.setAddress(Address);
		member.setHobby(Hobby);
		
		return member;
	}

	private void displayMessage(String msg) {
		System.out.println(msg);
	}

	private int printMainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===== 회원 정보 전체 출력 =====");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 검색(아이디로 조회)");
		System.out.println("0. 프로그램 종료");
		System.out.println("메뉴 선택 : ");
		int value = sc.nextInt();
		return value;
	}

	public void displayMemberList(List<Member> mList) {
		System.out.println("===== 회원 정보 전체 출력 =====");
		for (Member member : mList) {
			System.out.printf("이름 : %s", member.getMemberName());
		}
	}
}
