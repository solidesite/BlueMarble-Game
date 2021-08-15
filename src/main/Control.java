package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Control {
	Scanner scan = new Scanner(System.in);
	Land land = new Land();
	ArrayList<Player> playerArr = new ArrayList<Player>();
	Player p;
	int playerNum = 0;

	public void passTurn() {
		// �÷��̾� �ѱ��
		playerNum++;
		if (playerNum == playerArr.size()) {
			playerNum = 0;
		}
	}

	public void randomEvent() {
		System.out.println("--------------------");
		System.out.println("-���� ��ġ : " + (p.pos + 1));
		System.out.println("-���� ��� : " + p.money);
		System.out.println("<< Ȳ�ݿ��� �̺�Ʈ �߻� >>");
		System.out.println("1���� ���� �ֻ����� ��������");
		String input = scan.nextLine();
		Random rd = new Random();
		int randomE = rd.nextInt(3);
		if (input.equals("1")) {
			if (randomE == 0) {
				System.out.println("����� ���������� �Ͽ� ������ �½��ϴ�.");
				System.out.println("1000$�� �����߽��ϴ�.");
				p.money -= 1000;
			} else if (randomE == 1) {
				System.out.println("����� ��ȸ�� �Ի��Ͽ� ����� ������ϴ�.");
				System.out.println("1000$�� ������ϴ�.");
				p.money += 1000;
			} else if (randomE == 2) {
				System.out.println("����� �ζǿ� ��÷�Ǿ����ϴ�.");
				System.out.println("5000$�� ������ϴ�.");
				p.money += 5000;
			}
		}
	}

	public void start() {

		Land map[] = new Land[10];
		for (int i = 0; i < map.length; i++) {
			map[i] = new Land();
		}
		map[0].event = 0;
		map[1].event = 1;
		map[2].event = 0;
		map[3].event = 1;
		map[4].event = 0;
		map[5].event = 1;
		map[6].event = 0;
		map[7].event = 1;
		map[8].event = 2;
		map[9].event = 0;

		playerArr.add(new Player("�÷��̾�1"));
		playerArr.add(new Player("�÷��̾�2"));

		while (true) {
			p = playerArr.get(playerNum);
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			System.out.println("********************");
			System.out.println(p.name + "�� �����Դϴ�.");

			// ���ε�
			if (p.isolateCount == 0) {
				p.isolation = false;
			} else if (p.isolation == true) {
				System.out.println("���ε� ���� " + p.isolateCount + "�� ���ҽ��ϴ�.");
				p.isolateCount--;
				passTurn();
				continue;
			}

			System.out.println("-���� ��ġ : " + (p.pos + 1));
			System.out.println("-���� ��� : " + p.money);
			System.out.println("1���� ���� �ֻ����� ��������");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("--------------------");
				System.out.println("      �ֻ��� - << " + dice + " >>");
				p.pos += dice;
				int left = p.pos - 10;
				if (p.pos > 9) {
					p.pos = 0;
					p.pos += left;
					p.money += 3000;
					System.out.println("������ġ : 2000$ ȹ��");
				}
			}

			// land �̺�Ʈ
			if (map[p.pos].event == 1) {
				// Ȳ�ݿ��� �̺�Ʈ
				randomEvent();
			} else if (map[p.pos].event == 2) {
				// ���ε� �̺�Ʈ
				System.out.println("--------------------");
				System.out.println("-���� ��ġ : " + (p.pos + 1));
				System.out.println("<< ���ε� �̺�Ʈ �߻� >>");
				System.out.println(p.name + "���� ���ε��� �������ϴ�.");
				p.isolation = true;
				continue;
			} else if (map[p.pos].event == 3) {
				System.out.println("--------------------");
				System.out.println("-���� ��ġ : " + (p.pos + 1));
				System.out.println("���Ե� ���Դϴ�.");
				p.money -= p.buildingCredit;
				System.out.println(p.buildingCredit + "$�� �����߽��ϴ�.");
			}

			// �̵� ��
			if (p.money <= 0) {
				System.out.println("�Ļ��߽��ϴ�. ���� ����");
				passTurn();
				System.out.println(p.name + "���� �̰���ϴ�.");
				break;
			}
			System.out.println("--------------------");
			System.out.println("-���� ��ġ : " + (p.pos + 1));
			System.out.println("-���� ��� : " + p.money);
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("2.�� �ѱ�� 3.�ǹ� ����");
			String input2 = scan.nextLine();
			if (input2.equals("2")) {
//				continue;
			} else if (input2.equals("3")) {
				if (p.hasBuilding == true) {
					System.out.println("�ǹ��� �̹� �����߽��ϴ�.");
				} else if (map[0].event == 3) {
					System.out.println("�ٸ������ �̹� ������ ���Դϴ�.");
				} else {
					System.out.println("--------------------");
					System.out.println("<< �ǹ� ���� >>");
					System.out.println("������ �ǹ��� �����Ͻʽÿ�.");
					System.out.println("1.�ʱ� �ǹ� : 4000$");
					System.out.println("2.�߱� �ǹ� : 6000$");
					System.out.println("3.��� �ǹ� : 8000$");
					String input3 = scan.nextLine();
					if (input3.equals("1")) {
						p.buyBuilding1();
						map[p.pos].event = 3;
						passTurn();
						p.buildingCredit = p.buildingPrice1 / 2;
						passTurn();
					} else if (input3.equals("2")) {
						p.buyBuilding2();
						map[p.pos].event = 3;
						passTurn();
						p.buildingCredit = p.buildingPrice1 / 2;
						passTurn();
					} else if (input3.equals("3")) {
						p.buyBuilding3();
						map[p.pos].event = 3;
						passTurn();
						p.buildingCredit = p.buildingPrice1 / 2;
						passTurn();
					}
				}
			}
			passTurn();
		}
	}

}
