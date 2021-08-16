package main;

public class Player {
	String name;
	int pos = 0;
	int money = 10000;
	boolean hasBuilding = false;
	int buildingExpense;
	int buildingIncome;

	public Player(String name) {
		this.name = name;
	}
}
