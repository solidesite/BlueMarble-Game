package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int pos = 1;

		while (true) {
			Random rd = new Random();
			int dice = rd.nextInt(3) + 1;
			System.out.println("1���� ���� �ֻ����� ��������");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("�ֻ���" + dice);
				pos += dice;
				int left = pos-10;
				if(pos > 10) {
					pos = 0;
					pos += left;
				}
			}
			System.out.println("���� ��ġ�� : " + pos);
			System.out.println("������ �Ͻðڽ��ϱ�?");
			System.out.println("2.�� �ѱ��");
			String input2 = scan.nextLine();
			if(input2.equals("2")) {
				continue;
			}
		}
		
	}

}
