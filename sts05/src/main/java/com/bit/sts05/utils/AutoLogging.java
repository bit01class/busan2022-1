package com.bit.sts05.utils;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoLogging {
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	public void beforeAop(JoinPoint point) {
		log.debug(point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName());
	}
}
