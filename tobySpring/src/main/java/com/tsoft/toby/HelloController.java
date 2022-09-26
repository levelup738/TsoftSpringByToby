package com.tsoft.toby;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

public class HelloController implements Controller {
	@Autowired
	HelloSpring helloSpring;
	private Object message;
	

	/*view 의 대해서
	 * https://joont92.github.io/spring/View-ViewResolver/ 현재 교재에 나와있는 view들의 정리가 잘되어있음 ( 참고 ! )
	 * 첫번째 view를 사용하는 방법
	 * 스프링이 제공하는 뷰 기반 뷰 클래스 확장하여 코드로 만드는법
	 * PDF,RSS 피드 같은 뷰는 API이용하여 뷰로직생성 
	 * 
	 * 스프링에서 제공하는 주요 뷰 ! 
	 * 그리고 전체적으로 컨트롤러 안에서 뷰 오브젝트 직접 생성보다 뷰 리졸버를 이용하는것이 훨씐 편리하다 
	 * 1.InternalResourseView :RequestDispatcher 랑 동작 원리가 비슷.
	 * RequestDispatcher방식과 같이 forward 방식을 사용하는데 include 방식을 사용하고 싶으면 InternalResourseView alwaysInclude 프로퍼티를 true 로 변경해주면 된다.
	 * 이미 HttpServletResponse 에 결과가 쓰여진 경우는 Include 방식으로 사용됨  
	 * 1-1 JstlView 
	 * InternalResourceView의 서브 클래스이다.
	 * JSP를 뷰 템플릿으로 사용할 때 JstlView를 사용하면 여러가지 추가 기능을 더 활용할 수 있다.(지역화 메세지 등)
	 * 2.RedirectView : 컨트롤러에서 RedirectView 오브젝트 직접 생성보단  뷰 리졸버 사용하는 방식이 더 용이함 
	 * 3.Velocity,FreeMarker 
	 * JSP 대신 Velocity, FreeMarker 템플릿 엔진을 뷰로 사용할 수 있게 해준다.
	 * 둘은 JSP보다 훨씬 문법이 강력하고 속도도 빠른 장점이 있다. 설정 및 사용법 -> 뷰 리졸버시 
	 * 4.MarshallingView
	 * 모델의 정보를 xml, json으로 변환시킬 수 있는 뷰다.
	 * MashallingView를 사용할 경우 xml, MappingJacksonJsonView를 사용할 경우 json으로 변환된다.
	 * 메세지 컨버터를 이용해서도 동일한 작업을 할 수 있다.
	 * 
	 *  */
	
	/*MarshallingView 매핑용 클래스 선언*/
	public class info {
		String message;
		
		public info(String message) {this.message =message;}
		public String getMessage() {return message;}
		
	}
	public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception{
//		String name = req.getParameter("name");
//		String message = this.helloSpring.sayHello(name);
//		
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("message", message);
//		
//		return new ModelAndView("hello", model);
		
		/*1. InternalResourseView 방식 */
		//모델 생성 
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("message", message);
		
		//view 생성 컨트롤러 안에서 뷰를 생성하여 사용하는 경우
		//뷰 리졸버 사용시는 jsp 파일위치나타내는 논리적인 뷰이름만 넘겨주면 된다(간단)
		View view =new InternalResourceView("/WEB-INF/views/hellow.jsp");
		return new ModelAndView(view,model); 
		
		/*
		 * RedirectView 리졸버 이용방식
		 * return new ModelView(new RedirectView("/main")); RedirectView 오브젝트 리턴 방식사용가능하고 
		 * return new ModelView("redirect:/main")  redirect:  접두어 사용해서 뷰이름만 리턴 가능  -> 이방식은 풀 유알엘을 다적어줘야 하는데 contextRelative true시 상대경로 사용가능 */
		
		
	}


}
