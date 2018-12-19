package edu.autocar.contact.service;

import java.util.List;
import java.util.Scanner;

public class Input {
	public static String getString(String msg) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(msg);
		return scanner.nextLine();
	}
	
	public static int selectList(List<String> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%d] %s\n", i+1, list.get(i));
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("선택 : ");
		
		return scanner.nextInt()-1;
	}
	
	public static int selectList(String[] strings) {
		for(int i = 0; i < strings.length; i++) {
			System.out.printf("%d] %s\n", i+1, strings[i]);
		}
				
		return Integer.parseInt(getString("선택 : " ))-1;
	}
}
