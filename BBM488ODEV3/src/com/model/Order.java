package com.model;
import java.io.Serializable; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name ="Orders")
@XmlRootElement
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private int order_id;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id",nullable=false)	
	private Customer customer;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id",nullable=false)	
	private Product product;
	
	 @Column(name="orderState",nullable=false)	
	private String orderState;
	
	@Column(name="numberOfProduct",nullable=false)	
	private String numberOfProduct;
    
	public Order(){
		
		
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
   
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getOrderState() {
		return orderState;
	}


	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}


	public String getNumberOfProduct() {
		return numberOfProduct;
	}


	public void setNumberOfProduct(String numberOfProduct) {
		this.numberOfProduct = numberOfProduct;
	}

	
	
	
	 
}
