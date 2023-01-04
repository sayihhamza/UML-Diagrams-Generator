package org.mql.java.example.classes;

import java.util.List;

import org.mql.java.example.enums.EnergeyType;
import org.mql.java.example.interfaces.Sound;

public class Bike extends Vehicle implements Sound {

	private Driver driver;
	private final List<Wheel> wheels;
	private final EnergeyType energeyType;
	
	public Bike(Driver driver,List<Wheel> wheels) {
		this.driver = driver;
		this.wheels = wheels;
		this.energeyType = EnergeyType.LEGS;
	}

	@Override
	public String toString() {
		return "Bike [driver=" + driver + ", wheels=" + wheels + ", energeyType=" + energeyType + "]";
	}

	@Override
	public void makeSound() {
		
	}

}
