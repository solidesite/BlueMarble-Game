package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

public class MyCanvas extends Canvas {
	Image buffImage;
	Graphics buffg;
	Player player1;
	Player player2;
	int count = 0;

	int bposX1 = -100;
	int bposX2 = -100;
	int bposX3 = -100;
	int bposX4 = -100;
	int bposX5 = -100;
	int bposX6 = -100;
//	int bposY = 0;

	public MyCanvas() {
		player1 = new Player(25, 50, 50, 50);
		player2 = new Player(25, 100, 50, 50);
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		if (buffg == null) {
			buffImage = createImage(getWidth(), getHeight());
			if (buffImage == null) {
				System.out.println("오프 스크린 생성 실패");
			} else {
				buffg = buffImage.getGraphics();
			}
		}
		update(g);
	}

	@Override
	public void update(Graphics g) {
		if (buffg != null) {
			buffg.setColor(Color.white);
			buffg.fillRect(0, 0, getWidth(), getHeight());

			buffg.setColor(Color.gray);
			buffg.drawRect(0, 50, 100, 100);
			buffg.drawRect(100, 50, 100, 100);
			buffg.drawRect(200, 50, 100, 100);
			buffg.drawRect(300, 50, 100, 100);
			buffg.drawRect(400, 50, 100, 100);
			buffg.drawRect(500, 50, 100, 100);
			buffg.drawRect(600, 50, 100, 100);
			buffg.drawRect(700, 50, 100, 100);
			buffg.drawRect(800, 50, 100, 100);
			buffg.drawRect(900, 50, 100, 100);
			Image num1 = (Toolkit.getDefaultToolkit().getImage("num1.png"));
			buffg.drawImage(num1, 0, 50, 100, 100, this);
			Image num2 = (Toolkit.getDefaultToolkit().getImage("num2.png"));
			buffg.drawImage(num2, 100, 50, 100, 100, this);
			Image num3 = (Toolkit.getDefaultToolkit().getImage("num3.png"));
			buffg.drawImage(num3, 200, 50, 100, 100, this);
			Image num4 = (Toolkit.getDefaultToolkit().getImage("num4.png"));
			buffg.drawImage(num4, 300, 50, 100, 100, this);
			Image num5 = (Toolkit.getDefaultToolkit().getImage("num5.png"));
			buffg.drawImage(num5, 400, 50, 100, 100, this);
			Image num6 = (Toolkit.getDefaultToolkit().getImage("num6.png"));
			buffg.drawImage(num6, 500, 50, 100, 100, this);
			Image num7 = (Toolkit.getDefaultToolkit().getImage("num7.png"));
			buffg.drawImage(num7, 600, 50, 100, 100, this);
			Image num8 = (Toolkit.getDefaultToolkit().getImage("num8.png"));
			buffg.drawImage(num8, 700, 50, 100, 100, this);
			Image num9 = (Toolkit.getDefaultToolkit().getImage("num9.png"));
			buffg.drawImage(num9, 800, 50, 100, 100, this);
			Image num10 = (Toolkit.getDefaultToolkit().getImage("num10.png"));
			buffg.drawImage(num10, 900, 50, 100, 100, this);
			Image p1 = (Toolkit.getDefaultToolkit().getImage("airplane1.png"));
			buffg.drawImage(p1, player1.pos, player1.posY, player1.width, player1.height, this);
			Image p2 = (Toolkit.getDefaultToolkit().getImage("airplane2.png"));
			buffg.drawImage(p2, player2.pos, player2.posY, player2.width, player2.height, this);
			Image building1P1 = (Toolkit.getDefaultToolkit().getImage("p1_b1.png"));
			buffg.drawImage(building1P1, bposX1, 0, 50, 50, this);
			Image building2P1 = (Toolkit.getDefaultToolkit().getImage("p1_b2.png"));
			buffg.drawImage(building2P1, bposX2, 0, 50, 50, this);
			Image building3P1 = (Toolkit.getDefaultToolkit().getImage("p1_b3.png"));
			buffg.drawImage(building3P1, bposX3, 0, 50, 50, this);
			Image building1P2 = (Toolkit.getDefaultToolkit().getImage("p2_b1.png"));
			buffg.drawImage(building1P2, bposX4, 0, 50, 50, this);
			Image building2P2 = (Toolkit.getDefaultToolkit().getImage("p2_b2.png"));
			buffg.drawImage(building2P2, bposX5, 0, 50, 50, this);
			Image building3P2 = (Toolkit.getDefaultToolkit().getImage("p2_b3.png"));
			buffg.drawImage(building3P2, bposX6, 0, 50, 50, this);
			g.drawImage(buffImage, 0, 0, this);
		}
	}

	public void build(int playerNum, int buildingNum) {
		if (playerNum == 0) {
			if (buildingNum == 1) {
				bposX1 = player1.pos;
			} else if (buildingNum == 2) {
				bposX2 = player1.pos;
			} else if (buildingNum == 3) {
				bposX3 = player1.pos;
			}
			repaint();
		} else if (playerNum == 1) {
			if (buildingNum == 1) {
				bposX4 = player2.pos;
			} else if (buildingNum == 2) {
				bposX5 = player2.pos;
			} else if (buildingNum == 3) {
				bposX6 = player2.pos;
			}
			repaint();
		}
	}

	public void move(int moveNum) {
		if (count == 0) {
			player1.pos += 100 * moveNum;
			if (player1.pos == 1025) {
				player1.pos = 25;
			}
			if (player1.pos == 1125) {
				player1.pos = 125;
			}
			if (player1.pos == 1225) {
				player1.pos = 225;
			}
			repaint();
			count++;
		} else if (count == 1) {
			player2.pos += 100 * moveNum;
			if (player2.pos == 1025) {
				player2.pos = 25;
			}
			if (player2.pos == 1125) {
				player2.pos = 125;
			}
			if (player2.pos == 1225) {
				player2.pos = 225;
			}
			repaint();
			count--;
		}
	}
}
