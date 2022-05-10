package com.bit;

import org.apache.log4j.Logger;

public class Ex02 {
	static Logger log=Logger.getLogger("com.bit.Ex02");

	public void func01() {
		log.trace("몰라 메시지");
		log.debug("디버그모드 메시지");
		log.info("정보모드 메시지");
		log.warn("주의모드 메시지");
		log.error("에러모드 메시지");
		log.fatal("심각모드 메시지");
	}
}
