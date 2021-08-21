package main;

public class Player {
	String name;
	int pos = 0;
	int money = 10000;
	boolean hasBuilding = false;
	boolean isolation = false;
	int isolationCount = 2;
	int buildingExpense;
	int buildingIncome;

	int posY;
	int width;
	int height;

	public Player(String name) {
		this.name = name;
	}

	public Player(int pos, int posY, int width, int height) {
		this.pos = pos;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}
}
