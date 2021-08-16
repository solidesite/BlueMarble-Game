package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	int count = 0;

//	public void passTurn() {
//		// 플레이어 넘기기
//		playerNum++;
//		if (playerNum == playerArr.size()) {
//			playerNum = 0;
//		}
//		System.out.println("턴넘기기" + p.name + "의 차례입니다.");
//		String al = p.name + "의 차례입니다.";
//		count = 0;
//	}

	public void start() {

		playerArr.add(new Player("플레이어1"));
		playerArr.add(new Player("플레이어2"));
		p = playerArr.get(playerNum);

		Land map[] = new Land[10];
		for (int i = 0; i < map.length; i++) {
			map[i] = new Land();
		}
		map[0].event = 0;
		map[1].event = 0;
		map[2].event = 1;
		map[3].event = 0;
		map[4].event = 0;
		map[5].event = 1;
		map[6].event = 0;
		map[7].event = 0;
		map[8].event = 1;
		map[9].event = 0;

		MyCanvas can = new MyCanvas();
		can.setLocation(150, 150);
		can.setSize(1001, 151);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Frame frame = new Frame("Blue Marble Game");
		frame.add(can);
		int frameWidth = 1300;
		int frameHeight = 700;
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(screen.width / 2 - frameWidth / 2, screen.height / 2 - frameHeight / 2);
		frame.setResizable(false);
		frame.setLayout(null);

		// 게임 타이틀
		Font font = new Font("san-serif", Font.BOLD, 30);
		JLabel title = new JLabel("BlueMarble Game");
		title.setFont(font);
		title.setLocation(frameWidth / 2 - 200, 50);
		title.setSize(400, 100);
		title.setBackground(Color.white);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setOpaque(true);
		frame.add(title);

		// 황금 열쇠 버튼
		JButton keyBtn = new JButton("황금 열쇠 열기");
		keyBtn.setLocation(700, 440);
		keyBtn.setSize(130, 150);
		keyBtn.setVisible(false);
		frame.add(keyBtn);

		// 건물 선택 버튼
		JButton buildBtn1 = new JButton("초급 건물");
		buildBtn1.setLocation(700, 440);
		buildBtn1.setSize(130, 50);
		buildBtn1.setVisible(false);
		frame.add(buildBtn1);
		JButton buildBtn2 = new JButton("중급 건물");
		buildBtn2.setLocation(700, 490);
		buildBtn2.setSize(130, 50);
		buildBtn2.setVisible(false);
		frame.add(buildBtn2);
		JButton buildBtn3 = new JButton("고급 건물");
		buildBtn3.setLocation(700, 540);
		buildBtn3.setSize(130, 50);
		buildBtn3.setVisible(false);
		frame.add(buildBtn3);

		// 스크립트 영역
		JLabel script = new JLabel("스크립트 영역");
		script.setHorizontalAlignment(JLabel.CENTER);
		script.setLocation(200, 430);
		script.setSize(640, 170);
		script.setOpaque(true);
		frame.add(script);

		// 주사위버튼
		JButton diceBtn = new JButton("주사위 던지기");
		diceBtn.setLocation(850, 400);
		diceBtn.setSize(200, 60);
		frame.add(diceBtn);

		// 건물 매입 버튼
		JButton buyBtn = new JButton("건물 매입");
		buyBtn.setLocation(850, 470);
		buyBtn.setSize(200, 60);
		buyBtn.setVisible(false);
		frame.add(buyBtn);

		// 턴 넘기기 버튼
		JButton passBtn = new JButton("턴 넘기기");
		passBtn.setLocation(850, 540);
		passBtn.setSize(200, 60);
		passBtn.setVisible(false);
		frame.add(passBtn);

		frame.setVisible(true);

		// 닫기 버튼
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		script.setText(p.name + "의 차례입니다");

		// money 영역
		JLabel moneyDis = new JLabel(p.name + "재산 : " + p.money);
		moneyDis.setLocation(200, 400);
		moneyDis.setBackground(Color.gray);
		moneyDis.setForeground(Color.white);
		moneyDis.setSize(640, 30);
		moneyDis.setOpaque(true);
		moneyDis.setHorizontalAlignment(JLabel.CENTER);
		frame.add(moneyDis);

		// 주사위 버튼 이벤트
		diceBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				Random rd = new Random();
				int dice = rd.nextInt(3) + 1;
				p.pos += dice;

				can.move(dice);
				int left = p.pos - 10;
				if (p.pos > 9) {
					p.pos = 0;
					p.pos += left;
					p.money += 2000;
					moneyDis.setText(p.name + "재산 : " + p.money + " -- 종점 터치 보너스 2000$");
				}
				diceBtn.setVisible(false);
				passBtn.setVisible(true);
				buyBtn.setVisible(true);
				if (map[p.pos].event == 1) {
					// 황금열쇠 이벤트
					keyBtn.setVisible(true);
					script.setText("<< 황금열쇠 이벤트 발생>>");

				}
			}
		});

		keyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rd2 = new Random();
				int randomE = rd2.nextInt(3);
				p = playerArr.get(playerNum);
				if (randomE == 0) {
					script.setText("당신은 주차위반을 하여 벌금 1000$를 지불했습니다.");
					p.money -= 1000;
					moneyDis.setText(p.name + "재산 : " + p.money);
				} else if (randomE == 1) {
					script.setText("당신은 대회에서 입상하여 상금 1000$를 얻었습니다.");
					p.money += 1000;
					moneyDis.setText(p.name + "재산 : " + p.money);
				} else if (randomE == 2) {
					script.setText("당신은 로또에 당첨되어 5000$를 얻었습니다.");
					p.money += 5000;
					moneyDis.setText(p.name + "재산 : " + p.money);
				}
				keyBtn.setVisible(false);
			}
		});

		// 건물 매입 버튼 이벤트
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.hasBuilding == true) {
					script.setText("건물을 이미 매입했습니다.");
					buyBtn.setVisible(false);
				} else {
					script.setText(
							"<html>건물을 매입합니다. <br/><br/> 초급 건물 : 4000$ <br/> 중급 건물 : 6000$<br/>고급 건물 : 10000$<html/>");
					buildBtn1.setVisible(true);
					buildBtn2.setVisible(true);
					buildBtn3.setVisible(true);
				}
			}
		});
		// 건물 선택 버튼 이벤트
		buildBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.money < buildingPrice1) {
					script.setText("구매 할 수 없습니다.");
				} else {
					script.setText("초급 건물을 구매했습니다.");
					can.build(playerNum,1);
					p.money -= buildingPrice1;
					p.hasBuilding = true;
					moneyDis.setText(p.name + "재산 : " + p.money);
					buildBtn1.setVisible(false);
					buildBtn2.setVisible(false);
					buildBtn3.setVisible(false);
				}
			}
		});
		buildBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.money < buildingPrice2) {
					script.setText("구매 할 수 없습니다.");
				} else {
					script.setText("중급 건물을 구매했습니다.");
					can.build(playerNum,2);
					p.money -= buildingPrice2;
					p.hasBuilding = true;
					moneyDis.setText(p.name + "재산 : " + p.money);
					buildBtn1.setVisible(false);
					buildBtn2.setVisible(false);
					buildBtn3.setVisible(false);
				}
			}
		});
		buildBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.money < buildingPrice3) {
					script.setText("구매 할 수 없습니다.");
				} else {
					script.setText("고급 건물을 구매했습니다.");
					can.build(playerNum,3);
					p.money -= buildingPrice3;
					p.hasBuilding = true;
					moneyDis.setText(p.name + "재산 : " + p.money);
					buildBtn1.setVisible(false);
					buildBtn2.setVisible(false);
					buildBtn3.setVisible(false);
				}
			}
		});

		// 턴넘기기 버튼
		passBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				playerNum++;
				if (playerNum == playerArr.size()) {
					playerNum = 0;
				}
				p = playerArr.get(playerNum);
				System.out.println("턴넘기기" + p.name + "의 차례입니다.");
				script.setText(p.name + "의 차례입니다");
				moneyDis.setText(p.name + "재산 : " + p.money);
				diceBtn.setVisible(true);
				buyBtn.setVisible(false);
				keyBtn.setVisible(false);
				buildBtn1.setVisible(false);
				buildBtn2.setVisible(false);
				buildBtn3.setVisible(false);
			}
		});

		// land 이벤트
		if (map[p.pos].ownerIdx == -1) {

		} else if (map[p.pos].ownerIdx == playerNum) {

		} else if (map[p.pos].ownerIdx != playerNum) {

		}

//		if (map[p.pos].event == 3) {
//			System.out.println("--------------------");
//			System.out.println("-현재 위치 : " + (p.pos + 1));
//			System.out.println("매입된 땅입니다.");
//			p.money -= p.buildingExpense;
//			System.out.println(p.buildingExpense + "$를 지불했습니다.");
//			passTurn();
//			p.money += p.buildingIncome;
//			System.out.println(p.name + "님이 " + p.buildingIncome + "$를 얻었습니다.");
//			passTurn();
//		}

		// 이동 후
		if (p.money <= 0) {
			System.out.println("--------------------");
			System.out.println("파산했습니다. 게임 종료");
//			passTurn();
			System.out.println(p.name + "님이 이겼습니다.");
//				break;
		}
		////
	}
}
