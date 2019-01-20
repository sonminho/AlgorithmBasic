package function;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

// Supplier
// �Ű����� ���� ���ϰ��� ����
public class SupplierExample {
	public static void main(String[] args) {
		IntSupplier intSupplier = ()-> {
			int num = (int) ((Math.random() * 6) + 1);
			return num;
		};
	
		int num = intSupplier.getAsInt();
		System.out.println("���� �� : " + num);
		
		Supplier<Integer> dice = () -> {return (int) (Math.random() * 6) + 1;};
	}
}
