package com.bit.frame.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class My2Listener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("2requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("2requestInitialized");
	}

}
