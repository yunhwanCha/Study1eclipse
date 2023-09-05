package model;

//Data Transfer Object(DTO)
//DTO 작성시 규칙: 모든 변수는 은닉(private)한다. 
//은닉된 변수에 데이터를 넣는 메서드(공개)를 만든다. --세터 메서드(Setter Method)
//세터 메서드의 이름 규칙: set으로 시작한다. 변수이름의 첫글자를 대문자로 나머지는 그대로
//은닉된 변수의 데이터를 가져가는 메서드(공개)를 만든다. --게터 메서드(Getter Method)
//게터 메서드의 이름 규칙: get으로 시작한다. 변수이름의 첫글자를 대문자로 나머지는 그대로
public class Customer {
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public String getGender() {
		return gender;
	}
	public String getEmail() {
		return email;
	}
	public String getJob() {
		return job;
	}
	public String getPhone() {
		return phone;
	}
	public String getReg_date() {
		return reg_date;
	}
	private String id;
	private String pwd;
	private String name;
	private String addr;
	private String gender;
	private String email;
	private String job;
	private String phone;
	public void setPhone(String phone) {
		this.phone = phone;
	}
	private String reg_date;
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
}
