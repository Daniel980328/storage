package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbpackage.User;



public class Rent_Manager {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/cookdb?serverTimeZone=UTC";
	private String id = "root";
	private String pw = "1234";
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public Rent_Manager() {

	}
	public void initDBConnect() {
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(this.url, this.id, this.pw);
			this.stmt = conn.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int recordCount() {
		String sql = "select count(*) as cnt from usertbl";
		int reCount = 0;

		try {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				reCount = rs.getInt("cnt");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reCount;
	}
	
	public Book[] allFetch() {
		
		int reCount = this.recordCount();
		Book[] bookList = new Book[reCount];
		int bookCount = 0;
	}
	
	public void inputUser(User user) {
		
	}
	
	public void releaseDB() {
		try {
			this.conn.close();
			this.stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
 public void insertRent(String bookId, String userId) {
	 
	 
 }

}

