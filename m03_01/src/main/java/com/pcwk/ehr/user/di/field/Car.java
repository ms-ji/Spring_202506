package com.pcwk.ehr.user.di.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	private Engine engine; //필드 주입
	
	public void drive() {
		engine.start();
		System.out.println("Car 운전 붕붕!");
	}
	
	
}
