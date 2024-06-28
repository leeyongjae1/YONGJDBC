package com.kh.jdbc.day02.stmt.member.controller;

import java.util.List;

import com.kh.jdbc.day02.stmt.member.model.dao.MemberDAO;
import com.kh.jdbc.day02.stmt.member.model.vo.Member;

public class MemberController {
	
	MemberDAO mDao; 
	
	public MemberController() {
		mDao = new MemberDAO();
	}

	public void insertMember(Member member) {
		mDao.insertMember(member);
	}

	public int modifyMember(Member modifyInfo) {
		// DML의 결과는 int니까 int result
		// modifyInfo 전달해야 되니까 updateMember(modifyInfo)
		int result = mDao.updateMember(modifyInfo);
		return result;
	}

	// View에서 memberId값 받아야 하니까 removeMember(String memberId)
	// return 하는 값의 자료형이 int니까 void 대신 int
	public int removeMember(String memberId) {
		// dml의 결과는 int니까 int result
		// memberId 전달해야 도니까 deleteMember(membberId)
		int result = mDao.deleteMember(memberId);
		// 호출한 곳에서  써야 되니까 return   MemberVIew: 55번쨰 줄 
		return result;
	}
	public List<Member> printALLMember() {
		// 여러개니까 List 멤버니까 List<Member>
		List<Member> mList = mDao.selectList();
		// 호출한 곳에서  써야 되니까 return   MemberVIew: 34번쨰 줄
		return mList;
	}

	// View가 준 것 받아야 되니까 pritOneMember(String memberId)
	public Member printOneMember(String memberId) {
		// 한개니까 List없어도 됨, Member
		// DAO로 전달해야되니까 selectONe(memberId)
		Member member = mDao.selectOne(memberId);
		// 호출한 곳에서 써야되니까 return member , MemberView 44번째줄
		return member;
	}


}
