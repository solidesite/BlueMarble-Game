package main;

public class Player {
	String name;
	int pos = 1;
	int money = 10000;
	boolean isolation = false;
	boolean hasBuilding = false;
	boolean buildingCredit = false;
	int isolateCount = 2;
	public Player (String name) {
		this.name = name;
	} 
}
