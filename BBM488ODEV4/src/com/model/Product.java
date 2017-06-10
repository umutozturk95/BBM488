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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.*;

@Entity
@Table(name ="Product")
@XmlRootElement
@XmlAccessorType( XmlAccessType.FIELD)
public class Product {

	
	@Id
	@GeneratedValue
	@Column(name="product_id")
	private int product_id;
	
	 @Column(name="productName",nullable=false,unique=true)	
	private String productName;
	
	 @Column(name="price",nullable=false)	
	private String price;
	
	@OneToMany(mappedBy ="product",fetch=FetchType.EAGER)
	@XmlTransient
	private Set<Order> orders=new HashSet<Order>();
	
	
	
	public Product(){
		
	}
	

	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public Product(String productName,String price){
		this.price=price;
		this.productName=productName;
		
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
 
}
