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

	public MyCanvas() {
		plane = new Plane(25, 0, 50, 50);
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
			buffg.drawRect(0, 0, 100, 100);
			buffg.setColor(Color.gray);
			buffg.drawRect(100, 0, 100, 100);
			buffg.drawRect(200, 0, 100, 100);
			buffg.drawRect(300, 0, 100, 100);
			buffg.drawRect(400, 0, 100, 100);
			buffg.drawRect(500, 0, 100, 100);
			buffg.drawRect(600, 0, 100, 100);
			buffg.drawRect(700, 0, 100, 100);
			buffg.drawRect(800, 0, 100, 100);
			buffg.drawRect(900, 0, 100, 100);
			Image p1 = (Toolkit.getDefaultToolkit().getImage("airplane1.png"));
			buffg.drawImage(p1, plane.posX, plane.posY, plane.width, plane.height, this);
			Image p2 = (Toolkit.getDefaultToolkit().getImage("airplane2.png"));
			buffg.drawImage(p2, 25, 50, 50, 50, this);
			g.drawImage(buffImage, 0, 0, this);
		}
	}

	public void move(int moveNum) {
		plane.posX += 100 * moveNum;
		repaint();
		if (plane.posX > 900) {
			plane.posX = 25;
		}
	}

}
