package function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

// Supplier
// 매개값은 없고 리턴값은 있음
public class SupplierExample {
	public static void main(String[] args) {
		IntSupplier intSupplier = ()-> {
			int num = (int) ((Math.random() * 6) + 1);
			return num;
		};
	
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수 : " + num);
		
		Supplier<Integer> dice = () -> {return (int) (Math.random() * 6) + 1;};
	}
}
