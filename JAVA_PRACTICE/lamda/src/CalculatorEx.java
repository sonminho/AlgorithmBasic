import java.util.function.BinaryOperator;
import java.util.function.Consumer;

public class CalculatorEx {
	public static void main(String[] args) {
		BinaryOperator<Integer> operator;
		
		// 정적 메서드 참조
		operator = (x, y) -> Calculator.staticMethod(x, y);
		System.out.println("결과 1 : " + operator.apply(1, 2));
		
		operator = Calculator :: staticMethod;
		System.out.println("결과 2: " + operator.apply(3, 4));
		
		// 인스턴스 메서드 참조
		Calculator obj = new Calculator();
		operator = (x, y) -> obj.instanceMethod(x, y);
		System.out.println("결과 3 : " + operator.apply(5, 6));
		
		operator = obj :: instanceMethod;
		System.out.println("결과 4 : " + operator.apply(7, 8));
		
		Consumer<String> consumer = System.out::println;
		consumer.accept("Hello World!");
	}
}
