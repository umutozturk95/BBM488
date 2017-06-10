package bean;

public class Person {
	 private String name;
	 private String surname;
	 private String phoneNumber;
	 private String address;
	 private String age;
	 
	 
	 public Person(String name,String surname,String phoneNumber,String address,String age){
		 this.name=name;
		 this.surname=surname;
		 this.phoneNumber=phoneNumber;
		 this.address=address;
		 this.age=age;
		 
	 }
	 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	}
