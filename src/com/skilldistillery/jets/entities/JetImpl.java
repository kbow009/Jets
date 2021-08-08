package com.skilldistillery.jets.entities;

import java.util.Objects;

public class JetImpl extends Jet {
	private int passengerCap = 100;

	

	public JetImpl() {
		
	}

	public JetImpl(String type, String model, int speed, int range, long price) {
		super(type, model, speed, range, price);
		
	}

	public int getPassengerCap() {
		return passengerCap;
	}

	public void setPassengerCap(int passengerCap) {
		this.passengerCap = passengerCap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(passengerCap);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		JetImpl other = (JetImpl) obj;
		return passengerCap == other.passengerCap;
	}

	@Override
	public String toString() {
		return "JetImpl [passengerCap=" + passengerCap + "]";
	}

}
