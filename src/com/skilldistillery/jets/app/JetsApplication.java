package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Cargo;
import com.skilldistillery.jets.entities.Fighters;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Recon;

public class JetsApplication {
	Scanner kb = new Scanner(System.in);
	private AirField airField;
	public JetsApplication(){
		airField = new AirField();
	}
	public static void main(String[] args) {
		List<Jet> jets = new ArrayList<>();
		String fileName = "Jets.txt";
		JetsApplication jetApp = new JetsApplication();
	
		
		jetApp.readJets(fileName);
		jetApp.launch(jets);
	}
		
		public void readJets(String fileName) {
			List<Jet> jetInfo = new ArrayList<>();
			

			try { BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"));  
				String line = null;
			
				while ((line = bufIn.readLine()) != null) {
					String[] jet = line.split(", ");
					
					
					if(jet[0].equals("Fighter")) {
					 Jet fight = new Fighters(jet[0], jet[1], Integer.parseInt(jet[2]), Integer.parseInt(jet[3]), Long.parseLong(jet[4]) );
					 jetInfo.add(fight);
					} else if (jet[0].equals("Cargo")) {
					 Jet cargo = new Cargo(jet[0], jet[1], Integer.parseInt(jet[2]), Integer.parseInt(jet[3]), Long.parseLong(jet[4]));
					 jetInfo.add(cargo);

					} else if (jet[0].equals("Recon")) {
						Jet recon = new Recon(jet[0], jet[1],Integer.parseInt(jet[2]), Integer.parseInt(jet[3]), Long.parseLong(jet[4]));
						jetInfo.add(recon);
					} 
				}	}
					catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
			airField.setJet(jetInfo);
		}

	
		
	private void launch(List<Jet> jets) {
		Cargo cargo = new Cargo();
		Fighters fight = new Fighters();
		Recon recon = new Recon();
		int choice = 10;
		while(choice != 0) {
			System.out.println("1)  List fleet ");
			System.out.println("2)  Fly all jets");
			System.out.println("3)  View fastest jet");
			System.out.println("4)  View aircraft with longest range");
			System.out.println("5)  Load all cargo jets");
			System.out.println("6)  Fire weapons");
			System.out.println("7)  Recon");
			System.out.println("8)  Add jet to fleet");
			System.out.println("9)  Remove aircraft from fleet");
			System.out.println("0)  Done / Quit");
			
			choice = kb.nextInt();
			kb.nextLine();
			switch (choice) {
			case 1:
				listFleet();
				break;
			case 2:
				flyAll();
				break;
			case 3:
				viewFastest(jets);
				break;
			case 4:
				viewLongestRange(jets);
				break;
			case 5:
				cargo.loadingCargo();
				break;
			case 6:
				fight.fireweapons();
				break;
			case 7:
				recon.reconnaissance();
				break;
			case 8:
				addToFleet(jets);
				break;
			case 9:
				removeFromFleet(jets);
				break;
			case 0:
				System.out.println("You chose quit, goodbye.");
				break;

			}
			
			

		}
		
	}
	private void removeFromFleet(List<Jet> jets) {
		AirField af = new AirField();
		kb = new Scanner(System.in);
		System.out.println("What jet would you like to remove?");
		System.out.println(af.getJet());
		System.out.println("1)"+ jets.get(0));
		System.out.println("2)"+ jets.get(1));
		System.out.println("3)"+ jets.get(2));
		System.out.println("4)"+ jets.get(3));
		System.out.println("5)"+ jets.get(4));
		int choice = kb.nextInt();
		
		switch(choice) {
		
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
	private void addToFleet(List<Jet> jets) {
		kb = new Scanner(System.in);
		System.out.println("You have chosen to add a new jet");
		System.out.println("What type of jet would you like to add?");
		System.out.println("1) Fighter");
		System.out.println("2) Reconnissance");
		System.out.println("3) Cargo");
		System.out.println("----------------------------------------------------------");
		int selection = kb.nextInt();
		
		switch(selection) {
		
		case 1:
			String type ="Fighter";
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
	private void viewLongestRange(List<Jet> jet) {
		List<Jet> fleet = airField.getJet();
		int top = 0;
		int longest = jet.get(0).getRange();
		for (Jet j : fleet) {
			if(top<longest) {
				top = longest;
				
			}
			System.out.println("The fastest jet in the fleet is "+ longest);
		}
		
	}
	private void viewFastest(List<Jet> jet) {
		double max = 0;
		String fastestJet = null;
		for (int i = 0; i < jet.size(); i++) {
			 if (max < jet.get(i).getSpeed()) {
				max = jet.get(i).getSpeed();
				fastestJet = jet.toString();
			}
			 System.out.println(fastestJet);
		}
	}
	public void listFleet() {
List<Jet> fleet = airField.getJet();
		for (Jet jet : fleet) {
			
		
			System.out.println(jet);
			System.out.println("------------------------------------------------------------");
			System.out.println();
		}
	}
	public void flyAll() {
		List<Jet> fleet = airField.getJet();
		for (Jet jet : fleet) {
			jet.fly();
		}
		
	}
}