package com.tsoft.toby.Adapter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

import com.tsoft.toby.RequiredParams;
import com.tsoft.toby.SimpleController2;
import com.tsoft.toby.ViewName;

public abstract class SimpleHandlerAdapter implements HandlerAdapter{
	
	public boolean supports(Object handler){
		return (handler instanceof SimpleController2);
	}	
	
	public long getLastModified(HttpServletRequest req, Object handler) {
		return -1; //??????????
	}
	
	public ModelAndView handle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		
		Method m = ReflectionUtils.findMethod(handler.getClass(), "control", Map.class, Map.class);
		
		ViewName viewName = AnnotationUtils.getAnnotation(m, ViewName.class);
		RequiredParams requiredParams = AnnotationUtils.getAnnotation(m, RequiredParams.class);
		
		Map<String, String> params = new HashMap<String, String>();
		for(String param : requiredParams.value()) {
			String value = req.getParameter(param);
			if(value == null) throw new IllegalStateException();
			params.put(param, value);			
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		((SimpleController2)handler).control(params, model);
			
		
		return new ModelAndView(viewName.value(), model);		
	}
	
		
}





