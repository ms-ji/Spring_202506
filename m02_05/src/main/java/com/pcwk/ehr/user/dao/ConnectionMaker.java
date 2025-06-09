package com.pcwk.ehr.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

	//클래스 분리하여 Dao개선
	//makeNewConnection():Connection
	/**
	 * DB연결
	 * @return Connection
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	Connection makeConnection() throws ClassNotFoundException, SQLException; //public abstract 생략 가능

}