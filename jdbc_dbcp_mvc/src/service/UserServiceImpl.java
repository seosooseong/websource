package service;

import java.sql.Connection;
import java.util.List;

import domain.UserVO;
import persistence.UserDAO;
import static persistence.JDBCUtil.*;
public class UserServiceImpl implements UserService {
	
	//커넥션
	Connection con;
	UserDAO dao ;
	
	public UserServiceImpl() {
		con=getConnection();
		dao = new UserDAO(con);
		
	}
	
	@Override
	public boolean insertUser(String username, String birthyear, String addr, String mobile) {
		//UserDAO 객체 생성 - DB 작업 시키기
		int result = dao.insert(username, birthyear, addr, mobile); //db작업위해 변수명을 
		
		//DB작업 결과 -> action에게 보내기 commit rollback
		boolean insertFlag = false;
		if(result>0) {
			insertFlag = true;
			commit(con);
			
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateUser(int no, String addr, String mobile) {
		
		boolean updateFlag = false;
		
		int result = dao.updateUser(no, addr, mobile);
		
		if(result>0) {
			commit(con);
			updateFlag=true;
		}else {
			rollback(con);
		}close(con);
		
		return updateFlag;
	}

	@Override
	public boolean deleteUser(int no) {
		boolean deleteFlag = false;
		int result = dao.deleteUser(no);
		if(result>0) {
			commit(con);
			deleteFlag=true;
		}else {
			rollback(con);
		}close(con);
		return deleteFlag;
	}

	@Override
	public UserVO getUser(int no) {
		UserVO user = dao.getUser(no);
		close(con);
		return user;
	}

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> list = dao.select();
		close(con);
		return list;
	}

}
