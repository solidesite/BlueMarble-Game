package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Player> playerArr = new ArrayList<Player>();
		playerArr.add(new Player ("플레이어1"));
		playerArr.add(new Player ("플레이어2"));
		Player p;
		int playerNum = 0;

		while (true) {
			p = playerArr.get(playerNum);
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			System.out.println(p.name + "의 차례입니다.");
			System.out.println("현재 위치 : " + p.pos);
			System.out.println("현재 재산 : " + p.money);
			System.out.println("1번을 눌러 주사위를 굴리세요");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("주사위 - <" + dice + ">");
				p.pos += dice;
				int left = p.pos - 10;
				if (p.pos > 10) {
					p.pos = 0;
					p.pos += left;
					p.money += 3000;
					System.out.println("종점터치 : 2000$ 획득");
				}
			}
			System.out.println("현재 위치 : " + p.pos);
			System.out.println("현재 재산 : " + p.money);
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("2.턴 넘기기");
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
