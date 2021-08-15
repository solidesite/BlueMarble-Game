package main;

public class Player {
	String name;
	int pos = 0;
	int money = 10000;
	boolean isolation = false;
	boolean hasBuilding = false;
	int buildingCredit;
	int buildingPrice1 = 4000;
	int buildingPrice2 = 6000;
	int buildingPrice3 = 10000;
	int isolateCount = 2;

	public Player(String name) {
		this.name = name;
	}

	public void buyBuilding1() {
		if (money < buildingPrice1) {
			System.out.println("���� �� �� �����ϴ�.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "���� " + (pos + 1) + "��ġ�� �ʱ� �ǹ��� �����մϴ�.");
			money -= buildingPrice1;
			hasBuilding = true;
			System.out.println("-���� ��� : " + money);
		}
	}

	public void buyBuilding2() {
		if (money < buildingPrice2) {
			System.out.println("���� �� �� �����ϴ�.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "���� " + (pos + 1) + "��ġ�� �߱� �ǹ��� �����մϴ�.");
			money -= buildingPrice2;
			hasBuilding = true;
			System.out.println("-���� ��� : " + money);
		}
	}

	public void buyBuilding3() {
		if (money < buildingPrice3) {
			System.out.println("���� �� �� �����ϴ�.");
		} else {
			System.out.println("--------------------");
			System.out.println(name + "���� " + (pos + 1) + "��ġ�� ��� �ǹ��� �����մϴ�.");
			money -= buildingPrice3;
			hasBuilding = true;
			System.out.println("-���� ��� : " + money);
		}
	}
}
