package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

public class MyCanvas extends Canvas {
	int posX2 = 10;

	Image buffImage;
	Graphics buffg;
	Plane plane;
	Plane plane2;
	int count = 0;

	public MyCanvas() {
		plane = new Plane(25, 0, 50, 50);
		plane2 = new Plane(25, 50, 50, 50);
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
			buffg.drawRect(0, 0, 100, 100);
			buffg.drawRect(100, 0, 100, 100);
			buffg.drawRect(200, 0, 100, 100);
			buffg.drawRect(300, 0, 100, 100);
			buffg.drawRect(400, 0, 100, 100);
			buffg.drawRect(500, 0, 100, 100);
			buffg.drawRect(600, 0, 100, 100);
			buffg.drawRect(700, 0, 100, 100);
			buffg.drawRect(800, 0, 100, 100);
			buffg.drawRect(900, 0, 100, 100);
			Image num1 = (Toolkit.getDefaultToolkit().getImage("num1.png"));
			buffg.drawImage(num1, 0, 0, 100, 100, this);
			Image num2 = (Toolkit.getDefaultToolkit().getImage("num2.png"));
			buffg.drawImage(num2, 100, 0, 100, 100, this);
			Image num3 = (Toolkit.getDefaultToolkit().getImage("num3.png"));
			buffg.drawImage(num3, 200, 0, 100, 100, this);
			Image num4 = (Toolkit.getDefaultToolkit().getImage("num4.png"));
			buffg.drawImage(num4, 300, 0, 100, 100, this);
			Image num5 = (Toolkit.getDefaultToolkit().getImage("num5.png"));
			buffg.drawImage(num5, 400, 0, 100, 100, this);
			Image num6 = (Toolkit.getDefaultToolkit().getImage("num6.png"));
			buffg.drawImage(num6, 500, 0, 100, 100, this);
			Image num7 = (Toolkit.getDefaultToolkit().getImage("num7.png"));
			buffg.drawImage(num7, 600, 0, 100, 100, this);
			Image num8 = (Toolkit.getDefaultToolkit().getImage("num8.png"));
			buffg.drawImage(num8, 700, 0, 100, 100, this);
			Image num9 = (Toolkit.getDefaultToolkit().getImage("num9.png"));
			buffg.drawImage(num9, 800, 0, 100, 100, this);
			Image num10 = (Toolkit.getDefaultToolkit().getImage("num10.png"));
			buffg.drawImage(num10, 900, 0, 100, 100, this);
			Image p1 = (Toolkit.getDefaultToolkit().getImage("airplane1.png"));
			buffg.drawImage(p1, plane.posX, plane.posY, plane.width, plane.height, this);
			Image p2 = (Toolkit.getDefaultToolkit().getImage("airplane2.png"));
			buffg.drawImage(p2, plane2.posX, plane2.posY, plane2.width, plane2.height, this);
			g.drawImage(buffImage, 0, 0, this);
		}
	}

	public void move(int moveNum) {

		if (count == 0) {
			plane.posX += 100 * moveNum;
			if (plane.posX == 1025) {
				plane.posX = 25;
			}
			if (plane.posX == 1125) {
				plane.posX = 125;
			}
			if (plane.posX == 1225) {
				plane.posX = 225;
			}
			repaint();
			count++;
		} else if (count == 1) {
			plane2.posX += 100 * moveNum;
			if (plane2.posX == 1025) {
				plane2.posX = 25;
			}
			if (plane2.posX == 1125) {
				plane2.posX = 125;
			}
			if (plane2.posX == 1225) {
				plane2.posX = 225;
			}
			repaint();
			count--;
		}
		System.out.println(plane.posX +"pos" + plane2.posX);
	}

}
