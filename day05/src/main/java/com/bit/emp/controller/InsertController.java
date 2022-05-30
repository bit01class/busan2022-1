package com.bit.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpVo;
import com.bit.framework.BitController;

public class InsertController implements BitController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		EmpVo bean=new EmpVo(
				Integer.parseInt(req.getParameter("empno")),
				Integer.parseInt(req.getParameter("sal")),
				req.getParameter("ename"),
				req.getParameter("job")
				);
		new EmpDao().insertOne(bean);
		return "redirect:index.bit";
	}

}
