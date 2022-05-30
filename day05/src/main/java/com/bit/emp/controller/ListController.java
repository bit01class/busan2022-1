package com.bit.emp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.emp.model.EmpDao;
import com.bit.emp.model.EmpVo;
import com.bit.framework.BitController;

public class ListController implements BitController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		EmpDao dao=new EmpDao();
		List<EmpVo> list=dao.selectAll();
		req.setAttribute("list", list);
		return "emp/list";
	}

}
