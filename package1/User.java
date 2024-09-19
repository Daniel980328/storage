package package1;

public class User {
	private String name;
	private String id;
	private String pw;
	private String phone;
	private String address;
	boolean login_state = false;
	
	public User() {
		
	}
	
	public User(String pname, String pphone, String paddress, String pid, String ppw) {
		this.name=pname;
		this.phone=pphone;
		this.address=paddress;
		this.id=pid;
		this.pw=ppw;
				
	}
	
	public void login() {
		this.login_state = true;
	}

	public void logout() {
		this.login_state = false;
	}
	public boolean isLogin() {
		return this.login_state;
	}

	public String getName() {
		return this.name;
	}

	public String getPhone() {
		return this.phone;
	}
	public String getAddress() {
		return this.address;
	}

	public String getId() {
		return this.id;
	}

	public String getPw() {
		return this.pw;
	}
	public void setName(String pname) {
		this.name = pname;
	}

	public void setPhone(String pphone) {
		this.phone = pphone;
	}

	public void setAddress(String paddress) {
		this.address = paddress;
	}
	public void setPw(String ppw) {
		this.pw = ppw;
	}
	public void setId(String pid) {
		this.id = pid;
	}
}
