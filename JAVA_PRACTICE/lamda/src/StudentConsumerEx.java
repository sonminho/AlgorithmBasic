import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StudentConsumerEx {
	static List<Student> list = new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(new Student("홍길동", 70));
		list.add(new Student("고길동", 80));
		list.add(new Student("둘리", 70));
		list.add(new Student("마이클", 70));
		
//		forEach(new Consumer<Student>() {
//			@Override
//			public void accept(Student t) {
//				System.out.println(t.toString());
//			}
//		});
		
		forEach(System.out::println);
		System.out.println("----------");
		list.forEach(System.out::println);		
		
		forEach((s) -> {System.out.println(s.getName());});
		System.out.println("=========");
		list.forEach((s)->{System.out.println(s.getScore());});
		System.out.println("=========");
		
		forEach((s, i) -> {System.out.println(s.getName() + ", " + i);});
		System.out.println("=========");
	}
	
	public static void forEach(Consumer<Student> consumer) {
		// 리스트를 순회하면서 어떤 작업을 실행해야 한다.
		// 어떤 작업을 실행할지는 매개변수로 전달된 코드로 실행한다.
		
		for(Student s : list) {
			consumer.accept(s);
		}
	}
	
	public static void forEach(BiConsumer<Student, Integer> biConsumer) {
		// 리스트를 순회하면서 어떤 작업을 실행해야 한다.
		// 어떤 작업을 실행할지는 매개변수로 전달된 코드로 실행한다.
		
		for(int i = 0; i < list.size(); i++) {
			biConsumer.accept(list.get(i), i);
		}
	}
}
