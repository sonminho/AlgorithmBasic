package lamda_ex1;

// 매개변수와 리턴값이 없는 람다식
public class MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		
		fi = ()->{
			String str = "method call";
			System.out.println(str);
		};
		//fi.method();
		
		fi = ()->{
			System.out.println("method call2");
		};
		//fi.method();
		
		fi = () -> System.out.println("method call3");
		//fi.method();
		
		doSomething(fi);
		doSomething2(()->{System.out.println("method call4");});
	}
	
	static void doSomething(MyFunctionalInterface fi) {
		System.out.println("=======================");
		fi.method();
		System.out.println("=======================");
	}
	
	static void doSomething2(Runnable r) {
		r.run();
	}
}