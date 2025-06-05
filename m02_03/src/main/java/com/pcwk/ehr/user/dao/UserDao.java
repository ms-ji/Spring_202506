package com.pcwk.ehr.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pcwk.ehr.user.domain.UserDTO;

public class UserDao {
	
	SimpleConnectionMaker simpleConnectionMaker; //멤버 변수
	
	public UserDao() {
		simpleConnectionMaker = new SimpleConnectionMaker();		
	}
	
	
	
	/**
	 * 데이터 한 건 조회
	 * @param dto
	 * @return 1(성공)/0(실패)
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public UserDTO doSelectOne(UserDTO dto) throws ClassNotFoundException, SQLException {
		
		//1. 
		Connection conn=null;
		PreparedStatement prepare = null;
		StringBuilder sb = new StringBuilder(200);
		UserDTO outVO = null;
		ResultSet rs = null;
		
		//2.
		conn = simpleConnectionMaker.makeNewConnection();
		
		sb.append("SELECT              \n");
		sb.append("    user_id,        \n");
		sb.append("    name,           \n");
		sb.append("    password,       \n");
		sb.append(" TO_CHAR(reg_dt,'YYYY-MM-DD')AS reg_dt_str  \n");
		sb.append("FROM member         \n");
		sb.append("WHERE user_id = ?   \n");
		
		System.out.println("2 sql: \n"+sb.toString());
		prepare = conn.prepareStatement(sb.toString());
		System.out.println("3 prepare: "+prepare);
		System.out.println("3.1 param: "+dto);
		
		//3.param
		prepare.setString(1, dto.getUserId());
		
		rs = prepare.executeQuery();
		System.out.println("4 ResultSet: "+rs);
		
		if(rs.next()) {
			outVO = new UserDTO();
			
			outVO.setUserId(rs.getString("user_id")); //데이터베이스에서의 이름
			outVO.setName(rs.getString("name")); 
			outVO.setPassword(rs.getString("password")); 
			outVO.setRegDt(rs.getString("reg_dt_str")); 
			
			System.out.println("5 outVo: "+outVO);
		}
		if(null !=rs) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(null !=prepare) {
			try {
				prepare.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(null !=conn) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return outVO;
	}
	/**
	 * 단건 등록
	 * @param param
	 * @return 1(성공)/0(실패)
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public int doSave(UserDTO param) throws ClassNotFoundException, SQLException {
		int flag = 0;
		//1.
		StringBuilder sb = new StringBuilder(200);
		Connection conn=null;
		PreparedStatement prepare=null;

		//2.db연결
		conn = this.simpleConnectionMaker.makeNewConnection();
		
		sb.append("INSERT INTO member (   \n");
		sb.append("    user_id,           \n");
		sb.append("    name,              \n");
		sb.append("    password,          \n");
		sb.append("    reg_dt             \n");
		sb.append(") VALUES ( ?,          \n");
		sb.append("           ?,          \n");
		sb.append("           ?,          \n");
		sb.append("           SYSDATE )   \n");
		
		System.out.println("2 sql: \n"+sb.toString());
		prepare = conn.prepareStatement(sb.toString());
		System.out.println("3 prepare: "+prepare);
		System.out.println("3.1 param: "+param);
		
		//3.param 값 설정
		prepare.setString(1, param.getUserId());
		prepare.setString(2, param.getName());
		prepare.setString(3, param.getPassword());

		flag = prepare.executeUpdate(); //sql 실행
		System.out.println("4 flag: "+flag);
		
		//4. 자원반납(리소스 닫기, 역순)
		if(null != prepare) {
			try {
				prepare.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(null != conn) {
			try {
				conn.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
}
