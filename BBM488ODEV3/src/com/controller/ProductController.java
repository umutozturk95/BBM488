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
public class ProductController {
   
	
@Autowired 
private ProductDaoImpl productDao;



@RequestMapping(value = "/showAddProductForm", method = RequestMethod.GET)
public String  showAddCustomerForm(Model model){
	return "addProduct";
	
}
@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
public String addCustomer(Model model, @ModelAttribute("product") Product product,HttpServletRequest request) {
    String forwardingPage="";
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
				forwardingPage="redirect:/listProduct";
				productDao.add(product);
				
			}
			else{
			  forwardingPage="addProduct";
			  model.addAttribute("error","The same product is not added!");
				
			}
			
		
					
		}
		else{
		 forwardingPage="addProduct";
		 model.addAttribute("error","Fill all the blanks!");
			
		}
		return forwardingPage;
	}
	
	else{
		 forwardingPage="addProduct";
		 model.addAttribute("error","Invalid add operation!");
		 return forwardingPage;
	}
	
	
}
 


@RequestMapping(value="/deleteProduct",method = RequestMethod.GET)  
public String delete(Model model,@RequestParam("id") int id){  
    //dao.delete(id);
    productDao.delete(id);
   
    return "redirect:/listProduct";
}  


	
@RequestMapping(value="/listProduct")  
public String listCustomer(Model model){  
	List<Product> products=(List<Product>)productDao.list();
	model.addAttribute("productList",products);
    return "listProduct";
}  
@RequestMapping(value = "/showEditProductForm/{id}", method = RequestMethod.GET)
public String  showEditCustomerForm(Model model,@PathVariable int id,HttpSession session){
	model.addAttribute("product",productDao.getProduct(id));
	session.setAttribute("editProductIndex",id);
	return "editProduct";
	
}


@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
public String editCustomer(Model model, @ModelAttribute("product") Product product,HttpServletRequest request) {
    String forwardingPage="";
	if(product!=null){
		
		String productName=product.getProductName();
		String price=product.getPrice();
		
		
		int id=(Integer)request.getSession().getAttribute("editProductIndex");
		
		if(productName!=null&&productName.trim().length()>0&&price!=null&&price.trim().length()>0){
			product.setProduct_id(id);
			forwardingPage="redirect:/listProduct";
			productDao.update(product,id);
			
					
		}
		else{
	     
		 forwardingPage="editProduct";
		 model.addAttribute("error","Fill all the blanks!");
			
		}
		return forwardingPage;
	}
	
	else{
		 forwardingPage="editProduct";
		 model.addAttribute("error","Invalid edit operation!");
		 return forwardingPage;
	}
	
	//return "";
}
	
	
	
}
