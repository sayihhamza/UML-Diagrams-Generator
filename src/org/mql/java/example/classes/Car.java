package org.mql.java.example.classes;

import java.util.List;

import org.mql.java.example.annotations.*;
import org.mql.java.example.interfaces.Sound;

@VehicleLabel(value="Audi",modelYear=1988)
public class Car extends Vehicle implements Sound{
	
	private Driver driver;
	private final List<Wheel> wheels;

	public Car(Driver driver,List<Wheel> wheels) {
		this.driver = driver;
		this.wheels = wheels;
	}

	@Override
	public String toString() {
		return "Driver : " + driver + " | Wheels : " + wheels.size();
	}
		
	@Override
	public void makeSound() {
		
	}
	
	public void inCaseOfAccidentDriveBike(Bike bike) {
		
	}
}
