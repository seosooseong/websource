package domain;

import lombok.Data;

@Data
//@Data-get, set, equals, deafault constructor, hashCode, toString
public class MemberVO {
//	userid varchar2(15) primary key,password varchar2(20) not null,
//	name nvarchar2(10) not null,gender varchar2(2) not null, email varchar2(50) not null
	
	private String userid;
	private String password;
	private String name;
	private String gender;
	private String email;
}
