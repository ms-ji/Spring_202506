/**
 * Package Name : com.pcwk.ehr.user.dao <br/>
 * Class Name: DaoFactory.java <br/>
 */
package com.pcwk.ehr.user.dao;

/**
 * @author user
 *
 */
public class DaoFactory {
	
	public ConnectionMaker connectionMaker() {
		
		return new NConnectionMaker();
	}
	
	/**
	 * UserDao 생성
	 * @return UserDao
	 */
	public UserDao userDao() {
		
		UserDao dao = new UserDao(connectionMaker());
		
		return dao;
	}
}
