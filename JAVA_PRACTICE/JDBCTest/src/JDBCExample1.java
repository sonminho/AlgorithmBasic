import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample1 {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try (Connection conn = (Connection) DriverManager.getConnection(url, "autocar", "1234");
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("select code, name, price, maker from goodsinfo order by price desc")) {
			System.out.println("DB에 접속했습니다.");
			System.out.println("상품코드\t\t상품명 \t\t가격 제조사");
			
			List<GoodsInfo> list = new ArrayList<>();
			while (rs.next()) {
				GoodsInfo gi = map(rs);
				list.add(gi);
			}
			print(list);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static GoodsInfo map(ResultSet rs) throws Exception {
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		String maker = rs.getString("maker");

		return new GoodsInfo(code, name, price, maker);
	}

	static void print(List<GoodsInfo> list) {
		for(GoodsInfo gi : list)
			System.out.printf("%8s %s \t%12d %s%n", gi.getCode(), gi.getName(), gi.getPrice(), gi.getMaker());
	}
}
