package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Land land = new Land();
		Land map [] =new Land[10];
		map[0].event = 0;
		map[1].event = 0;
		map[2].event = 0;
		map[3].event = 0;
		map[4].event = 0;
		map[5].event = 0;
		map[6].event = 0;
		map[7].event = 0;
		map[8].event = 0;
		map[9].event = 0;
		
		ArrayList<Player> playerArr = new ArrayList<Player>();
		playerArr.add(new Player ("�÷��̾�1"));
		playerArr.add(new Player ("�÷��̾�2"));
		Player p;
		int playerNum = 0;

		while (true) {
			p = playerArr.get(playerNum);
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			System.out.println(p.name + "�� �����Դϴ�.");
			System.out.println("���� ��ġ : " + p.pos);
			System.out.println("���� ��� : " + p.money);
			System.out.println("1���� ���� �ֻ����� ��������");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("�ֻ��� - <" + dice + ">");
				p.pos += dice;
				int left = p.pos - 10;
				if (p.pos > 10) {
					p.pos = 0;
					p.pos += left;
					p.money += 3000;
					System.out.println("������ġ : 2000$ ȹ��");
				}
			}
			System.out.println("���� ��ġ : " + p.pos);
			System.out.println("���� ��� : " + p.money);
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("2.�� �ѱ��");
			String input2 = scan.nextLine();
			if (input2.equals("2")) {
//				continue;
			}
			playerNum ++;
			if (playerNum == playerArr.size()) {
				playerNum = 0;
			}
		}

	}

}
