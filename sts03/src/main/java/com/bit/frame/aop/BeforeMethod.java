package com.bit.frame.aop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeMethod implements MethodBeforeAdvice {
	Logger log=Logger.getLogger(this.getClass());

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		log.debug(target);
	}

}
