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
 	    for(int i=0;i<customers.size();i++){
 	    	if(customers.get(i).getUsername().equals((String)request.getSession().getAttribute("username"))){
 	    	     control=1;
 	    		 break;
 	    	}
 	    	
 	    }
 	    
 	    if(control==0){
 	    	 model.addAttribute("error","The user is not part of system!");    	 
 	   	     model.addAttribute("products",products);
 	    	 return "addOrder";
 	    }
 		order.setUsername((String)request.getSession().getAttribute("username"));
 		String numberOfProducts=order.getNumberOfProduct();
 		String productname=order.getProductname();
 		
 		if(numberOfProducts!=null&&numberOfProducts.trim().length()>0&&productname!=null&&productname.trim().length()>0){
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
 	List<Order> orders=(List<Order>)orderDao.list((String)session.getAttribute("username"));
 	model.addAttribute("orderMyList",orders);
     return "listMyOrder";
 }
 
 @RequestMapping(value="/listOrder")  
 public String listOrder(Model model){  
 	List<Order> orders=(List<Order>)orderDao.list();
 	List<Customer> customers=(List<Customer>)customerDao.list();
 	model.addAttribute("orderList",orders);
 	model.addAttribute("customerList",customers);
     return "listOrder";
 }  
  
 @RequestMapping(value = "/showEditOrderForm/{index}", method = RequestMethod.GET)
 public String  showEditOrderForm(Model model,@PathVariable int index,HttpSession session){
 	model.addAttribute("order",orderDao.getOrder(index));
 	//model.addAttribute("index",index);
 	session.setAttribute("editOrderIndex",index);
 	return "editOrder";
 	
 
 }
 
 @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
 public String editOrder(Model model, @ModelAttribute("order") Order order,HttpServletRequest request) {
     String forwardingPage="";
 	if(order!=null){
 		
 		String orderState=order.getOrderState();
 		int index=(Integer)request.getSession().getAttribute("editOrderIndex");	
 		if(orderState!=null && orderState.trim().length()>0){
 				
 			   forwardingPage="redirect:/listOrder";
 			   orderDao.update(order,index);
 			
 					
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
