package com.noritersand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 6174311087878978970L;
	private static final Logger log = LoggerFactory.getLogger(ServletTest.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) {
		log.debug("im a servlet");
		
		try {
			throw new RuntimeException("for test");			
		} catch (Exception e) {
			log.error(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getSuppressed());
			System.out.println(e.getStackTrace());
			
			log.error(e.getMessage(), e);
		}
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
}
