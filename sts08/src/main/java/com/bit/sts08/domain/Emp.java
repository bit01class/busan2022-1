package com.bit.sts08.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

	private int empno,sal;
	private String ename,job;
	private Timestamp hiredate;
}
