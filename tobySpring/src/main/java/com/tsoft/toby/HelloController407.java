package com.tsoft.toby;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController407 {
	@RequestMapping("/hello")
	public String hello(@RequestParam("name") String name, ModelMap map) {
		map.put("message", "Hello"+name);
		return "/WEB-INF/view/hello.jsp";
	}
}
