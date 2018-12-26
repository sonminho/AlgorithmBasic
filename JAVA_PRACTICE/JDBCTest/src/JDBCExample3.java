import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCExample3 {
	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("Usage : java JDBCExample4 상품코드 상품명 가격 제조사");
			return;
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try(Connection conn = (Connection) DriverManager.getConnection(url, "autocar", "1234");
				Statement stmt = conn.createStatement()) {
			int rowNum = stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('"
					+ args[0] + "', '"
					+ args[1] + "', '"
					+ args[2] + "', '"
					+ args[3] + "')");
			System.out.println(rowNum + "행이 추가되었습니다.");
			conn.commit();
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		}
	}
}
