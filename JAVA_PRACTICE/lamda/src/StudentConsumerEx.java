import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StudentConsumerEx {
	static List<Student> list = new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(new Student("ȫ�浿", 70));
		list.add(new Student("��浿", 80));
		list.add(new Student("�Ѹ�", 70));
		list.add(new Student("����Ŭ", 70));
		
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
		// ����Ʈ�� ��ȸ�ϸ鼭 � �۾��� �����ؾ� �Ѵ�.
		// � �۾��� ���������� �Ű������� ���޵� �ڵ�� �����Ѵ�.
		
		for(Student s : list) {
			consumer.accept(s);
		}
	}
	
	public static void forEach(BiConsumer<Student, Integer> biConsumer) {
		// ����Ʈ�� ��ȸ�ϸ鼭 � �۾��� �����ؾ� �Ѵ�.
		// � �۾��� ���������� �Ű������� ���޵� �ڵ�� �����Ѵ�.
		
		for(int i = 0; i < list.size(); i++) {
			biConsumer.accept(list.get(i), i);
		}
	}
}
