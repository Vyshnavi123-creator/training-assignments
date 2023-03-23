package com.vyshnavi.demo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
//@RequestMapping("/customer")
public class CustomerController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor=new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, editor);
	}
	@RequestMapping("/showForm")
     public String showForm(Model theModel) {
    	 theModel.addAttribute("customer",new Customer());
    	 return "customer-form.jsp";
     }
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "customer-form.jsp";
		}
		else {
		    return "customer-confirmation.jsp";
		}
	}
}
