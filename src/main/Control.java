package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Control {
	Scanner scan = new Scanner(System.in);
	Land land = new Land();
	ArrayList<Player> playerArr = new ArrayList<Player>();
	Player p;

	public void randomEvent() {
		System.out.println("--------------------");
		System.out.println("-현재 위치 : " + p.pos);
		System.out.println("-현재 재산 : " + p.money);
		System.out.println("<< 황금열쇠 이벤트 발생 >>");
		System.out.println("1번을 눌러 주사위를 굴리세요");
		String input = scan.nextLine();
		Random rd = new Random();
		int randomE = rd.nextInt(3);
		if (input.equals("1")) {
			if (randomE == 0) {
				System.out.println("당신은 주차위반을 하여 벌금을 냈습니다.");
				System.out.println("1000$를 지불했습니다.");
				p.money -= 1000;
			} else if (randomE == 1) {
				System.out.println("당신은 대회에 입상하여 상금을 얻었습니다.");
				System.out.println("1000$를 얻었습니다.");
				p.money += 1000;
			} else if (randomE == 2) {
				System.out.println("당신은 로또에 당첨되었습니다.");
				System.out.println("5000$를 얻었습니다.");
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
		map[9].event = 1;

		playerArr.add(new Player("플레이어1"));
		playerArr.add(new Player("플레이어2"));

		int playerNum = 0;

		while (true) {
			p = playerArr.get(playerNum);
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			System.out.println("--------------------");
			System.out.println(p.name + "의 차례입니다.");

			// 무인도
			if (p.isolateCount == 0) {
				p.isolation = false;
			}
			if (p.isolation == true) {
				System.out.println("무인도 턴이 " + p.isolateCount + "턴 남았습니다.");
				p.isolateCount--;
				playerNum++;
				if (playerNum == playerArr.size()) {
					playerNum = 0;
				}
				continue;
			}

			System.out.println("-현재 위치 : " + p.pos);
			System.out.println("-현재 재산 : " + p.money);
			System.out.println("1번을 눌러 주사위를 굴리세요");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("--------------------");
				System.out.println("      주사위 - << " + dice + " >>");
				p.pos += dice;
				int left = p.pos - 10;
				if (p.pos > 10) {
					p.pos = 0;
					p.pos += left;
					p.money += 3000;
					System.out.println("종점터치 : 2000$ 획득");
				}
			}

			// land 이벤트
			if (map[p.pos].event == 1) {
				// 황금열쇠 이벤트
				randomEvent();
			} else if (map[p.pos].event == 2) {
				// 무인도 이벤트
				System.out.println("--------------------");
				System.out.println("-현재 위치 : " + p.pos);
				System.out.println("<< 무인도 이벤트 발생 >>");
				System.out.println(p.name + "님은 무인도에 갇혔습니다.");
				p.isolation = true;
				continue;
			}

			// 이동 후

			if (p.money <= 0) {
				System.out.println("파산했습니다. 게임 종료");
				break;
			}
			System.out.println("--------------------");
			System.out.println("-현재 위치 : " + p.pos);
			System.out.println("-현재 재산 : " + p.money);
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("2.턴 넘기기");
			String input2 = scan.nextLine();
			if (input2.equals("2")) {
//				continue;
			}

			// 플레이어 넘기기
			playerNum++;
			if (playerNum == playerArr.size()) {
				playerNum = 0;
			}
		}
	}

}
