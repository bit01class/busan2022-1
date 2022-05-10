package com.bit;

import org.apache.log4j.Logger;

public class Ex01 {
	static Logger log=Logger.getLogger("com.bit.Ex01");
	// level : trace  < debug < info < warn < error < fatal

	public static void main(String[] args) {
		String msg="hello world";
		log.trace("몰라 메시지");
		log.debug("디버그모드 메시지");
		log.info("정보모드 메시지");
		log.warn("주의모드 메시지");
		log.error("에러모드 메시지");
		log.fatal("심각모드 메시지");
		System.out.println(msg);
		Ex02 ex02=new Ex02();
		ex02.func01();
	}

}
