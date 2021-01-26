package service;

import domain.MemberVO;
import persistence.MemberDAO;

import static persistence.JDBCUtil.*;

import java.sql.Connection;

public class MemberServiceImpl implements MemberService {

	private Connection con;
	private MemberDAO dao;

	public MemberServiceImpl() {
		con = getConnection();
		dao = new MemberDAO(con);

	}

	@Override
	public MemberVO login(String userid, String password) {

		MemberVO member = dao.isLogin(userid, password);

		close(con);

		return member;
	}

	@Override
	public boolean registerMember(MemberVO member) {
		
		boolean insertFlag = false;
		int result = dao.register(member);
		if(result>0) {
			commit(con);
			insertFlag=true;
		}else {
			rollback(con);
		}
		close(con);

		return insertFlag;
	}
	
	
	@Override
	public boolean updateMember(String userid, String password) {
		
		boolean updateFlag = false;
		int result = dao.updateMember(userid, password);
		if(result>0) {
			commit(con);
			updateFlag=true;
		}else {
			rollback(con);
		}
		close(con);

		return updateFlag;
	}

	@Override
	public boolean leaveMember(String userid, String password) {
		
		int result = dao.leaveMember(userid, password);
		
		boolean leaveFlag = false;
		if(result>0) {
			commit(con);
			leaveFlag = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return leaveFlag;
	}

}
