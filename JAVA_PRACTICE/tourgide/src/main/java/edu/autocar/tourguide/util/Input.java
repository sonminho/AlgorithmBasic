package edu.autocar.tourguide.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <pre>
 * edu.autocar.tourguide.util
 * 콘솔 입력 클래스
 * </pre>
 */
public class Input {
	public static String getString(String cmd) throws IOException {
		System.out.print(cmd);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = br.readLine();
		
		return result;
	}
}
