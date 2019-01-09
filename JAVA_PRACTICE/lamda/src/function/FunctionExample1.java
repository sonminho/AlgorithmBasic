package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

// Fucntion
// �Ű����� �ְ� ���ϰ��� ����
// �ַ� �Ű����� �������� ����
public class FunctionExample1 {
	private static List<Student> list = Arrays.asList(new Student("ȫ�浿", 90, 96)
			, new Student("�ſ��", 95, 93));
	
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
		System.out.println("[�л��̸�]");
		print(t -> t.getName());
		
		System.out.println("[��������]");
		print(t -> t.getEnglishScore());
		
		System.out.println("[��������]");
		print(t -> t.getMathScore());
	}
}
