package com.rest;
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
@RestController
public class CustomerRest {

	
@Autowired 
private CustomerDaoImpl customerDao;



@RequestMapping(value = "/addCustomer", method = RequestMethod.POST,headers = "Accept=application/json")
public void addCustomer(@RequestBody Customer customer,HttpServletRequest request) {
  
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
				
				
			}
						
		}
	
	}

}
 
@RequestMapping(value="/deleteCustomer",method = RequestMethod.DELETE)  
public void delete(@RequestParam("id") int id){  
	System.out.println("--->id "+id);
    customerDao.delete(id);
}  


@RequestMapping(value = "/editMyProfile", method = RequestMethod.POST)
public void editMyProfile(@RequestBody Customer customer,HttpServletRequest request) {
	  
		if(customer!=null){
			
			
			String password=customer.getPassword();
			String name=customer.getName();
			String surname=customer.getSurname();
			String floor=customer.getFloor();
			String building=customer.getBuilding();
			String roomNumber=customer.getRoomNumber();
			
			int id=(Integer)request.getSession().getAttribute("myProfileIndex");	
			if(password!=null&&password.trim().length()>0&&name!=null&&name.trim().length()>0&&surname!=null&&surname.trim().length()>0&&floor!=null&&floor.trim().length()>0&&building!=null&&building.trim().length()>0 && roomNumber!=null && roomNumber.trim().length()>0){
				  
				   customer.setCustomer_id(id);			
				   customerDao.update(customer,id);
				
						
			 }
			
		}
	
}

@RequestMapping(value = "/editCustomer", method = RequestMethod.POST)
public void editCustomer(@RequestBody Customer customer,HttpServletRequest request) {
   
	if(customer!=null){
		
		String userName=customer.getUsername();
		String password=customer.getPassword();
		String name=customer.getName();
		String surname=customer.getSurname();
		String floor=customer.getFloor();
		String building=customer.getBuilding();
		String roomNumber=customer.getRoomNumber();
		
		int id=(Integer)request.getSession().getAttribute("editCustomerIndex");	
		if(userName!=null &&userName.trim().length()>0&&password!=null&&password.trim().length()>0&&name!=null&&name.trim().length()>0&&surname!=null&&surname.trim().length()>0&&floor!=null&&floor.trim().length()>0&&building!=null&&building.trim().length()>0 && roomNumber!=null && roomNumber.trim().length()>0){
				customer.setCustomer_id(id);			 
			    customerDao.update(customer,id);
			
					
		 }
		
	}
 }
 	
}
