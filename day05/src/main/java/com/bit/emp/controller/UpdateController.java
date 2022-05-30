package com.bit.emp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpVo;
import com.bit.framework.BitController;

public class UpdateController implements BitController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setCharacterEncoding("utf-8");
		new EmpDao().updateOne(new EmpVo(
				Integer.parseInt(req.getParameter("empno")),
				Integer.parseInt(req.getParameter("sal")),
				req.getParameter("ename"),
				req.getParameter("job")
				));
		
		return "redirect:index.bit";
	}

}
