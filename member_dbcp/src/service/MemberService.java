package service;

import domain.MemberVO;

public interface MemberService {

	//crud
	
	public MemberVO login(String userid, String password);
	public boolean registerMember(MemberVO member);
	public boolean updateMember(String userid, String password);
	public boolean leaveMember(String userid, String password);
}
