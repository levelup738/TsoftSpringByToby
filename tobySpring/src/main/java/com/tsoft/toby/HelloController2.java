package com.tsoft.toby;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController2 extends SimpleController{
	
public HelloController2(){
	
	this.setRequiredParams (new String[] {"name"} );
	this.setViewName("/WEB-INF/view/hello.jsp");
	
}
public void control (Map<String, String> params, Map<String, Object> model)
		throws Exception {
			model.put ("message", "Hello " + params.get ("name"));
		}

}

