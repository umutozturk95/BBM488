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
public class LogoutController {

	@RequestMapping(value = "/logout",method = RequestMethod.GET)
	public String logout(Model model,HttpServletRequest request,HttpSession session) {
		model.addAttribute("message", "You are successfully logout!");
		session.invalidate();
		return "index";
	}
	
	
	
}
