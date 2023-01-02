package org.mql.java.example.classes;

public class Driver {
	
	private String name;
	private Vehicle primaryVehicle;
	private Vehicle secondaryVehicle;
	
	public Driver(String name, Vehicle primaryVehicle, Vehicle secondaryVehicle) {
		this.name = name;
		this.primaryVehicle = primaryVehicle;
		this.secondaryVehicle = secondaryVehicle;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", primaryVehicle=" + primaryVehicle + ", secondaryVehicle=" + secondaryVehicle
				+ "]";
	}
}
