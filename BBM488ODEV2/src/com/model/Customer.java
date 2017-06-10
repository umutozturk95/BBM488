package com.model;
import java.io.Serializable; 
public class Customer  implements Serializable {
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
 private String password;
 private String name;
 private String surname;
 private String floor;
 private String building;
 private String roomNumber;
 public Customer(){
	 
	 
 }
 public Customer(String username,String password,String name,String surname,String floor,String building,String roomNumber){
	 this.username=username;
	 this.password=password;
	 this.name=name;
	 this.surname=surname;
	 this.floor=floor;
	 this.building=building;
	 this.roomNumber=roomNumber;
	 
 }

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
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

public String getFloor() {
	return floor;
}

public void setFloor(String floor) {
	this.floor = floor;
}

public String getBuilding() {
	return building;
}

public void setBuilding(String building) {
	this.building = building;
}

public String getRoomNumber() {
	return roomNumber;
}

public void setRoomNumber(String roomNumber) {
	this.roomNumber = roomNumber;
}
 
 
}
