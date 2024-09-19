package package1;
import java.util.Scanner;


public class AddressManager {
	private User [] regList = null;
	private MenuManager menuManager = null;
	private User user=null;
//	private int completeRegCount = 0;
	private final int REG_COUNT = 3;
	
	
	public AddressManager() {
		this.menuManager = new MenuManager();
		regList = new User[REG_COUNT];
		regList[0] = new User("aaa", "01000000000", "서울", "aa", "11");
		regList[1] = new User("bbb", "01011111111", "경기", "bb", "22");
		regList[2] = new User("ccc", "01022222222", "부산", "cc", "33");
		user = new User();
	}
	public void run() {
		boolean end_flag = false;

		while (true) {
			this.menuManager.firstMenu();
			int select = this.menuManager.selectFirstMenu();
			switch (select) {
			case MenuManager.LOGIN:
				if (this.loginProcess()) {
					this.addressProcess();
				}
				
				break;
			case MenuManager.EXIT:
				System.out.println("종료합니다.");
				end_flag = true;
				break;
			}
			if (end_flag) {
				break;
			}
		}
	}
	public boolean loginProcess() {
		Scanner input = new Scanner(System.in);
		System.out.print("ID: ");
		String id = input.nextLine();
		System.out.print("PW: ");
		String pw = input.nextLine();
		
		
		for(int i=0;i<regList.length;i++)
		if (id.equals(regList[i].getId()) && pw.equals(regList[i].getPw())) {
			System.out.println("로그인 되었습니다.");
			regList[i].login();
			return true;
			
		}
		System.out.println("입력된 정보가 틀렸습니다.");
		
		return false;
		
	}
	public void addressProcess() {
		boolean end_flag = false;
		while (true) {
			this.menuManager.secondMenu();
			int select = this.menuManager.selectSecondMenu();

			switch (select) {
			case MenuManager.ADDRESS_SEARCH:
				this.addressSearch();
				break;
			case MenuManager. ALL_ADDRESS_SEARCH:
				this.allAddressSearch();
				break;
			case MenuManager.LOGOUT:
				this.logout();
				System.out.println("로그아웃 되었습니다.");
				end_flag = true;
				break;
			}
			if (end_flag) {
				break;
			}
		}
	}

	public void addressSearch() {
		Scanner input = new Scanner(System.in);
		System.out.print("검색할 유저의 이름: ");
		String name = input.nextLine();
		boolean flag = false;
		
		for (int i = 0; i < this.REG_COUNT; i++) {
			if (this.regList[i].getName().equals(name)) {
				System.out.println(this.regList[i].getName()+"님의 주소: "+ this.regList[i].getAddress());
				System.out.println(this.regList[i].getName()+"님의 전화번호: "+this.regList[i].getPhone());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("검색하신 분이 등록되어있지 않는 분입니다.");
		}
	}
	public void allAddressSearch() {
		for (int i = 0; i < this.REG_COUNT; i++) {
				System.out.println(this.regList[i].getName()+"님의 주소: "+ this.regList[i].getAddress());
				System.out.println(this.regList[i].getName()+"님의 전화번호: "+this.regList[i].getPhone());
				
		}
	}
	public void logout() {
		this.user.logout();
	}
}
