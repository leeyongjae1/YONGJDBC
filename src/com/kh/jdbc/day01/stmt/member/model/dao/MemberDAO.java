package com.kh.jdbc.day01.stmt.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.stmt.member.model.vo.Member;

public class MemberDAO {
	// JDBC를 이용하여
	// Oracle DB에 접속하는 클래스
	// JDBC 코딩이 있어야 함
	
	
//	Class 안에 있 는거 이렇게 선언해서 바꾸면 편함 	
//	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
//	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	private final String USERNAME = "YONGJDBC";
//	private final String PASSWORD = "YONGJDBC";
	
	public Member selectOne(String memberId) {
		Member member = null;
		/*
		 * 1. 드라이버 등록
		 * 2. DBMS 연결 생성
		 * 3. Statement 생성
		 * 4. 쿼리문 전송
		 * 5. 결과값 받기
		 * 6. 자원해제
		 */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn 
			= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","YONGJDBC", "YONGJDBC");
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = '" + memberId + "";
			ResultSet rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				String MemberPw = rset.getString("MEMBER_PW");
				String MemberName = rset.getString("MEMBER_NAME");
				member.setGender(rset.getString("GENDER"));
				member.setAge(rset.getInt("AGE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setHobby(rset.getString("HOBBY"));
				member.setRegDate(rset.getDate("REG_DATE"));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;	
	}
		// 1. 왜 mList에 member가 들어감? member 리스트니까
		// 2. rset은 왜 mList에 못들어감?
		// 3. rset을 member로 어떻게 바꿈?
		//  바꾸는 법 Member 클래스에는 필드와 게터/세터가 필요
		//  ResultSet의 getString, getInt(), getDate() 필요
	public List<Member> selectList() {
		List<Member> mList = new ArrayList<Member>();
		try {
			// 1,
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2,
			Connection conn 
				= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","YONGJDBC", "YONGJDBC");
			// 3
			Statement stmt = conn.createStatement();
			// 4, 5
			String query = "SELECT * FROM MEMBER_TBL";
			ResultSet rset = stmt.executeQuery(query);
			// 후처리
			while(rset.next()) {
				Member member = new Member();
				member.setMemberId(rset.getString("MEMBER_ID"));
				member.setMemberPw(rset.getString("MEMBER_PW"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setGender(rset.getString("GENDER"));
				member.setAge(rset.getInt("AGE"));
				member.setEmail(rset.getString("EMAIL"));
				member.setPhone(rset.getString("PHONE"));
				member.setAddress(rset.getString("ADDRESS"));
				member.setHobby(rset.getString("HOBBY"));
				member.setRegDate(rset.getDate("REG_DATE"));	
				mList.add(member);
//						rset.getString("MEMBER_NAME")
//						, rset.getString("MEMBER_ID")
//						, rset.getString("EMAIL")
//						, rset.getInt("AGE")
//						, rset.getDate("REG_DATE"));
				System.out.println("이름 : " + rset.getString("MEMBER_NAME"));
				System.out.println("아이디 : " + rset.getString("MEMBER_ID"));
				System.out.println("이메일 : " + rset.getString("EMAIL"));
				System.out.println("나이 : " + rset.getInt("AGE"));
				System.out.println("등록일 : " + rset.getDate("REG_DATE"));
			}
			//6.
			rset.close();
			stmt.close();
			conn.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}
	
	public void insertMember(Member member) {
		/* 
		 * 1. 드라이버 등록
		 * 2. DBMS 연결 생성
		 * 3. statement 생성
		 * 4. 쿼리문 전송
		 * 5. 결과값 받기
		 * 6. 자원해제
		 * 
		 */
		try {
			// 1. 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.
			Connection conn 
				= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "YONGJDBC", "YONGJDBC");
			// 3. 
			Statement stmt = conn.createStatement();
			// 4. // 5.
			String query =  
					"INSERT INTO MEMBER_TBL VALUES('"
					+ member.getMemberId() + "', '" 
					+ member.getMemberPw() + "', '"
					+ member.getMemberName() + "', '"
					+ member.getGender() + "','"
					+ member.getAge() + "', '" 
					+ member.getEmail() + "', '"
					+ member.getPhone() + "', '"
					+ member.getAddress() + "', '"
					+ member.getHobby() + "',DEFALULT)";
//			ResultSet rset = stmt.execute(query);  // SELECT 할때만 ResultSet 은 Select의 결과
			int result = stmt.executeUpdate(query); //DML의 경우 호출 하는 메소드 INSERT
			// 후처리
			if(result >0 ) {
				// 성공 메세지 출력
				// commit;
				System.out.println("성공");
			}else {
				// 실패 메세지 출력
				// rollback;
				System.out.println("실패");
			}
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
