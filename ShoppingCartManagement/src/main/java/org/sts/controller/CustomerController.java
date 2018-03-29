package org.sts.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.sts.entities.Customer;
import org.sts.validator.CustomerValidator;


@Controller
public class CustomerController {
	

	@Autowired
	private CustomerValidator customerValidator;
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	protected String registerForm(Model model)
	{
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
	
	
	

}
