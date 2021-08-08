package com.skilldistillery.jets.entities;

public class Fighters extends Jet implements FireWeapons {

	public Fighters() {
	
	}

	

	public Fighters(String type, String model, int speed, int range, long price) {
		super(type, model, speed, range, price);
		
	}



	@Override
	public void fireweapons() {
		System.out.println("FIRING WEAPONS!!!");
		
	}
	
    
}
