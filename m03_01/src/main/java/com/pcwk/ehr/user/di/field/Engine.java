package com.pcwk.ehr.user.di.field;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	public Engine() {}
	
	public void start() {
		System.out.println("Engine 시동!");
	}
}
