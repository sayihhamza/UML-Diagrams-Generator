package org.mql.java.example.classes;

import java.util.List;

import org.mql.java.example.enums.EnergeyType;
import org.mql.java.example.interfaces.Sound;

public class Car extends Vehicle implements Sound{
	
	private Driver driver;
	private final List<Wheel> wheels;
	private final EnergeyType energeyType;
	
	public Car(Driver driver,EnergeyType energeyType,List<Wheel> wheels) {
		this.driver = driver;
		this.energeyType = energeyType;
		this.wheels = wheels;
	}
		
	@Override
	public String toString() {
		return "Car [driver=" + driver + ", wheels=" + wheels + ", energeyType=" + energeyType + "]";
	}

	@Override
	public void makeSound() {
		
	}
	
	public void inCaseOfAccidentDriveBike(Bike bike) {
		
	}
}
