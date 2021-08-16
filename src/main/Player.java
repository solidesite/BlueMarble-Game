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
			System.out.println("���� �� �� �����ϴ�.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "���� " + (pos + 1) + "��ġ�� �ʱ� �ǹ��� �����մϴ�.");
			money -= bp;
			hasBuilding = true;
			System.out.println("-���� ��� : " + money);
			buildingIncome = bp / 2;
		}
	}

	public void buyBuilding2(int bp) {
		if (money < bp) {
			System.out.println("���� �� �� �����ϴ�.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "���� " + (pos + 1) + "��ġ�� �߱� �ǹ��� �����մϴ�.");
			money -= bp;
			hasBuilding = true;
			System.out.println("-���� ��� : " + money);
			buildingIncome = bp / 2;
		}
	}

	public void buyBuilding3(int bp) {
		if (money < bp) {
			System.out.println("���� �� �� �����ϴ�.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "���� " + (pos + 1) + "��ġ�� ��� �ǹ��� �����մϴ�.");
			money -= bp;
			hasBuilding = true;
			System.out.println("-���� ��� : " + money);
			buildingIncome = bp / 2;
		}
	}
}
