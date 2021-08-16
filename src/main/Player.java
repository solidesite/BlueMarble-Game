package main;

public class Player {
	String name;
	int pos = 0;
	int money = 10000;
	boolean isolation = false;
	boolean hasBuilding = false;
	int buildingExpense;
	int buildingIncome;
	int isolateCount = 2;

	public Player(String name) {
		this.name = name;
	}

	public void buyBuilding1(int bp) {
		if (money < bp) {
			System.out.println("매입 할 수 없습니다.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "님이 " + (pos + 1) + "위치에 초급 건물을 매입합니다.");
			money -= bp;
			hasBuilding = true;
			System.out.println("-현재 재산 : " + money);
			buildingIncome = bp / 2;
		}
	}

	public void buyBuilding2(int bp) {
		if (money < bp) {
			System.out.println("매입 할 수 없습니다.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "님이 " + (pos + 1) + "위치에 중급 건물을 매입합니다.");
			money -= bp;
			hasBuilding = true;
			System.out.println("-현재 재산 : " + money);
			buildingIncome = bp / 2;
		}
	}

	public void buyBuilding3(int bp) {
		if (money < bp) {
			System.out.println("매입 할 수 없습니다.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "님이 " + (pos + 1) + "위치에 고급 건물을 매입합니다.");
			money -= bp;
			hasBuilding = true;
			System.out.println("-현재 재산 : " + money);
			buildingIncome = bp / 2;
		}
	}
}
