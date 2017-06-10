package com.controller;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;  

import com.model.*;
import com.dao.*;

import org.springframework.web.bind.annotation.RestController;
@Controller
public class CustomerController {

	
@Autowired 
private CustomerDaoImpl customerDao;


@RequestMapping(value = "/showAddCustomerForm", method = RequestMethod.GET)
public String  showAddCustomerForm(Model model){
	return "addCustomer";
	
}

@RequestMapping(value="/listCustomer")  
public String listCustomer(Model model){  
	List<Customer> customers=(List<Customer>)customerDao.list();
	model.addAttribute("customerList",customers);
    return "listCustomer";
}  

@RequestMapping(value = "/showEditCustomerForm/{id}", method = RequestMethod.GET)
public String  showEditCustomerForm(Model model,@PathVariable int id,HttpSession session){
	model.addAttribute("customer",customerDao.getCustomer(id));
	session.setAttribute("editCustomerIndex",id);
	return "editCustomer";
	
}
@RequestMapping(value = "/viewMyProfile", method = RequestMethod.GET)
public String  editMyProfile(Model model,HttpSession session){
	Customer customer=null;
	List<Customer> customers=(List<Customer>)customerDao.list();
	int id=-1;	
	
	for(int i=0;i<customers.size();i++){
		
		if(customers.get(i).getUsername().equals((String)session.getAttribute("username"))){
			customer=customers.get(i);
			id=customer.getCustomer_id();
			break;
		}
	}
	if(id==-1){
		
		return null;
	}
	model.addAttribute("customer",customer);
	
	session.setAttribute("myProfileIndex",id);
	return "viewMyProfile";
	
}
@RequestMapping(value = "/showEditMyProfileForm", method = RequestMethod.GET)
public String  showEditMyProfileForm(Model model,HttpSession session){
	
	model.addAttribute("customer",customerDao.getCustomer((Integer)session.getAttribute("myProfileIndex")));
	//model.addAttribute("index",index);

	return "editMyProfile";
	
}


}
