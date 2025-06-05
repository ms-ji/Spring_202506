package com.pcwk.ehr.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	
	//DB 연결 정보 생성
	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; //드라이버 명칭
		final String URL = "jdbc:oracle:thin:@192.168.100.165:1521:xe"; //URL
		final String USER_ID = "scott"; //유저 아이디
		final String USER_PASSWORD = "pcwk";//유저 비밀번
		
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(URL, USER_ID, USER_PASSWORD);
		
		System.out.println("1 conn: "+conn);
		
		return conn;
	}

}
