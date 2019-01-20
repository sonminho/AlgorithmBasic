package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Fucntion
// 매개값도 있고 리턴값도 있음
// 주로 매개값을 리턴으로 매핑
public class FunctionExample1 {
	private static List<Student> list = Arrays.asList(new Student("홍길동", 90, 96)
			, new Student("신용권", 95, 93));
	
	public static void print(Function<Student, ?> function) {
		for(Student student : list) {
			System.out.println(function.apply(student) + " ");
		}
		
		list.forEach(s -> System.out.println(function.apply(s) + " "));
		
		System.out.println();
	}
	
//	public static void printInt(Function<Student, Integer> function) {
//		for(Student student : list) {
//			System.out.println(function.apply(student) + " ");
//		}
//		System.out.println();
//	}
	
	public static void main(String[] args) {
		System.out.println("[학생이름]");
		print(t -> t.getName());
		
		System.out.println("[영어점수]");
		print(t -> t.getEnglishScore());
		
		System.out.println("[수학점수]");
		print(t -> t.getMathScore());
	}
}
