package com.bit.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.controller.IndexController;
import com.bit.emp.controller.ListController;
import java.util.Properties;


public class DispatcherServlet extends HttpServlet {
	private BitViewResolver resolver;
	private BitHandlerMapping handler;
	

	
	@Override
	public void init() throws ServletException {
		String bit=getInitParameter("bit");
		if(bit==null) bit="/WEB-INF/bit.properties";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(getServletContext().getRealPath(bit)));
		
			SimpleHandlerMapping handler =(SimpleHandlerMapping) Class.forName(prop.getProperty("handlerMapping")).newInstance();
			handler.setPath(getServletContext().getRealPath("./")+"WEB-INF\\classes\\mapping.properties");
			this.handler=handler;
			
			SimpleViewResolver resolver=(SimpleViewResolver) Class.forName(prop.getProperty("viewResolver")).newInstance();
			resolver.setPrefix("/WEB-INF/views/");
			resolver.setSuffix(".jsp");
			this.resolver=resolver;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req, resp);
	}
	public void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url=req.getRequestURI().substring(req.getContextPath().length());
		
		BitController controller=null;
		controller=handler.getMapping().get(url);
		
		String viewName="";
		try {
			viewName=controller.execute(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resolver.viewResolver(viewName,req,resp);
	}
	
}













