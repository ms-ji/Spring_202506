package com.pcwk.ehr.user.di.setter;

public class Main {

	public static void main(String[] args) {
		Engine engine = new Engine();
		
		Car car = new Car();
		car.setEngine(engine); //setter DI
		car.drive();

	}

}
