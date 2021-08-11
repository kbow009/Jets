package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

	public JetsApplication() {
		airField = new AirField();
	}

	public static void main(String[] args) {
		List<Jet> jets = new ArrayList<>();
		String fileName = "Jets.txt";
		JetsApplication jetApp = new JetsApplication();

		jetApp.launch(jets);
	}

	
	private void launch(List<Jet> jets) {
		Cargo cargo = new Cargo();
		Fighters fight = new Fighters();
		Recon recon = new Recon();
		int choice = 10;
		while (choice != 0) {
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
				airField.listFleet();
				break;
			case 2:
				airField.flyAll();
				break;
			case 3:
				airField.viewFastest();
				break;
			case 4:
				airField.viewLongestRange();
				break;
			case 5:
				airField.loadTheCargo();
				break;
			case 6:
				airField.fireTheWeapons();
				break;
			case 7:
				airField.doReconnaissance();
				break;
			case 8:
				airField.addToFleet();
				break;
			case 9:
				airField.removeFromFleet();
				break;
			case 0:
				System.out.println("You chose quit, goodbye.");
				break;
			}
		}
	}
}