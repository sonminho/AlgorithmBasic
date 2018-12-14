package chapter.io;

import java.util.Scanner;

public class ScannerExample {
	
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner("hello\n12 34.1");
		System.out.print("문자열 입력 > ");
		String inputString = scanner.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("정수 입력 > ");
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		scanner.nextLine();
		System.out.print("문자열 입력 > ");
		inputString = scanner.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("실수 입력 > ");
		double inputDouble = scanner.nextDouble();
		System.out.print(inputDouble);
	}
	
}
