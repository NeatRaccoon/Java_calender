package Racoon_Calender;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
		
		public void printMenu() {
			System.out.println("+-------------------------+");
			System.out.println("| 1. 일정 등록    ");
			System.out.println("| 2. 일정 검색");
			System.out.println("| 3. 달력 보기");
			System.out.println("| h. 도움말 q. 종료");
			System.out.println("+-------------------------+");
					}
	
		/**
		 * 
		 * @param week : 요일
		 * @return 0~6 (0=Sunday ~ 6:Saturday)
		 */
	
	
		public int parseDay(String week) {
			switch(week) {
			case "su":
				return 0;
			case "mo":
				return 1;
			case "tu":
				return 2;
			case "we":
				return 3;
			case "th":
				return 4;
			case "fr":
				return 5;
			case "sa":
				return 6;
			default:
				return 0;
						}
//			if(week.equals("su")) {return 0;}
//			else if(week.equals("mo")) {return 1;}
//			else if(week.equals("tu")) {return 2;}
//			else if(week.equals("we")) {return 3;}
//			else if(week.equals("th")) {return 4;}
//			else if(week.equals("fr")) {return 5;}
//			else if(week.equals("sa")) {return 6;}
//			else {return 0;}
					}
	
		public void runPrompt() throws ParseException {
			printMenu();
			Scanner scanner = new Scanner(System.in);
			Calender cal = new Calender();
			
			boolean isLoop = true;		
			while(isLoop) {
				System.out.println("명령 (1, 2, 3, h, q)");
				String cmd = scanner.next();
				switch(cmd) {
				case "1":
					cmdRegister(scanner, cal);
					break;
				case "2":
					cmdSearch(scanner, cal);
					break;
				case "3":
					cmdCal(scanner, cal);
					break;
				case "h":
					printMenu();
					break;
				case "q":
					isLoop = false;
					break;
				}
				
//				if(cmd.equals("1")) cmdRegister(scanner, cal);
//				else if(cmd.equals("2")) cmdSearch(scanner, cal);
//				else if(cmd.equals("3")) cmdCal(scanner, cal);
//				else if(cmd.equals("h")) printMenu();
//				else if(cmd.equals("q")) break;
			}
			System.out.println("Thank you. Bye!!");
			scanner.close();		
}
	
		private void cmdCal(Scanner s, Calender c) {
			int month = 1;
			int year = 2022;
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			year = s.nextInt();
			
			System.out.println("달을 입력하세요");
			System.out.print("MONTH> ");
			month = s.nextInt();
			
//			System.out.println("첫째 날의 요일을 입력하세요(su mo tu we th fr sa)");
//			String str_weekday = scanner.next();
//			weekday = parseDay(str_weekday);
			
			if(month > 12 || month < 1) {
				System.out.println("잘못된 입력입니다");
				return;
			}
		
			c.printCalender(year, month);
			
		}

		private void cmdSearch(Scanner s, Calender c) {
			System.out.println("[일정 검색]");
			System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
			String date = s.next();
			String plan="";
			try {
				plan = c.searchplan(date);
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("일정 검색 중 오류가 발생했습니다");
			}
			System.out.println(plan);
		}

		private void cmdRegister(Scanner s, Calender c) throws ParseException {
			System.out.println("[새 일정 등록]");
			System.out.println("날짜를 입력해주세요 (yyyy-MM-dd)");
			String date = s.next();
			String text = "";
			System.out.println("일정을 입력해주세요. (문장의 끝에 ;을 입력해주세요)");
			while(true) {
				String word = s.next();
				text += word + " ";
				if(word.endsWith(";")) {
					break;
				}
			}
			c.registerPlan(date, text);
			
		}

		public static void main(String[] args) throws ParseException {
			//앱 실행
			Prompt p = new Prompt();
			p.runPrompt();
						
		}


	}


