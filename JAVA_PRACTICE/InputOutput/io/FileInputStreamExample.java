package chapter.io;

import java.io.FileInputStream;

public class FileInputStreamExample {
	public static void main(String[] args) {		
		try(FileInputStream fis = new FileInputStream("C:\\Users\\student\\Desktop\\연습장.txt");) {
			int data;
			
			while((data = fis.read()) != -1) {
				System.out.write(data);
			}
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
