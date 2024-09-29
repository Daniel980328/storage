package package1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




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
		String sql = "select count(*) as cnt from book";
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
	String sql = "SELECT * FROM book";
        try {
            ResultSet rs = stmt.executeQuery(sql);
            int bookCount = 0;
            while (rs.next()) {
                String id = rs.getString("id");
                long categoryId = rs.getLong("category_id");
                String title = rs.getString("title");
                boolean rented = rs.getBoolean("rented");
                String writer = rs.getString("writer");
                String publisher = rs.getString("publisher");
                String description = rs.getString("description");

                // Book 객체 생성 후 배열에 추가
                bookList[bookCount] = new Book(id, categoryId, title, rented, writer, publisher, description);
                bookCount++;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }
	
""
	
 public void insertRent(String bookId, String userId, String startDate, String endDate) {
	  String sql = "insert into rent values(null, ?, ?, ?, ?)";
	 
	  try {	
	 PreparedStatement pstmt = conn.prepareStatement(sql);
	 pstmt.setString(1, bookId);
	 pstmt.setString(2, bookId);
	 pstmt.setDate(3, Date.valueOf(startDate));
	 pstmt.setDate(4, Date.valueOf(endDate)); // 번호가 오토인크리먼트일 경우 null 값으로 변경
	 pstmt.executeUpdate();  // DB 에다 호출

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
	
//	"20240201"
//	

