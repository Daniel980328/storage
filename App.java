package dbpackage;

import java.sql.Date;

public class App {

	public static void main(String[] args) {
		DBManager manager=new DBManager();
		manager.initDBConnect();
		User[] userList = manager.allFetch();
		
		for(int i= 0; i<userList.length; i++) {
			System.out.println(userList[i].getUserId());
			System.out.println(userList[i].getUserName());
			System.out.println(userList[i].getHeight());
			System.out.println(userList[i].getBirthYear());
			System.out.println(userList[i].getAddr());
			System.out.println(userList[i].getMobile1());
			System.out.println(userList[i].getMobile2());
			System.out.println(userList[i].getmDate());			
		}
		System.out.println("==================================");
		manager.selectUser("유재석");	
		
		manager.inputUser(new User("HCG","홍창기",2000,"서울",null,null,192,Date.valueOf("2024-09-27")));
		manager.releaseDB();
	}

	
	
}
