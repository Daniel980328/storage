package dbpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.Date;
import java.sql.Time;

public class DBManager {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/cookdb?serverTimeZone=UTC";
	private String id = "root";
	private String pw = "1234";

	private Connection conn = null;
	private Statement stmt = null;

	public DBManager() {
		// TODO Auto-generated constructor stub
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

	public User[] allFetch() {
		int reCount = this.recordCount();
		User[] userList = new User[reCount];
		int userCount = 0;
		String sql = "select * from usertbl";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("userid");
				String name = rs.getString("username");
				int birthYear = rs.getInt("birthyear");
				String addr = rs.getString("addr");
				String mobile1 = rs.getString("mobile1");
				String mobile2 = rs.getString("mobile2");
				int height = rs.getInt("height");
				Date mDate = rs.getDate("mdate");

				userList[userCount++] = new User(id, name, birthYear, addr, mobile1, mobile2, height, mDate);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public void selectUser(String username) {
//		 String sql = "select * from usertbl where username = '" + username+"'";
		String sql = "select * from usertbl where username = ?";
		try {
//			 ResultSet rs=this.stmt.executeQuery(sql);
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("userid");
				String name = rs.getString("username");
				int birthYear = rs.getInt("birthyear");
				String addr = rs.getString("addr");
				String mobile1 = rs.getString("mobile1");
				String mobile2 = rs.getString("mobile2");
				int height = rs.getInt("height");
				Date mDate = rs.getDate("mdate");
				System.out.println(id);
				System.out.println(name);
				System.out.println(birthYear);
				System.out.println(addr);
				System.out.println(mobile1);
				System.out.println(mobile2);
				System.out.println(height);
				System.out.println(mDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inputUser(User user) {
		String sql = "insert into usertbl values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(1, user.getUserName());
			pstmt.setInt(1, user.getBirthYear());
			pstmt.setString(1, user.getAddr());
			pstmt.setString(1, user.getMobile1());
			pstmt.setString(1, user.getMobile2());
			pstmt.setInt(1, user.getHeight());
			pstmt.setDate(1, user.getmDate());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void releaseDB() {
		try {
			this.conn.close();
			this.stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
