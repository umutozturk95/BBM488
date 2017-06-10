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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;  

import com.model.*;
import com.dao.*;

@Controller
public class CustomerController {

	
@Autowired 
private CustomerDaoImpl customerDao;

@Autowired 
private OrderDaoImpl orderDao;

@RequestMapping(value = "/showAddCustomerForm", method = RequestMethod.GET)
public String  showAddCustomerForm(Model model){
	return "addCustomer";
	
}
@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
public String addCustomer(Model model, @ModelAttribute("customer") Customer customer,HttpServletRequest request) {
    String forwardingPage="";
	if(customer!=null){
		
		String userName=customer.getUsername();
		String password=customer.getPassword();
		String name=customer.getName();
		String surname=customer.getSurname();
		String floor=customer.getFloor();
		String building=customer.getBuilding();
		String roomNumber=customer.getRoomNumber();
		if(userName!=null&&userName.trim().length()>0&&password!=null&&password.trim().length()>0&&name!=null&&name.trim().length()>0&&surname!=null&&surname.trim().length()>0&&floor!=null&&floor.trim().length()>0&&building!=null&&building.trim().length()>0&&roomNumber!=null&&roomNumber.trim().length()>0){
			
			int control=0;
			List<Customer>customers=(List<Customer>)customerDao.list();
			for(int a=0;a<customers.size();a++){
				if(customers.get(a).getUsername().equals(userName)){
					control=1;
					break;
				}
				
			}
			if(control==0){
				customerDao.add(customer);
				forwardingPage="redirect:/listCustomer";
			}
			else{
				 forwardingPage="addCustomer";
				 model.addAttribute("error","The same userName is not added!");
				
			}
		
			
					
		}
		else{
		 forwardingPage="addCustomer";
		 model.addAttribute("error","Fill all the blanks!");
			
		}
		return forwardingPage;
	}
	
	else{
		 forwardingPage="addCustomer";
		 model.addAttribute("error","Invalid add operation!");
		 return forwardingPage;
	}
	
	
}
 


@RequestMapping(value="/deleteCustomer",method = RequestMethod.GET)  
public String delete(Model model,@RequestParam("index") int index,@RequestParam("username")String username){  
    //dao.delete(id);
	
    customerDao.delete(index);
    orderDao.deleteDueToCustomer(username);
    return "redirect:/listCustomer";
}  


	
@RequestMapping(value="/listCustomer")  
public String listCustomer(Model model){  
	List<Customer> customers=(List<Customer>)customerDao.list();
	model.addAttribute("customerList",customers);
    return "listCustomer";
}  
@RequestMapping(value = "/showEditCustomerForm/{index}", method = RequestMethod.GET)
public String  showEditCustomerForm(Model model,@PathVariable int index,HttpSession session){
	model.addAttribute("customer",customerDao.getCustomer(index));
	//model.addAttribute("index",index);
	session.setAttribute("editCustomerIndex",index);
	return "editCustomer";
	
}
@RequestMapping(value = "/viewMyProfile", method = RequestMethod.GET)
public String  editMyProfile(Model model,HttpSession session){
	Customer customer=null;
	List<Customer> customers=(List<Customer>)customerDao.list();
	int index=-1;	
	
	for(int i=0;i<customers.size();i++){
		
		if(customers.get(i).getUsername().equals((String)session.getAttribute("username"))){
			customer=customers.get(i);
			index=i;
			break;
		}
	}
	
	model.addAttribute("customer",customer);
	
	session.setAttribute("myProfileIndex",index);
	return "viewMyProfile";
	
}
@RequestMapping(value = "/showEditMyProfileForm", method = RequestMethod.GET)
public String  showEditMyProfileForm(Model model,HttpSession session){
	
	model.addAttribute("customer",customerDao.getCustomer((Integer)session.getAttribute("myProfileIndex")));
	//model.addAttribute("index",index);

	return "editMyProfile";
	
}
@RequestMapping(value = "/editMyProfile", method = RequestMethod.POST)
public String editMyProfile(Model model, @ModelAttribute("customer") Customer customer,HttpServletRequest request) {
	  String forwardingPage="";
		if(customer!=null){
			
			
			String password=customer.getPassword();
			String name=customer.getName();
			String surname=customer.getSurname();
			String floor=customer.getFloor();
			String building=customer.getBuilding();
			String roomNumber=customer.getRoomNumber();
			
			int index=(Integer)request.getSession().getAttribute("myProfileIndex");	
			if(password!=null&&password.trim().length()>0&&name!=null&&name.trim().length()>0&&surname!=null&&surname.trim().length()>0&&floor!=null&&floor.trim().length()>0&&building!=null&&building.trim().length()>0 && roomNumber!=null && roomNumber.trim().length()>0){
					
				   forwardingPage="redirect:/viewMyProfile";
				   customerDao.update(customer,index);
				
						
			 }
			 else{
		     
			      forwardingPage="editMyProfile";
			      model.addAttribute("error","Fill all the blanks!");
				
			  }
			
			return forwardingPage;
		}
		
		else{
			 forwardingPage="editMyProfile";
			 model.addAttribute("error","Invalid edit operation!");
			 return forwardingPage;
		}
		
	
	
}

@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
public String editCustomer(Model model, @ModelAttribute("customer") Customer customer,HttpServletRequest request) {
    String forwardingPage="";
	if(customer!=null){
		
		String userName=customer.getUsername();
		String password=customer.getPassword();
		String name=customer.getName();
		String surname=customer.getSurname();
		String floor=customer.getFloor();
		String building=customer.getBuilding();
		String roomNumber=customer.getRoomNumber();
		
		int index=(Integer)request.getSession().getAttribute("editCustomerIndex");	
		if(userName!=null &&userName.trim().length()>0&&password!=null&&password.trim().length()>0&&name!=null&&name.trim().length()>0&&surname!=null&&surname.trim().length()>0&&floor!=null&&floor.trim().length()>0&&building!=null&&building.trim().length()>0 && roomNumber!=null && roomNumber.trim().length()>0){
				
			   forwardingPage="redirect:/listCustomer";
			   customerDao.update(customer,index);
			
					
		 }
		 else{
	     
		      forwardingPage="editCustomer";
		      model.addAttribute("error","Fill all the blanks!");
			
		  }
		
		return forwardingPage;
	}
	
	else{
		 forwardingPage="editCustomer";
		 model.addAttribute("error","Invalid edit operation!");
		 return forwardingPage;
	}
	
	
}
  
	
}
