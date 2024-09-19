package package1;

import java.util.Scanner;
public class MenuManager {
	public final static int LOGIN = 1;
	public final static int EXIT = 2;
	public final static int ADDRESS_SEARCH = 1;
	public final static int ALL_ADDRESS_SEARCH = 2;
	public final static int LOGOUT = 3;

	public MenuManager() {
		
	}

	public void firstMenu() {
		System.out.println("<< 주소록 관리 >>");
		System.out.println("1. 로그인");
		System.out.println("2. 종료");
	}

	public void secondMenu() {
		System.out.println("<< 주소록 관리 >>");
		System.out.println("1. 주소록 검색");
		System.out.println("2. 전체 주소록 검색");
		System.out.println("3. 로그아웃");

	}

	public int selectFirstMenu() {
		Scanner input = new Scanner(System.in);
		int select;
		while (true) {
			select = input.nextInt();
			input.nextLine();
			if (select < LOGIN || select > EXIT) {
				System.out.println("메뉴 선택이 잘못 되었습니다.");
				continue;
			}
			break;
		}
		return select;
	}

	public int selectSecondMenu() {
		Scanner input = new Scanner(System.in);
		int select;
		while (true) {
			select = input.nextInt();
			input.nextLine();
			if (select < ADDRESS_SEARCH || select > LOGOUT) {
				System.out.println("메뉴 선택이 잘못 되었습니다.");
				continue;
			}
			break;
		}
		return select;

	}
}
