package com.controller;

import java.util.ArrayList;  
import java.util.List;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  

import com.model.*;
import com.dao.*;

@Controller
public class OrderController {
	
 @Autowired 
 private  OrderDaoImpl orderDao;
 
 
 @Autowired 
 private  ProductDaoImpl productDao;
 
 @Autowired 
 private  CustomerDaoImpl customerDao;
 
 @RequestMapping(value = "/showAddOrderForm", method = RequestMethod.GET)
 public String  showAddCustomerForm(Model model){
	 List<Product> products=(List<Product>)productDao.list();
	 model.addAttribute("products",products);
 	return "addOrder";
 	
 }
 
 @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
 public String addOrder(Model model, @ModelAttribute("order") Order order,HttpServletRequest request) {
     String forwardingPage="";
     
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
 	    	 model.addAttribute("error","The user is not part of system!");    	 
 	   	     model.addAttribute("products",products);
 	    	 return "addOrder";
 	    }
 	   
 		order.setCustomer(customerDao.getCustomer(username));
 		String numberOfProducts=order.getNumberOfProduct();
 		
 		
 		int product_id=Integer.parseInt(request.getParameter("product_id"));
 		Product product=productDao.getProduct(product_id);
 		order.setProduct(product);
 		
 		if(numberOfProducts!=null&&numberOfProducts.trim().length()>0){
 			forwardingPage="redirect:/listMyOrder";
 			orderDao.add(order);
 					
 		}
 		else{
 		 forwardingPage="addOrder";
 		 model.addAttribute("error","Fill all the blanks!");
 		 model.addAttribute("products",products);
 			
 		}
 		return forwardingPage;
 	}
 	
 	else{
 		 forwardingPage="addOrder";
 		 model.addAttribute("error","Invalid add operation!");
 		 return forwardingPage;
 	}
 	
 	
 }
 @RequestMapping(value="/listMyOrder")  
 public String listMyOrder(Model model,HttpSession session){ 
	 String username=(String)session.getAttribute("username");
	 Customer customer=customerDao.getCustomer(username);
	 if(customer==null){
		 return null;
	 }
 	 List<Order> orders=(List<Order>)orderDao.list(customer.getCustomer_id());
 	 model.addAttribute("orderMyList",orders);
     return "listMyOrder";
 }
 
 @RequestMapping(value="/listOrder")  
 public String listOrder(Model model){  
 	List<Order> orders=(List<Order>)orderDao.list();
 	model.addAttribute("orderList",orders);
 	
     return "listOrder";
 }  
  
 @RequestMapping(value = "/showEditOrderForm/{id}", method = RequestMethod.GET)
 public String  showEditOrderForm(Model model,@PathVariable int id,HttpSession session){
 	model.addAttribute("order",orderDao.getOrder(id));
 	//model.addAttribute("index",index);
 	session.setAttribute("editOrderIndex",id);
 	return "editOrder";
 	
 
 }
 
 @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
 public String editOrder(Model model, @ModelAttribute("order") Order order,HttpServletRequest request) {
     String forwardingPage="";
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
 			forwardingPage="redirect:/listOrder";
 		    orderDao.update(order,id);
 			
 					
 		 }
 		 else{
 	     
 		      forwardingPage="editOrder";
 		      model.addAttribute("error","Fill all the blanks!");
 			
 		  }
 		
 		return forwardingPage;
 	}
 	
 	else{
 		 forwardingPage="editOrder";
 		 model.addAttribute("error","Invalid edit operation!");
 		 return forwardingPage;
 	}
 	
 	
 }
 
}
