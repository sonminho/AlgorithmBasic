import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCExample3 {
	public static void main(String[] args) {
		if(args.length != 4) {
			System.out.println("Usage : java JDBCExample4 ��ǰ�ڵ� ��ǰ�� ���� ������");
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
			System.out.println(rowNum + "���� �߰��Ǿ����ϴ�.");
			conn.commit();
		} catch(Exception e) { 
			System.out.println(e.getMessage());
		}
	}
}
