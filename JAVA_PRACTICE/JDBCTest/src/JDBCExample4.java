import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCExample4 {
	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("Usage : java JDBCExample4");
			return;
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String sql = "insert into goodsinfo (code, name, price, maker) "
				+ "values(?, ?, ?, ?)";
		
		try(Connection conn = DriverManager.getConnection(url, "autocar", "1234");
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, args[0]);
			pstmt.setString(2, args[1]);
			pstmt.setInt(3, Integer.parseInt(args[2]));
			pstmt.setString(4, args[3]);
			
			int rowNum = pstmt.executeUpdate();
			
			System.out.println(rowNum + "개 반영되었습니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
