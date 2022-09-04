package com.tsoft.toby;

import java.io.IOException;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;




public class ServletControllerTest extends AbstractDispatcherServletTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ServletControllerTest.class);

	@Test
	public void helloServletController() throws ServletException, IOException{
		
	
		
		setClasses(SimpleServletHandlerAdapter.class, HelloServlet.class);
		initRequest("/hello2").addParameter("name", "Spring");
		
		assertThat(runService().getContentAsString(), is("Hello Spring"));
		
	}
	
	@Component("/hello2")
	static class HelloServlet extends HttpServlet{
		
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
			String name = req.getParameter("name");
			resp.getWriter().print("Hello "+name);
			logger.info("와아아앙ㅇ~~~");
		}
	}

}
