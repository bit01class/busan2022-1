package com.bit.sts05.service;

import java.sql.SQLException;

import org.springframework.ui.Model;

import com.bit.sts05.model.EmpVo;

public interface EmpService {

	void selectAll(Model model) throws SQLException;

	void insert(EmpVo bean) throws SQLException;

}