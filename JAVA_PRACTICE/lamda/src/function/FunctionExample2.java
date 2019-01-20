package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample2 {
	private static List<Student> list = Arrays.asList(
				new Student("ȫ�浿", 90, 96),
				new Student("�ſ��", 95, 93)
			);
	
	public static double avg(Function<Student, Integer> function) {
		int sum = 0;
	
		for(Student student : list) {
			sum += function.apply(student);
		}
		
		double avg = (double) sum / list.size();
		
		return avg;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("���� ������� : " + englishAvg);
		
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("���� ������� : " + mathAvg);
	}
}
