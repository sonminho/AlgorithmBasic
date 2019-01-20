package predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	private static List<Student> list = Arrays.asList(
				new Student("ȫ�浿", "����", 90),
				new Student("�����", "����", 90),
				new Student("���ڹ�", "����", 95),
				new Student("���ѳ�", "����", 92)
	);
	
	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		
		for(Student student :list) {
			if(predicate.test(student)) {
				count++;
				sum += student.getScore();
			}
		}
		return (double) sum / count;
	}
	
	public static List<Student> getStudents(Predicate<Student> predicate) {
		List<Student> tempList = new ArrayList<>();
		
//		for(Student student : list) {
//			if(predicate.test(student)) {
//				tempList.add(student);
//			}
//		}
		
		list.forEach(e->{
			if(predicate.test(e) ) {
				tempList.add(e);
			}
		});
		
		return tempList;
	}
	
	public static void main(String[] args) {
		double maleAvg = avg(t -> t.getSex().equals("����"));
		System.out.println("���� ��� ���� : " + maleAvg);
		
		double femaleAvg = avg(t -> t.getSex().equals("����"));
		System.out.println("���� ��� ���� : " + femaleAvg);
		
		List<Student> slist = getStudents(t -> t.getSex().equals("����"));
		slist.forEach(t -> System.out.println(t));
		
		getStudents(t -> t.getScore() >= 95).forEach(t -> System.out.println(t));
		System.out.println();
		
		getStudents(t -> (t.getScore() >= 95 && t.getSex().equals("����"))).forEach(t -> System.out.println(t));
	}
}
