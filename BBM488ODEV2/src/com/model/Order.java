package com.model;
import java.io.Serializable; 
public class Order implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String productname;
	private String orderState;
	private String numberOfProduct;
    public Order(){
		
		
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
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
