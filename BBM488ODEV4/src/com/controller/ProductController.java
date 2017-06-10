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


	
	
}
