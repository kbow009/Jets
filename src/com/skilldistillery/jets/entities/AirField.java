package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class AirField {
	
	private List<Jet> jets = new ArrayList<>();
	
	
	
	public AirField() {
		
		this.jets = jets;
	}


	
	
		
		
	@Override
	public String toString() {
		return "AirField [jet=" + jets + "]";
	}


	public List<Jet> getJet() {
		return jets;
	}


	public void setJet(List<Jet> jet) {
		this.jets = jet;
	}
}