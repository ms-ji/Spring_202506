/**
 * 
 */
package com.pcwk.ehr.user;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.pcwk.ehr.user.dao.UserDao;
import com.pcwk.ehr.user.domain.UserDTO;

/**
 * @author user
 *
 */
public class UserMain {
	UserDTO dto01;
	UserDao dao;
	
	
	ApplicationContext context;
	
	public UserMain() {
		String path ="applicationContext.xml";
		context = new GenericXmlApplicationContext(path);
		System.out.println("context: "+context);
		dto01 = new UserDTO("pcwk01", "이상무01", "4321", "사용안함");
		
		//메모리에 생성된 객체를 추출
		dao = context.getBean("userDao", UserDao.class);
		System.out.println("dao: "+dao);
		
		//dao = new DaoFactory().userDao();
	}
	public void getConnection() {
		try {
			dao.doSave(dto01);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void doSelectOne() {
		try {
			UserDTO outDTO = dao.doSelectOne(dto01);
			if(null !=outDTO) {
				System.out.println("--------------------------------------------------");
				System.out.println("doSelectOne 조회성공 : "+outDTO);
				System.out.println("--------------------------------------------------");
			}else {
				System.out.println("doSelectOne 조회실패 : "+outDTO);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doSave() {
		try {
			int flag = dao.doSave(dto01);
			
			if(1==flag) {
				System.out.println("----------");
				System.out.println("doSave성공!");
				System.out.println("----------");
			}else {
				System.out.println("doSave실패!");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteAll() {
		try {
			dao.deleteAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserMain main = new UserMain();
		main.deleteAll(); //전체 삭제
		main.doSave(); //단건 등록
		main.doSelectOne(); //단건 조회
	}

}
