package com.tsoft.toby;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface SimpleController2 {
	
	//private String[] requiredParams;
	//private String viewName;
	
	//public void setRequiredParams (String[] requiredParams){
	//	this.requiredParams = requiredParams;
	//}
	
	//public void setViewName (String vienName) {
	//	this.viewName = viewName;	
	//}
			
	//final public ModelAndView handleRequest (HttpServletRequest req,HttpServletResponse res) throws Exception{
	//	if (viewName == null) throw new IllegalStateException();
	//	Map<String, String> params = new HashMap<String, String>();
	//	
	//	for(String param : requiredParams) {
	//		String value = req.getParameter (param);
	//		if (value == null) throw new IllegalStateException();
	//		params.put(param, value);
	//	}
		
	//	Map<String, Object> model = new HashMap<String, Object>();
	//	this.control(params, model);
	//	return new ModelAndView(this.viewName, model);
	//}
	
	//public abstract void control (Map <String, String> params, Map<String, Object> model) throws Exception;
		
	//	기존의 기반 클래스 방식은 기반 클래스에 미리 준비해둔 프로퍼티를 이용해서 필수 파라미터 목록과 뷰이름을 지정할 수 있게했다.
	// 인터페이스만 정의 하면 ? -> 어노테이션으로 / 상속을 통해 설정 프로퍼티를 제공하는 수준의 강제성은 없다.
	
	public void control (Map <String, String> params, Map<String, Object> model);
		
}





