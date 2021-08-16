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
		
		MyCanvas can = new MyCanvas();
		can.setLocation(100, 200);
		can.setSize(1001, 101);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(screen.width + "," + screen.height);
		Frame frame = new Frame("Blue Marble Game");
		frame.add(can);
		int frameWidth = 1300;
		int frameHeight = 700;
		frame.setSize(frameWidth, frameHeight);
		frame.setLocation(screen.width / 2 - frameWidth / 2, screen.height / 2 - frameHeight / 2);
		frame.setResizable(false);
		frame.setLayout(null);
		

		// ���� Ÿ��Ʋ
		Font font = new Font("san-serif", Font.BOLD, 30);
		JLabel title = new JLabel("BlueMarble Game");
		title.setFont(font);
		title.setLocation(frameWidth / 2 - 200, 50);
		title.setSize(400, 100);
		title.setBackground(Color.white);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setOpaque(true);
		frame.add(title);

		// ��ũ��Ʈ ����
		JLabel script = new JLabel("��ũ��Ʈ ����");
		script.setHorizontalAlignment(JLabel.CENTER);
		script.setLocation(200, 430);
		script.setSize(640, 170);
		script.setOpaque(true);
		frame.add(script);

		// �ֻ�����ư
		JButton diceBtn = new JButton("�ֻ��� ������");
		diceBtn.setLocation(850, 400);
		diceBtn.setSize(200, 60);
		frame.add(diceBtn);

		JButton buyBtn = new JButton("�ǹ� ����");
		buyBtn.setLocation(850, 470);
		buyBtn.setSize(200, 60);
		frame.add(buyBtn);

		JButton passBtn = new JButton("�� �ѱ��");
		passBtn.setLocation(850, 540);
		passBtn.setSize(200, 60);
		frame.add(passBtn);

		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		while (true) {
			p = playerArr.get(playerNum);
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			script.setText(p.name + "�� �����Դϴ�");

			// money ����
			JLabel moneyDis = new JLabel(p.name + "��� : " + p.money);
			moneyDis.setLocation(200, 400);
			moneyDis.setBackground(Color.gray);
			moneyDis.setForeground(Color.white);
			moneyDis.setSize(640, 30);
			moneyDis.setOpaque(true);
			moneyDis.setHorizontalAlignment(JLabel.CENTER);
			frame.add(moneyDis);

			// ���ε�
			if (p.isolateCount == 0) {
				p.isolation = false;
			} else if (p.isolation == true) {
				System.out.println("���ε� ���� " + p.isolateCount + "�� ���ҽ��ϴ�.");
				p.isolateCount--;
				passTurn();
				continue;
			}

			// �ֻ��� Ŭ�� �̺�Ʈ
			diceBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					p.pos += dice;
					can.move(dice);
					int left = p.pos - 10;
					if (p.pos > 9) {
						p.pos = 0;
						p.pos += left;
						p.money += 3000;
						script.setText("������ġ : 2000$ ȹ��");
					}
				}
			});

			// land �̺�Ʈ
			if (map[p.pos].ownerIdx == -1) {

			} else if (map[p.pos].ownerIdx == playerNum) {

			} else if (map[p.pos].ownerIdx != playerNum) {

			}

			if (map[p.pos].event == 1) {
				// Ȳ�ݿ��� �̺�Ʈ
				randomEvent();
				String input2 = scan.nextLine();
			} else if (map[p.pos].event == 2) {
				// ���ε� �̺�Ʈ
				System.out.println("--------------------");
				System.out.println("-���� ��ġ : " + (p.pos + 1));
				System.out.println("<< ���ε� �̺�Ʈ �߻� >>");
				System.out.println(p.name + "���� ���ε��� �������ϴ�.");
				p.isolation = true;
				String input2 = scan.nextLine();
				continue;
			} else if (map[p.pos].event == 3) {
				System.out.println("--------------------");
				System.out.println("-���� ��ġ : " + (p.pos + 1));
				System.out.println("���Ե� ���Դϴ�.");
				p.money -= p.buildingExpense;
				System.out.println(p.buildingExpense + "$�� �����߽��ϴ�.");
				passTurn();
				p.money += p.buildingIncome;
				System.out.println(p.name + "���� " + p.buildingIncome + "$�� ������ϴ�.");
				passTurn();
			}

			// �̵� ��
			if (p.money <= 0) {
				System.out.println("--------------------");
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
					System.out.println("3.��� �ǹ� : 10000$");
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
