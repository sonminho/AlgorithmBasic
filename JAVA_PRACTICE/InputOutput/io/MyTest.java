package chapter.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import util.Input;

public class MyTest {
	
	public static void main(String[] args) {
		String content = Input.getString("내용 : ");
		System.out.println();
		String fname = Input.getString("저장할 파일명 : " );
		
		File file = new File("C:\\Users\\student\\Desktop", fname);
		
		try {
			save(file, content);
			System.out.println("저장 완료\n");
			
			System.out.println("파일명 : " + file.getName() + "\n" + load(file));
			System.out.println("읽기 완료");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void save(File file, String content) throws Exception {
		try (
			FileWriter fw = new FileWriter(file);
		) {
			fw.write(content);
			fw.flush();
		}
	}
	
	public static String load(File file) throws Exception {
		String content = "";
		StringBuilder sb = new StringBuilder();
		
		try(FileReader fr = new FileReader(file)) {
			char[] chars = new char[200];
			int charsNo;
			while((charsNo = fr.read(chars)) != -1) {
				sb.append(chars, 0, charsNo);
				/*String data = new String(chars, 0, charsNo);
				System.out.println(data);*/
			}
		}
		
		return sb.toString();
	}
	public static String getMultiLine(String msg) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		System.out.println(msg);
		
		while(true) {
			String line = scanner.nextLine();
			
			if(line.equals("END"))
				break;
			
			sb.append(line + "\r\n");
		}
		
		return sb.toString();
	}
}
