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
public class LoginController {
	
	@Autowired
	CustomerDaoImpl customerDao;
	
	 
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(Model model,HttpServletRequest request,HttpSession session) {
	   
	    String username=request.getParameter("username");
	    String password=request.getParameter("password");
	    String type=request.getParameter("type");
		String forwardingPage="";
		if(username!=null&&password!=null&&type!=null&&username.trim().length()!=0&&password.trim().length()!=0){
			 if(type.equals("admin")){
				 if(username.equals("admin1")&&password.equals("123")){
					 
					  session.setAttribute("type",type);
					  session.setAttribute("username",username);
					  session.setAttribute("password",password);
					  model.addAttribute("message","WELCOME "+username+" !");
					  forwardingPage="task";
					  
				 }
				 else{
					 
					  model.addAttribute("error","Invalid Username or Password!");
					  forwardingPage="index";
				 }
						 
				 
				 
			 }
			 else if(type.equals("customer")){
				 
				 List<Customer>customers=(List<Customer>)customerDao.list();
				
				 if(customers!=null&&customers.size()>0){
					 int control=0;
					 for(int i=0;i<customers.size();i++){
						 if(customers.get(i).getUsername().equals(username)&&customers.get(i).getPassword().equals(password)){
							 control=1;
							 break;
							 
						 }
					 }
					 
					 if(control!=0){
						
						  session.setAttribute("type",type);
						  session.setAttribute("username",username);
						  session.setAttribute("password",password);
						  model.addAttribute("message","WELCOME "+username+" !");
						  forwardingPage="task";
						 
					 }
					 else {
						
						  model.addAttribute("error","Invalid Username or Password!");
						  forwardingPage="index";
						 
					 }
					 
					 
				 }
				 else{
					 model.addAttribute("error","Invalid Username or Password!");
					 forwardingPage="index";
					 
				 }
				
			 }
			
			
		}
		else{
			
			
			model.addAttribute("error","Fill all the blanks!");
			forwardingPage= "index";
		
		}
		return forwardingPage;
	}
	

}
