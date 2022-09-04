package com.tsoft.toby;

import junit.framework.Assert;

import javax.servlet.Servlet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
 

 
public class HttpRequestMockTest {
 
	/**
	 * 서블릿 호출에 필요한 Request 객체에 대한 Mocking 클래스
	 */
	private MockHttpServletRequest request;
 
	/**
	 * 서블릿 호출에 필요한 Response 객체에 대한 Mocking 클래스
	 */
	private MockHttpServletResponse response;
 
	/**
	 * 서블릿 호출 테스트를 위한 대상 테스트 클래스
	 */
	private Servlet servlet;
 
	/**
	 * 서블릿 호출을 위한 Mocking 클래스를 생성하는 초기 셋업 메소드
	 */
	@Before
	public void setUp() {
//		servlet  = new Servlet();
 
		request  = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}
 
 
    /**
     * 서블릿 호출을 수행해보는 테스트 메소드
     */
    @Test
    public void testCallMyServlet() throws Exception
    {
        servlet.service(request, response);
        Assert.assertEquals(servlet.getClass().getSimpleName(), (String) request.getAttribute("res"));
    }
 
}