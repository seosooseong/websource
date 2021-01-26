package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {
	//DB와 연동 - CRUD
	//			- C(insert) R(select) U(update) D(delete)
	
	public boolean insertMember(String name);
	
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
}
