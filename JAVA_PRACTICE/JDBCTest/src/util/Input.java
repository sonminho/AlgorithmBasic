package util;

import java.util.Scanner;

public class Input {
	public static String getString(String cmd) {
		System.out.print(cmd);
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		
		return result;
	}
}
