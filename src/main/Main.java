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
			System.out.println("1번을 눌러 주사위를 굴리세요");
			String input = scan.nextLine();
			if (input.equals("1")) {
				System.out.println("주사위" + dice);
				pos += dice;
				int left = pos-10;
				if(pos > 10) {
					pos = 0;
					pos += left;
				}
			}
			System.out.println("현재 위치는 : " + pos);
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("2.턴 넘기기");
			String input2 = scan.nextLine();
			if(input2.equals("2")) {
				continue;
			}
		}
		
	}

}
