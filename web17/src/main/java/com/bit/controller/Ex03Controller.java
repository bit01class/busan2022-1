package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *      url가 /로 시작하지 않은 경우
 * 		url 주소가 겹칠경우
 * 
 * 
@WebServlet(value = {"/ex03.html","/ex03.bit"}, initParams = {
		@WebInitParam(name = "key1", value = "val1"),
		@WebInitParam(name = "key2", value = "val2")
})

@WebServlet(value = {"/ex03.html","/ex03.bit"})
@WebServlet(value = {"/ex03.html"})
@WebServlet(name = "/ex03.html")
*/
@WebServlet("/ex03.html")
public class Ex03Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key1=getInitParameter("key1");
		String key2=getInitParameter("key2");
		System.out.println("ex03 controller...");
		System.out.println("key1:"+key1);
		System.out.println("key2:"+key2);
	}
}













