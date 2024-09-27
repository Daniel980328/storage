package package1;

import java.util.Scanner;

public class BookMarketManager {
	private Book[] mBook=null;
	private Cart cart=null;
	public Person user = null;

	public BookMarketManager() {
		mBook = new Book[3];
		mBook[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000,
					"송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서","2018/10/08");

		mBook[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000,
					"우재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22");

		mBook[2] = new Book("ISBN1236", "스크래치", 22000,
					"고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10");
		this.cart=new Cart();

	}

	

	public void booklist() {
	
	

		for (int i = 0; i < mBook.length; i++) {
			System.out.print("도서 ID: ");
			System.out.println(mBook[i].getBookId());
			System.out.print("도서 이름: ");
			System.out.println(mBook[i].getBookName());
			System.out.print("도서 가격: ");
			System.out.println(mBook[i].getPrice());
			System.out.print("저자: ");
			System.out.println(mBook[i].getAuthor());
			System.out.print("도서 설명");
			System.out.println(mBook[i].getDescription());
			System.out.print("도서 분류: ");
			System.out.println(mBook[i].getCategory());
			System.out.print("출판일: ");
			System.out.println(mBook[i].getReleaseDate());
			System.out.println("==========================================");
		}

	}

	public void menuIntroduction() {
		System.out.println("*****************************************");
		System.out.println("\t Welcome to Shopping mall");
		System.out.println("\t Welcome to Book Market!");
		System.out.println("*****************************************");
		System.out.println("1. 고객정보확인하기\t\t6. 장바구니의 항목 삭제하기");
		System.out.println("2. 장바구니 상품 목록 보기\t7. 영수증 표시하기");
		System.out.println("3. 장바구니 비우기\t\t8. 관리자 계정 불러오기");
		System.out.println("4. 바구니에 항목추가하기\t9. 종료");
		System.out.println("5. 장바구니에 항목 수량 줄이기");
		System.out.println("*****************************************");

	}

	public void menuGuestInfo() {
		System.out.println("현재 고객 정보 :");
		System.out.println("이름: " + user.getName() + "\t\t" + "연락처: " + user.getPhone());
	}

	public void menuCartItemList() {
		System.out.println("2. 장바구니 상품 목록 보기");
	}

	public void menuCartClear() {
		System.out.println("3. 장바구니 비우기");
	}

	public void menuCartAddItem() {
		System.out.println("4. 바구니에 항목 추가하기");
		booklist();

		while (true) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
			Scanner input = new Scanner(System.in);
			String bookId = input.nextLine();

			int search_index = -1;

			for (int i = 0; i < 3; i++) {
				if (bookId.equals(mBook[i].getBookId())) {
					search_index = i;
					break;
				}
			}
			if (search_index == -1) {
				System.out.println("도서의 ID를 확인해 주세요.");
				continue;
			}

//			System.out.println("몇 권을 주문하시겠습니까? ");
//			int count=input.nextInt();
//			input.nextLine();

			System.out.println("장바구니에 추가하겠습니까? (Y|N)");
			String yn = input.nextLine();

			if (yn.toUpperCase().equals("Y")) {
				int index = isCartInBook(bookId);
				if (index != NODATA) {
					cartItemList[index].setCount(cartItemList[index].getCount() + 1);
				} else {
					cartItemList[cartCount] = new CartItem(mBook[search_index]);
					cartCount++;
				}
				System.out.println(mBook[search_index].getBookName() + " (이)가 장바구니에 추가되었습니다.");

			}
			break;
		}
	}

	public void menuCartRemoveItemCount() {
		System.out.println("5. 장바구니에 항목 수량 줄이기");
	}

	public void menuCartRemoveItem() {
		System.out.println("6. 장바구니의 항목 삭제하기");
	}

	public void menuCartBill() {
		System.out.println("7. 영수증 표시하기");
	}

	public void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요.");
		Scanner input = new Scanner(System.in);
		System.out.print("아이디: ");
		String id = input.nextLine();
		System.out.print("비밀번호: ");
		String pw = input.nextLine();

		Admin admin = new Admin(user.getName(), user.getPhone());
		if (admin.getId().equals(id) && admin.getPw().equals(pw)) {
			System.out.println("이름: " + admin.getName() + "연락처: " + admin.getPhone());
			System.out.println("아이디: " + admin.getId() + "비밀번호: " + admin.getPw());
		}
		System.out.println("관리자 계정이 틀렸습니다. 다시 확인해주세요.. ");

	}

	public void menuExit() {

	}

	public void run() {

		Scanner input = new Scanner(System.in);

		System.out.print("당신의 이름을 입력하세요 : ");
		String name = input.next();

		System.out.print("연락처를 입력하세요 : ");
		String phone = input.next();
		boolean end_flag = false;
		user = new Person(name, phone);

		while (true) {
			menuIntroduction();
			System.out.print("메뉴 번호를 선택해 주세요 : ");

			int num = input.nextInt();
			if (num < 1 || num > 9) {
				System.out.println("메뉴 번호가 틀렸습니다.다시 선택해 주세요..");
				continue;
			}

			switch (num) {
			case 1:
				menuGuestInfo();
				break;
			case 2:
				menuCartItemList();
				break;
			case 3:
				menuCartClear();
				break;
			case 4:
				menuCartAddItem();
				break;
			case 5:
				menuCartRemoveItemCount();
				break;
			case 6:
				menuCartRemoveItem();
				break;
			case 7:
				menuCartBill();
				break;
			case 8:
				menuAdminLogin();
				break;
			case 9:
				menuExit();
				end_flag = true;
				break;
			default:
			}

			if (end_flag) {
				break;
			}
		}

		System.out.println("Book maket 종료");
	}
}
