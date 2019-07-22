package model;

public class Member {
	private int origin_no;
	private String name;
	private int age;
	private String phone;
	private String address;
	
	public void initMember(int pNo, String pName, int pAge, String pPhone, String pAddress) {
		this.origin_no = pNo;
		this.name = pName;
		this.age = pAge;
		this.phone = pPhone;
		this.address = pAddress;
	}

	public void PrintInfo() {
		System.out.println(" | Name: " + this.name + " | Age: " + this.age + " | Phone: " + this.phone + " | Address: " + this.address);
	}
	
	
	//////////////////////// Getter, Setter /////////
	// Name
	public String getName() {
		return this.name;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	// Age
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int pAge) {
		this.age = pAge;
	}
	
	// Phone
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String pPhone) {
		this.phone = pPhone;
	}
	
	// Address
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String pAddress) {
		this.address = pAddress;
	}
	/////////////////////////////////////////////////
	
}
