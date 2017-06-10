package com.rest;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;  
import java.util.Calendar;
import java.util.Date;
import java.util.List;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;  

import com.model.*;
import com.dao.*;

@RestController
public class OrderRest {
	
 @Autowired 
 private  OrderDaoImpl orderDao;
 
 
 @Autowired 
 private  ProductDaoImpl productDao;
 
 @Autowired 
 private  CustomerDaoImpl customerDao;
 
 
 @RequestMapping(value = "/addOrder/{id}", method = RequestMethod.POST)
 public void addOrder(@RequestBody Order order,@PathVariable int id,HttpServletRequest request) {
     
 	if(order!=null){
 	    List<Customer>customers=(List<Customer>)customerDao.list();
 	    List<Product> products=(List<Product>)productDao.list();
 	    int control=0;
 	   String username=(String)request.getSession().getAttribute("username");
 	    for(int i=0;i<customers.size();i++){
 	    	if(customers.get(i).getUsername().equals(username)){
 	    	     control=1;
 	    		 break;
 	    	}
 	    	
 	    }
 	    
 	    if(control==0){
 	    	
 	    	 return;
 	    }
 	   DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
 	   Date today = Calendar.getInstance().getTime();  
 	   order.setDate(df.format(today));
 	   
 		order.setCustomer(customerDao.getCustomer(username));
 		String numberOfProducts=order.getNumberOfProduct();
 		
 	
 		Product product=productDao.getProduct(id);
 		order.setProduct(product);
 		
 		if(numberOfProducts!=null&&numberOfProducts.trim().length()>0){
 			
 			orderDao.add(order);
 					
 		}	
 	}	
 }

 @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
 public void editOrder(@RequestBody Order order,HttpServletRequest request) {
   
 	if(order!=null){
 		String orderState=order.getOrderState();
 		int id=(Integer)request.getSession().getAttribute("editOrderIndex");
 	
 		if(orderState!=null && orderState.trim().length()>0){
 		 
 			int customerId=Integer.parseInt(request.getParameter("customer_id"));
 	 		int productId=Integer.parseInt(request.getParameter("product_id"));
 	 		
 	 		Customer customer=customerDao.getCustomer(customerId);
 	 		Product product=productDao.getProduct(productId);
 	 		
 	 		order.setCustomer(customer);
 	 		order.setProduct(product);
 			order.setOrder_id(id); 		
 		    orderDao.update(order,id);					
 		 }
 	}
 	
 }
 
}

