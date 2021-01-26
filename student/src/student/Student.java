package student;

public class Student {
	private int code;
	private String name;
	private int grade;
	private String addr;
	private String birth;
	
	public Student(int code, String name, String grade, String addr, String birth) {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Student(int code, String name, int grade, String addr, String birth) {
		super();
		this.code = code;
		this.name = name;
		this.grade = grade;
		this.addr = addr;
		this.birth = birth;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	

	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", grade=" + grade + ", addr=" + addr + ", birth=" + birth
				+ "]";
	}
	
	
}
