import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import util.Input;
import util.Resource;

public class JDBCExample2 {
	public static void main(String[] args) throws Exception {
		String name = Input.getString("ªÛ«∞∏Ì : ");
		String sql = "select code, name, price, maker from goodsinfo where name like '%" + name
				+ "%' order by price desc";

		Properties properties = null;

		try {
			properties = Resource.getProperties("/database.properties");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String userpassword = properties.getProperty("password");

		try (Connection conn = (Connection) DriverManager.getConnection(url,username,userpassword);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			List<GoodsInfo> list = new ArrayList<>();

			while (rs.next()) {
				GoodsInfo gi = map(rs);
				list.add(gi);
			}
			print(list);
		} catch(Exception e) {
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
		for (GoodsInfo gi : list)
			System.out.printf("%8s %s \t%12d %s%n", gi.getCode(), gi.getName(), gi.getPrice(), gi.getMaker());
	}
}
