package com.model;
import java.io.Serializable; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.*;


@Entity
@Table(name="Customer")
@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD)
public class Customer   {
	
 @Id
 @GeneratedValue
 @Column(name="customer_id")
private int customer_id; 


 @Column(name="username",nullable=false,unique=true)	
private String username;

 @Column(name="password",nullable=false)	
 private String password;
 
 @Column(name="name",nullable=false)	
 private String name;
 
 @Column(name="surname",nullable=false)	
 private String surname;
 
 @Column(name="floor",nullable=false)	
 private String floor;
 
 @Column(name="building",nullable=false)	
 private String building;
 
 @Column(name="roomNumber",nullable=false)	
 private String roomNumber;
 
 @OneToMany(mappedBy = "customer",fetch=FetchType.EAGER)
 @XmlTransient
private  Set<Order> orders=new HashSet<Order>();;

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
 
 


 public int getCustomer_id() {
		return customer_id;
	}
 public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

public Set<Order> getOrders() {
	return orders;
}
public void setOrders(Set<Order> orders) {
	this.orders = orders;
}

 
}
