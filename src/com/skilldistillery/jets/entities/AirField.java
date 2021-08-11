package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AirField {
	Scanner kb = new Scanner(System.in);
	private List<Jet> jets = new ArrayList<>();
	
	
	
	public AirField() {
		readJets("Jets.txt");
		
	}
	
	public void listFleet() {
		for (Jet jet : jets) {

			System.out.println(jet);
			System.out.println("------------------------------------------------------------");
			System.out.println();
		}
	}
	public void flyAll() {
		
		for (Jet jet : jets) {
			jet.fly();
		}

	}
	public void viewFastest() {
		Jet fastest = jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			if (fastest.getSpeed() < jets.get(i).getSpeed()) {
				fastest = jets.get(i);
				
			}
		}
		System.out.println("The fastest jet is : " +fastest);
	}
	public void addToFleet() {
		kb = new Scanner(System.in);
		System.out.println("You have chosen to add a new jet");
		System.out.println("What type of jet would you like to add?");
		System.out.println("1) Fighter");
		System.out.println("2) Reconnissance");
		System.out.println("3) Cargo");
		System.out.println("----------------------------------------------------------");
		int selection = kb.nextInt();

		switch (selection) {

		case 1:
			String type = "Fighter";
			System.out.println("Please enter the model");
			String model = kb.next();
			System.out.println("Please enter the speed of your jet: ");
			int speed = kb.nextInt();
			System.out.println("Please enter the range of your jet: ");
			int range = kb.nextInt();
			System.out.println("Please enter the price of your new jet: ");
			long price = kb.nextInt();
			Jet newFighter = new Fighters(type, model, speed, range, price);
			jets.add(newFighter);
			System.out.println("Your new jet hass been added to the air field");
			for (Jet jet : jets) {
				System.out.println(jet);
			}

			break;
		case 2:
			String typeR = "Recon";
			System.out.println("Please enter the model");
			String modelR = kb.next();
			System.out.println("Please enter the speed of your jet: ");
			int speedR = kb.nextInt();
			System.out.println("Please enter the range of your jet: ");
			int rangeR = kb.nextInt();
			System.out.println("Please enter the price of your new jet: ");
			long priceR = kb.nextInt();
			Jet newRecon = new Recon(typeR, modelR, speedR, rangeR, priceR);
			jets.add(newRecon);
			System.out.println("Your new jet hass been added to the air field");
			for (Jet jet : jets) {
				System.out.println(jet);
			}

			break;
		case 3:
			String typeC = "Cargo";
			System.out.println("Please enter the model");
			String modelC = kb.next();
			System.out.println("Please enter the speed of your jet: ");
			int speedC = kb.nextInt();
			System.out.println("Please enter the range of your jet: ");
			int rangeC = kb.nextInt();
			System.out.println("Please enter the price of your new jet: ");
			long priceC = kb.nextInt();
			Jet newCargo = new Cargo(typeC, modelC, speedC, rangeC, priceC);
			jets.add(newCargo);
			System.out.println("Your new jet hass been added to the air field");
			for (Jet jet : jets) {
				System.out.println(jet);
			}

			break;
		}

	}
	public void removeFromFleet() {
		AirField af = new AirField();
		kb = new Scanner(System.in);
		System.out.println("What jet would you like to remove?");
		System.out.println(af.getJet());
		System.out.println("1)" + jets.get(0));
		System.out.println("2)" + jets.get(1));
		System.out.println("3)" + jets.get(2));
		System.out.println("4)" + jets.get(3));
		System.out.println("5)" + jets.get(4));
		int choice = kb.nextInt();

		switch (choice) {

		case 1:
			jets.remove(0);
			break;
		case 2:
			jets.remove(1);
			break;
		case 3:
			jets.remove(2);
			break;
		case 4:
			jets.remove(3);
			break;
		case 5:
			jets.remove(4);
			break;
		}
		System.out.println("Your selection has been removed.");
	}
	public void loadTheCargo() {
		Jet j = new Cargo();

		if (j instanceof Cargo) {
			Cargo e = (Cargo) j;
		  ((LoadCargo)j).loadingCargo();
		}
	}
	public void fireTheWeapons() {
		Jet j = new Fighters();

		if (j instanceof Fighters) {
			Fighters e = (Fighters) j;
		  ((FireWeapons)j).fireweapons();
		}
	}
	public void doReconnaissance() {
		Jet j = new Recon();

		if (j instanceof Recon) {
			Recon e = (Recon) j;
		  ((SuperSpy)j).reconnaissance();
		}
	}



	public void viewLongestRange() {
		Jet longest = jets.get(0);
		for (int i = 0; i < jets.size(); i++) {
			if(longest.getRange()<jets.get(i).getRange()){
		}
		}
		System.out.println("The jet with the longest range is: " + longest);

	}
	public void readJets(String fileName) {

		try {
			BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"));
			String line = null;

			while ((line = bufIn.readLine()) != null) {
				String[] jet = line.split(", ");

				if (jet[0].equals("Fighter")) {
					Jet fight = new Fighters(jet[0], jet[1], Double.parseDouble(jet[2]), Integer.parseInt(jet[3]),
							Long.parseLong(jet[4]));
					jets.add(fight);
				} else if (jet[0].equals("Cargo")) {
					Jet cargo = new Cargo(jet[0], jet[1], Double.parseDouble(jet[2]), Integer.parseInt(jet[3]),
							Long.parseLong(jet[4]));
					jets.add(cargo);

				} else if (jet[0].equals("Recon")) {
					Jet recon = new Recon(jet[0], jet[1], Double.parseDouble(jet[2]), Integer.parseInt(jet[3]),
							Long.parseLong(jet[4]));
					jets.add(recon);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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