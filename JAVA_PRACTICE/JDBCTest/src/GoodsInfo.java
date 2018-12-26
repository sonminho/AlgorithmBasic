import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {
	private String code;
	private String name;
	private int price;
	private String maker;	
}
