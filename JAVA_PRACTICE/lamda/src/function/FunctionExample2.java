package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample2 {
	private static List<Student> list = Arrays.asList(
				new Student("홍길동", 90, 96),
				new Student("신용권", 95, 93)
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
		System.out.println("영어 평균점수 : " + englishAvg);
		
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균점수 : " + mathAvg);
	}
}
