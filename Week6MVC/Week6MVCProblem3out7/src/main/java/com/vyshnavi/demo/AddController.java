package com.vyshnavi.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vyshnavi.service.AddService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AddController {

//	@RequestMapping("add")
//	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
//		int i=Integer.parseInt(request.getParameter("t1"));
//		int j=Integer.parseInt(request.getParameter("t2"));
//		
//		AddService ad=new AddService();
//		int k=ad.add(i, j);
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("display.jsp");
//		mv.addObject("result", k);
//		return mv;
//	}
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("t1")int i,@RequestParam("t2")int j) {
		
		AddService ad=new AddService();
		int k=ad.add(i, j);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", k);
		return mv;
	}
}
