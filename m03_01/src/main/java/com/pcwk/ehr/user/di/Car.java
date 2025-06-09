package com.pcwk.ehr.user.di;

public class Car {

	private Engine engine;

	public Car(Engine engine) {
			super();
			this.engine =engine;
		}

	public void drive() {
		engine.start();
		System.out.println("Car가 달립니다.");
	}

}
