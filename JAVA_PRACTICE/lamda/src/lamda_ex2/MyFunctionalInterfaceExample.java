package lamda_ex2;

// �Ű������� �ְ� ���ϰ��� ���� ���ٽ�
public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(2);
		
		fi = (x) -> { System.out.println(x * 5);};
		fi.method(2);
		
		fi = x -> System.out.println(x*5);
		fi.method(2);
		
		doSomething(x -> System.out.println(x * 5));
	}
	
	public static void doSomething(MyFunctionalInterface fi) {
		int a = 10;
		
		fi.method(a);
	}
}
