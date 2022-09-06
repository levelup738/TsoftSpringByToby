package com.tsoft.toby;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SplUrlController implements Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(SplUrlController.class);

	@Autowired
	HelloSpring helloSpring;

	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name = req.getParameter("name");
		String message = this.helloSpring.sayHello(name);

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message", message);
		
		logger.info("SplUrlController : {}", message);

		return new ModelAndView("hello", model);
	}

}
