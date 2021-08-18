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

	public void start() {

		playerArr.add(new Player("�÷��̾�1"));
		playerArr.add(new Player("�÷��̾�2"));
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

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Frame frame = new Frame("Blue Marble Game");

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

		// �Ļ� ����
		JLabel bankrupt = new JLabel("�Ļ�");
		Font font2 = new Font("serif", Font.BOLD, 50);
		bankrupt.setFont(font2);
		bankrupt.setBackground(Color.black);
		bankrupt.setForeground(Color.red);
		bankrupt.setHorizontalAlignment(JLabel.CENTER);
		bankrupt.setLocation(980, 400);
		bankrupt.setSize(170, 200);
		bankrupt.setOpaque(true);
		bankrupt.setVisible(false);
		frame.add(bankrupt);

		MyCanvas can = new MyCanvas();
		can.setLocation(150, 150);
		can.setSize(1001, 151);
		frame.add(can);

		// Ȳ�� ���� ��ư
		JButton keyBtn = new JButton("Ȳ�� ���� ����");
		keyBtn.setLocation(830, 440);
		keyBtn.setSize(130, 150);
		keyBtn.setVisible(false);
		frame.add(keyBtn);

		// �ǹ� ���� ��ư
		JButton buildBtn1 = new JButton("�ʱ� �ǹ�");
		buildBtn1.setLocation(830, 440);
		buildBtn1.setSize(130, 50);
		buildBtn1.setVisible(false);
		frame.add(buildBtn1);
		JButton buildBtn2 = new JButton("�߱� �ǹ�");
		buildBtn2.setLocation(830, 490);
		buildBtn2.setSize(130, 50);
		buildBtn2.setVisible(false);
		frame.add(buildBtn2);
		JButton buildBtn3 = new JButton("��� �ǹ�");
		buildBtn3.setLocation(830, 540);
		buildBtn3.setSize(130, 50);
		buildBtn3.setVisible(false);
		frame.add(buildBtn3);

		// ��ũ��Ʈ ����
		JLabel script = new JLabel("��ũ��Ʈ ����");
		script.setHorizontalAlignment(JLabel.CENTER);
		script.setLocation(330, 430);
		script.setSize(640, 170);
		script.setOpaque(true);
		frame.add(script);

		// �ֻ��� ���� Ÿ��Ʋ
		JLabel diceTitle = new JLabel("�ֻ���");
		diceTitle.setLocation(150, 400);
		diceTitle.setBackground(Color.gray);
		diceTitle.setForeground(Color.white);
		diceTitle.setSize(170, 30);
		diceTitle.setOpaque(true);
		diceTitle.setHorizontalAlignment(JLabel.CENTER);
		frame.add(diceTitle);

		// �ֻ��� ����
		Font font3 = new Font("���� ���", Font.BOLD, 50);
		JLabel diceDis = new JLabel("0");
		diceDis.setHorizontalAlignment(JLabel.CENTER);
		diceDis.setFont(font3);
		diceDis.setLocation(150, 430);
		diceDis.setSize(170, 170);
		diceDis.setOpaque(true);
		frame.add(diceDis);

		// �ֻ�����ư
		JButton diceBtn = new JButton("�ֻ��� ������");
		diceBtn.setLocation(980, 400);
		diceBtn.setSize(170, 60);
		frame.add(diceBtn);

		// �ǹ� ���� ��ư
		JButton buyBtn = new JButton("�ǹ� ����");
		buyBtn.setLocation(980, 470);
		buyBtn.setSize(170, 60);
		buyBtn.setVisible(false);
		frame.add(buyBtn);

		// �� �ѱ�� ��ư
		JButton passBtn = new JButton("�� �ѱ��");
		passBtn.setLocation(980, 540);
		passBtn.setSize(170, 60);
		passBtn.setVisible(false);
		frame.add(passBtn);

		frame.setVisible(true);

		// �ݱ� ��ư
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		script.setText(p.name + "�� �����Դϴ�");

		// money ����
		JLabel moneyDis = new JLabel(p.name + "��� : " + p.money);
		moneyDis.setLocation(frameWidth / 2 - 320, 400);
		moneyDis.setBackground(Color.gray);
		moneyDis.setForeground(Color.white);
		moneyDis.setSize(640, 30);
		moneyDis.setOpaque(true);
		moneyDis.setHorizontalAlignment(JLabel.CENTER);
		frame.add(moneyDis);

		// �ֻ��� ��ư �̺�Ʈ
		diceBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				Random rd = new Random();
				int dice = rd.nextInt(3) + 1;
				p.pos += dice;
				String change = Integer.toString(dice);
				diceDis.setText(change);

				can.move(dice);
				int left = p.pos - 10;
				if (p.pos > 9) {
					p.pos = 0;
					p.pos += left;
					p.money += 2000;
					moneyDis.setText(p.name + "��� : " + p.money + " -- ���� ��ġ ���ʽ� 2000$");
				}
				diceBtn.setVisible(false);
				passBtn.setVisible(true);
				buyBtn.setVisible(true);
				if (map[p.pos].event == 1) {
					// Ȳ�ݿ��� �̺�Ʈ
					keyBtn.setVisible(true);
					script.setText("<< Ȳ�ݿ��� �̺�Ʈ �߻�>>");

				} else if (map[p.pos].ownerIdx == playerNum || map[p.pos].ownerIdx == -1) {

				} else if (map[p.pos].ownerIdx != playerNum) {
					p.money -= p.buildingExpense;
					passTurn();
					p = playerArr.get(playerNum);
					p.money += p.buildingIncome;
					passTurn();
					p = playerArr.get(playerNum);
					script.setText("<html>�ٸ� ����� ������ �����Դϴ�.<br/><html/>" + p.buildingExpense + "���� �����߽��ϴ�.");
					moneyDis.setText(p.name + "��� : " + p.money);
				}
				if (p.money <= 0) {
					passTurn();
					p = playerArr.get(playerNum);
					script.setText("<html>���� ����<br/><html/>" + p.name + "���� �̰���ϴ�.");
					bankrupt.setVisible(true);
					diceBtn.setVisible(false);
					passBtn.setVisible(false);
					buyBtn.setVisible(false);
					keyBtn.setVisible(false);
				}
			}
		});

		keyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rd2 = new Random();
				int randomE = rd2.nextInt(6);
				p = playerArr.get(playerNum);
				if (randomE == 0) {
					script.setText("<html>����� ���������� �߽��ϴ�.<br/>���� 2000$�� �����߽��ϴ�.<html/>");
					p.money -= 2000;
					moneyDis.setText(p.name + "��� : " + p.money);
				} else if (randomE == 1) {
					script.setText("<html>����� ��ȸ���� �Ի��߽��ϴ�.<br/>��� 1000$�� ������ϴ�.<html/>");
					p.money += 1000;
					moneyDis.setText(p.name + "��� : " + p.money);
				} else if (randomE == 2) {
					script.setText("<html>����� �ζǿ� ��÷�Ǿ����ϴ�.<br/>4000$�� ������ϴ�.<html/>");
					p.money += 4000;
					moneyDis.setText(p.name + "��� : " + p.money);
				} else if (randomE == 3) {
					script.setText("<html>����� ���۽��� ���� ���⿡ �´ڶ߷Ƚ��ϴ�.<br/>5000$�� �Ҿ����ϴ�..<html/>");
					p.money -= 5000;
					moneyDis.setText(p.name + "��� : " + p.money);
				} else if (randomE == 4) {
					script.setText("<html>����� �������� ���� ������ �����߽��ϴ�.<br/>3000$�� �����߽��ϴ�.<html/>");
					p.money -= 3000;
					moneyDis.setText(p.name + "��� : " + p.money);
				} else if (randomE == 5) {
					script.setText("<html>����� ���б��� �޾ҽ��ϴ�.<br/>1000$�� ������ϴ�.<html/>");
					p.money += 1000;
					moneyDis.setText(p.name + "��� : " + p.money);
				}
				keyBtn.setVisible(false);
				if (p.money <= 0) {
					passTurn();
					p = playerArr.get(playerNum);
					script.setText("<html>���� ����<br/><html/>" + p.name + "���� �̰���ϴ�.");
					bankrupt.setVisible(true);
					diceBtn.setVisible(false);
					passBtn.setVisible(false);
					buyBtn.setVisible(false);
					keyBtn.setVisible(false);
				}
			}
		});

		// �ǹ� ���� ��ư �̺�Ʈ
		buyBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.hasBuilding == true) {
					script.setText("�ǹ��� �̹� �����߽��ϴ�.");
					buyBtn.setVisible(false);
				} else if (map[p.pos].ownerIdx != -1) {
					script.setText("���� �� �� �����ϴ�.");
				} else if (map[p.pos].event == 1) {
					script.setText("���� �� �� �����ϴ�.");
				} else {
					script.setText(
							"<html>�ǹ��� �����մϴ�. <br/><br/> �ʱ� �ǹ� : 4000$ <br/> �߱� �ǹ� : 6000$<br/>��� �ǹ� : 10000$<html/>");
					buildBtn1.setVisible(true);
					buildBtn2.setVisible(true);
					buildBtn3.setVisible(true);
				}
			}
		});
		// �ǹ� ���� ��ư �̺�Ʈ
		buildBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.money < buildingPrice1) {
					script.setText("���� �� �� �����ϴ�.");
				} else {
					script.setText("�ʱ� �ǹ��� �����߽��ϴ�.");
					can.build(playerNum, 1);
					p.money -= buildingPrice1;
					p.hasBuilding = true;
					p.buildingIncome = buildingPrice1 / 2;
					passTurn();
					p = playerArr.get(playerNum);
					p.buildingExpense = buildingPrice1 / 2;
					passTurn();
					p = playerArr.get(playerNum);
					map[p.pos].ownerIdx = playerNum;
					moneyDis.setText(p.name + "��� : " + p.money);
					buildBtn1.setVisible(false);
					buildBtn2.setVisible(false);
					buildBtn3.setVisible(false);
				}
				if (p.money <= 0) {
					passTurn();
					p = playerArr.get(playerNum);
					script.setText("<html>���� ����<br/><html/>" + p.name + "���� �̰���ϴ�.");
					bankrupt.setVisible(true);
					diceBtn.setVisible(false);
					passBtn.setVisible(false);
					buyBtn.setVisible(false);
					keyBtn.setVisible(false);
				}
			}
		});
		buildBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.money < buildingPrice2) {
					script.setText("���� �� �� �����ϴ�.");
				} else {
					script.setText("�߱� �ǹ��� �����߽��ϴ�.");
					can.build(playerNum, 2);
					p.money -= buildingPrice2;
					p.hasBuilding = true;
					p.buildingIncome = buildingPrice2 / 2;
					passTurn();
					p = playerArr.get(playerNum);
					p.buildingExpense = buildingPrice2 / 2;
					passTurn();
					p = playerArr.get(playerNum);
					map[p.pos].ownerIdx = playerNum;
					moneyDis.setText(p.name + "��� : " + p.money);
					buildBtn1.setVisible(false);
					buildBtn2.setVisible(false);
					buildBtn3.setVisible(false);
				}
				if (p.money <= 0) {
					passTurn();
					p = playerArr.get(playerNum);
					script.setText("<html>���� ����<br/><html/>" + p.name + "���� �̰���ϴ�.");
					bankrupt.setVisible(true);
					diceBtn.setVisible(false);
					passBtn.setVisible(false);
					buyBtn.setVisible(false);
					keyBtn.setVisible(false);
				}
			}
		});
		buildBtn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				if (p.money < buildingPrice3) {
					script.setText("���� �� �� �����ϴ�.");
				} else {
					script.setText("��� �ǹ��� �����߽��ϴ�.");
					can.build(playerNum, 3);
					p.money -= buildingPrice3;
					p.hasBuilding = true;
					p.buildingIncome = buildingPrice3 / 2;
					passTurn();
					p = playerArr.get(playerNum);
					p.buildingExpense = buildingPrice3 / 2;
					passTurn();
					p = playerArr.get(playerNum);
					map[p.pos].ownerIdx = playerNum;

					moneyDis.setText(p.name + "��� : " + p.money);
					buildBtn1.setVisible(false);
					buildBtn2.setVisible(false);
					buildBtn3.setVisible(false);
				}
				if (p.money <= 0) {
					passTurn();
					p = playerArr.get(playerNum);
					script.setText("<html>���� ����<br/><html/>" + p.name + "���� �̰���ϴ�.");
					bankrupt.setVisible(true);
					diceBtn.setVisible(false);
					passBtn.setVisible(false);
					buyBtn.setVisible(false);
					keyBtn.setVisible(false);
				}
			}
		});

		// �ϳѱ�� ��ư
		passBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = playerArr.get(playerNum);
				playerNum++;
				if (playerNum == playerArr.size()) {
					playerNum = 0;
				}
				p = playerArr.get(playerNum);
				script.setText(p.name + "�� �����Դϴ�");
				moneyDis.setText(p.name + "��� : " + p.money);
				diceBtn.setVisible(true);
				buyBtn.setVisible(false);
				keyBtn.setVisible(false);
				buildBtn1.setVisible(false);
				buildBtn2.setVisible(false);
				buildBtn3.setVisible(false);
				passBtn.setVisible(false);
			}
		});
	}
}
