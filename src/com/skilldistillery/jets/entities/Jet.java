package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String type;
	private String model;
	private int speed;
	private int range;
	private long price;
	public void fly() {
		double flightHours = (double) (range/speed);
		System.out.println("Type: " + type + " Model: " + model + " Max Speed: " + speed + " Max Range: " + range + " Price: " + price + " You have " + flightHours+ " hours left of fuel");
	}
	public Jet(String type, String model, int speed, int range, long price) {
		super();
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}
	public Jet() {
		
	}
	@Override
	public String toString() {
		return "Jet [type=" + type + ", model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speed, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && range == other.range
				&& speed == other.speed && Objects.equals(type, other.type);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
}	