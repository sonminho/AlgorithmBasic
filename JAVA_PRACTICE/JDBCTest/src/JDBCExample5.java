import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionProvider;

public class JDBCExample5 {
	public static void main(String[] args) {
		ConnectionProvider connectionProvider = new ConnectionProvider();
		String sql = "select * from goodsinfo order by code";
		Connection conn = connectionProvider.getConnection();
		
		try (Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);){
			List<GoodsInfo> list = new ArrayList<GoodsInfo>();
			while(rs.next()) {				
				GoodsInfo gi = map(rs);
				System.out.println(gi);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connectionProvider.close();
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
