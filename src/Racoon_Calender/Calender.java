package Racoon_Calender;

import java.util.Scanner;

public class Calender {
	private static int[] Max_Days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	private static int[] Leap_Max_Days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	
	public boolean isLeapyear(int year) {
		if(year%4 == 0 && (year%100 != 0 || year%400 == 0)) {
			return true;
		}else{
		return false;
	}
	}
	
	public int MaxdaysofMonth(int year, int month) {
		if(isLeapyear(year)) {
			return Leap_Max_Days[month - 1];
		}else {
		return Max_Days[month - 1];
	}
	}
	/**
	 * - 월을 입력하면 해당 월의 달력을 출력한다
	 * - 달력의 모양은 1단계에서 작성한 모양으로 만든다 
	 * - 1일은 일요일도 정해도 무방하다
	 * - -1을 입력받기 전까지 반복 입력받는다
	 * - 프롬프트를 출력한다
	 */
	
	
	public void printCalender(int year, int month) {
		System.out.printf("   <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int maxDay = MaxdaysofMonth(year, month);
		
		for(int i=1; i<=maxDay; i++) {
			System.out.printf("%3d", i);
			if(i%7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
	
	
}
