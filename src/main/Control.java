package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Control {
	Scanner scan = new Scanner(System.in);
	Land land = new Land();
	ArrayList<Player> playerArr = new ArrayList<Player>();
	Player p;
	int playerNum = 0;
	int buildingPrice1 = 4000;
	int buildingPrice2 = 6000;
	int buildingPrice3 = 10000;

	public void passTurn() {
		// 플레이어 넘기기
		playerNum++;
		if (playerNum == playerArr.size()) {
			playerNum = 0;
		}
	}

	public void randomEvent() {
		System.out.println("--------------------");
		System.out.println("-현재 위치 : " + (p.pos + 1));
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
		map[9].event = 0;

		playerArr.add(new Player("플레이어1"));
		playerArr.add(new Player("플레이어2"));

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screen.width + "," + screen.height);
		Frame frame = new Frame("Blue Marble Game");
		int frameWidth = 1300;
		int frameHeight = 700;
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(screen.width / 2 - frameWidth / 2, screen.height / 2 - frameHeight / 2);
		frame.setResizable(false);
		frame.setLayout(null);

		// 게임 타이틀
		JLabel title = new JLabel("부루마블 게임에 어서오세요");
		title.setLocation(frameWidth / 2 - 200, 50);
		title.setSize(400, 100);
		title.setBackground(Color.white);
		title.setOpaque(true);
		frame.add(title);

		// 맵 영역
		JLabel map1 = new JLabel("1");
		map1.setLocation(100, 200);
		map1.setSize(100, 100);
		map1.setOpaque(true);
		frame.add(map1);

		JLabel map2 = new JLabel("2");
		map2.setLocation(210, 200);
		map2.setSize(100, 100);
		map2.setOpaque(true);
		frame.add(map2);

		JLabel map3 = new JLabel("3");
		map3.setLocation(330, 200);
		map3.setSize(100, 100);
		map3.setOpaque(true);
		frame.add(map3);

		JLabel map4 = new JLabel("4");
		map4.setLocation(440, 200);
		map4.setSize(100, 100);
		map4.setOpaque(true);
		frame.add(map4);

		JLabel map5 = new JLabel("5");
		map5.setLocation(550, 200);
		map5.setSize(100, 100);
		map5.setOpaque(true);
		frame.add(map5);

		JLabel map6 = new JLabel("6");
		map6.setLocation(660, 200);
		map6.setSize(100, 100);
		map6.setOpaque(true);
		frame.add(map6);

		JLabel map7 = new JLabel("7");
		map7.setLocation(770, 200);
		map7.setSize(100, 100);
		map7.setOpaque(true);
		frame.add(map7);

		JLabel map8 = new JLabel("8");
		map8.setLocation(880, 200);
		map8.setSize(100, 100);
		map8.setOpaque(true);
		frame.add(map8);

		JLabel map9 = new JLabel("9");
		map9.setLocation(990, 200);
		map9.setSize(100, 100);
		map9.setOpaque(true);
		frame.add(map9);

		JLabel map10 = new JLabel("10");
		map10.setLocation(1100, 200);
		map10.setSize(100, 100);
		map10.setOpaque(true);
		frame.add(map10);

		// 스크립트 영역
		JLabel script = new JLabel("스크립트");
		script.setLocation(200, 400);
		script.setSize(640, 200);
		script.setOpaque(true);
		frame.add(script);

		// 주사위버튼
		JButton diceBtn = new JButton("주사위 던지기");
		diceBtn.setLocation(850, 400);
		diceBtn.setSize(200, 60);
		frame.add(diceBtn);

		JButton buyBtn = new JButton("건물 매입");
		buyBtn.setLocation(850, 470);
		buyBtn.setSize(200, 60);
		frame.add(buyBtn);

		JButton passBtn = new JButton("턴 넘기기");
		passBtn.setLocation(850, 540);
		passBtn.setSize(200, 60);
		frame.add(passBtn);

		frame.setVisible(true);

		// 스크립트 영역
		DefaultListModel arr = new DefaultListModel();
		JList list = new JList(arr);
		list.setLocation(50, 50);
		list.setSize(50, 50);
		list.setVisible(true);
		JScrollPane sp = new JScrollPane(list);
		sp.setLocation(200, 400);
		sp.setSize(640, 200);

		frame.add(sp);
		frame.setVisible(true);
		
		arr.addElement("*******게임 시작*******");

		while (true) {

			p = playerArr.get(playerNum);
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			arr.addElement("********************");
			arr.addElement(p.name + "의 차례입니다.");

			// 무인도
			if (p.isolateCount == 0) {
				p.isolation = false;
			} else if (p.isolation == true) {
				System.out.println("무인도 턴이 " + p.isolateCount + "턴 남았습니다.");
				p.isolateCount--;
				passTurn();
				continue;
			}

			System.out.println("-현재 위치 : " + (p.pos + 1));
			System.out.println("-현재 재산 : " + p.money);
			System.out.println("1번을 눌러 주사위를 굴리세요");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("--------------------");
				System.out.println("      주사위 - << " + dice + " >>");
				p.pos += dice;
				int left = p.pos - 10;
				if (p.pos > 9) {
					p.pos = 0;
					p.pos += left;
					p.money += 3000;
					System.out.println("종점터치 : 2000$ 획득");
				}
			}

			// land 이벤트
			if (map[p.pos].ownerIdx == -1) {

			} else if (map[p.pos].ownerIdx == playerNum) {

			} else if (map[p.pos].ownerIdx != playerNum) {

			}

			if (map[p.pos].event == 1) {
				// 황금열쇠 이벤트
				randomEvent();
				String input2 = scan.nextLine();
			} else if (map[p.pos].event == 2) {
				// 무인도 이벤트
				System.out.println("--------------------");
				System.out.println("-현재 위치 : " + (p.pos + 1));
				System.out.println("<< 무인도 이벤트 발생 >>");
				System.out.println(p.name + "님은 무인도에 갇혔습니다.");
				p.isolation = true;
				String input2 = scan.nextLine();
				continue;
			} else if (map[p.pos].event == 3) {
				System.out.println("--------------------");
				System.out.println("-현재 위치 : " + (p.pos + 1));
				System.out.println("매입된 땅입니다.");
				p.money -= p.buildingExpense;
				System.out.println(p.buildingExpense + "$를 지불했습니다.");
				passTurn();
				p.money += p.buildingIncome;
				System.out.println(p.name + "님이 " + p.buildingIncome + "$를 얻었습니다.");
				passTurn();
			}

			// 이동 후
			if (p.money <= 0) {
				System.out.println("--------------------");
				System.out.println("파산했습니다. 게임 종료");
				passTurn();
				System.out.println(p.name + "님이 이겼습니다.");
				break;
			}
			System.out.println("--------------------");
			System.out.println("-현재 위치 : " + (p.pos + 1));
			System.out.println("-현재 재산 : " + p.money);
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("2.턴 넘기기 3.건물 매입");
			String input2 = scan.nextLine();
			if (input2.equals("2")) {

			} else if (input2.equals("3")) {
				if (p.hasBuilding == true) {
					System.out.println("건물을 이미 매입했습니다.");
				} else if (map[0].event == 3) {
					System.out.println("다른사람이 이미 매입한 땅입니다.");
				} else {
					System.out.println("--------------------");
					System.out.println("<< 건물 매입 >>");
					System.out.println("매입할 건물을 선택하십시오.");
					System.out.println("1.초급 건물 : 4000$");
					System.out.println("2.중급 건물 : 6000$");
					System.out.println("3.고급 건물 : 10000$");
					String input3 = scan.nextLine();
					if (input3.equals("1")) {
						p.buyBuilding1(buildingPrice1);
						map[p.pos].event = 3;
						passTurn();
						p.buildingExpense = buildingPrice1 / 2;
						passTurn();
					} else if (input3.equals("2")) {
						p.buyBuilding2(buildingPrice2);
						map[p.pos].event = 3;
						passTurn();
						p.buildingExpense = buildingPrice2 / 2;
						passTurn();
					} else if (input3.equals("3")) {
						p.buyBuilding3(buildingPrice3);
						map[p.pos].event = 3;
						passTurn();
						p.buildingExpense = buildingPrice3 / 2;
						passTurn();
					}
				}
			}
			passTurn();
		}
	}

}
