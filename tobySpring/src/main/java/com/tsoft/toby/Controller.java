package com.tsoft.toby;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) 
			throws Exception;
}
