package org.mql.java.example.classes;

import java.util.List;

import org.mql.java.example.annotations.VehicleLabel;
import org.mql.java.example.interfaces.Sound;

@VehicleLabel(value="Audi",modelYear=2013)
public class Bike extends Vehicle implements Sound {

	private Driver driver;
	private final List<Wheel> wheels;
	
	public Bike(Driver driver,List<Wheel> wheels) {
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

}
