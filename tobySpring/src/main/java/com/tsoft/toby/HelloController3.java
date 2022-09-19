package com.tsoft.toby;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController3 implements SimpleController2 {

	@ViewName("/WEB-INF/view/hello.jsp")
	@RequiredParams({"name"})
	public void control(Map<String, String> params, Map<String, Object> model) {
		model.put("message", "Hello " + params.get("name"));
	}
	
	//2. SimpleController2 인터페이스를 구현하고 2개의 설정용 어노테이션을 부여한 메소드를 가진 컨트롤러 
	//3. 이제 핸들러 어댑터 만들러가자

}
