package com.bit.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.framework.BitController;

public class DetailController implements BitController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		EmpDao dao=new EmpDao();
		req.setAttribute("bean", dao.selectOne(Integer.parseInt(req.getParameter("empno"))));
		return "emp/detail";
	}

}
