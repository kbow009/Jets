package com.skilldistillery.jets.entities;

public class Recon extends Jet implements SuperSpy {

	public Recon() {
		
	}

	public Recon(String type, String model, int speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	@Override
	public void reconnaissance() {
		System.out.println("Recon mission, roger that!");
	}

}
