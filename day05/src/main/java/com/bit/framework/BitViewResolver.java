package com.bit.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BitViewResolver {

	void viewResolver(String viewName, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException ;

}
