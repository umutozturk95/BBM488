package com.controller;

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
 
 
 
}
