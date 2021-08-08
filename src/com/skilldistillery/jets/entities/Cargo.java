package com.skilldistillery.jets.entities;

public class Cargo extends Jet implements LoadCargo {

	public Cargo() {
	}

	public Cargo(String type, String model, int speed, int range, long price) {
		super(type, model, speed, range, price);
	}



	@Override
	public void loadingCargo() {
		System.out.println("Cargo loaded!");
		
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	

}
