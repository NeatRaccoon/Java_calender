package Racoon_Calender;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		int a, b;
		Scanner scanner = new Scanner(System.in);
		String s1, s2;
		System.out.println("두 수를 입력해 주세요");
		s1 = scanner.next();
		s2 = scanner.next();
				
		a = Integer.parseInt(s1);
		b = Integer.parseInt(s2);
//		System.out.println(a + ", " + b);
		int c = a+b;
		System.out.println("두 수의 합은 " + c + "입니다");
	}
}
