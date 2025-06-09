package com.pcwk.ehr.user.di.setter;

public class Car {

	private Engine engine;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public void setEngine(Engine engine) {
			this.engine =engine;
		}

	public void drive() {
		engine.start();
		System.out.println("Car가 달립니다.");
	}

}
