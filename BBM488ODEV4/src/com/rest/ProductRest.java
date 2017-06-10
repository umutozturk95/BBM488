package com.rest;


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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;  

import com.model.*;
import com.dao.*;
@RestController
public class ProductRest {
   
	
@Autowired 
private ProductDaoImpl productDao;


@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
public void addCustomer( @RequestBody Product product,HttpServletRequest request) {
   
	if(product!=null){
		
		String productName =product.getProductName();
		String price=product.getPrice();
		
		if(productName!=null&&productName.trim().length()>0&&price!=null&&price.trim().length()>0){
			List<Product> products=(List<Product>)productDao.list();
			int control=0;
			for(int a=0;a<products.size();a++){
				if(products.get(a).getProductName().equals(productName)){
					control=1;
					break;
				}
				
			}
			if(control==0){
				
				productDao.add(product);
				
			}
					
		}
	}

}

@RequestMapping(value="/deleteProduct",method = RequestMethod.DELETE)  
public void delete(@RequestParam("id") int id){  
    productDao.delete(id);
  
}  

@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
public void editCustomer( @RequestBody Product product,HttpServletRequest request) {
  
	if(product!=null){
		
		String productName=product.getProductName();
		String price=product.getPrice();
		
		
		int id=(Integer)request.getSession().getAttribute("editProductIndex");
		
		if(productName!=null&&productName.trim().length()>0&&price!=null&&price.trim().length()>0){
			product.setProduct_id(id);
			
			productDao.update(product,id);
			
					
		}
		
	}
	
}

}
