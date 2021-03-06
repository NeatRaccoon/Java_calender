package Racoon_Calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calender {
	private static int[] Max_Days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	private static int[] Leap_Max_Days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
	
	
	private HashMap <Date, String> planMap;
	
	public Calender() {
		planMap = new HashMap<Date, String>();
	}
	
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		planMap.put(date, plan);
	}
	
	public String searchplan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;
	}
	
	public boolean isLeapyear(int year) {
		if(year%4 == 0 && (year%100 != 0 || year%400 == 0)) {
			return true;
		}else{
		return false;
	}
	}
	
	public int MaxdaysofMonth(int year, int month) {
		if(isLeapyear(year)) {
			return Leap_Max_Days[month];
		}else {
		return Max_Days[month];
	}
	}
	
	
	public void printCalender(int year, int month) {
		System.out.printf("   <<%d년 %d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		//get weekday automatically
		int weekday = getWeekday(year, month, 1);
		//print blank space
		for(int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = MaxdaysofMonth(year, month);
		int count = 7 - weekday;
		int delim = (count<7) ? count : 0;
		/*
		  int delim
		  if(count<7){
		  delim = count;
		  }else{
		  delim = 0;
		  }
		*/
		
		//print first line
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d",i);
		}
		System.out.println();
		
		//print from second line to last
		count++;
		for(int i=count; i<=maxDay; i++) {
			System.out.printf("%3d",i);
			if(i%7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
//		System.out.println(" 1  2  3  4  5  6  7");
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
	
	private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		
		final int STANDARD_WEEKDAY = 4; //1970.Jan.1st = Thursday
		
		int count = 0;
		
		for(int i = syear; i < year; i++) {
			int delta = isLeapyear(i) ? 366 : 365;
			count += delta;
		}
		
		for(int i = 1; i < month; i++) {
			int delta = MaxdaysofMonth(year, i);
			count += delta;
		}
		
		count += day - 1;
				
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		
		return weekday;
	}
	
	
}
