package chapter.io;

import java.io.File;
import java.io.FileFilter;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class FileExample {
	
	public static void main(String[] args) throws Exception {
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");
		File file3 = new File(new URI("file:///C:/Temp/file3.txt"));
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		if(file1.exists() == false) { 
			file1.createNewFile();
		}
		if(file2.exists() == false) { 
			file2.createNewFile();
		}
		if(file3.exists() == false) { 
			file3.createNewFile();
		}
		
		File temp = new File("C:/Temp");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   a   HH:mm");
		//File[] contents = temp.listFiles();
		
		// 파일 확장자로 필터
		/* 	File[] contents = temp.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				name = name.toLowerCase();
				return name.endsWith(".jpg");
			}			
		});*/
		
		// 파일 크기로 필터
		File[] contents = temp.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.length() < 512;
			}}
		);
		
		Arrays.sort(contents, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				// 1. 유형이 다른 경우 디렉토리가 앞서도록 설정
				if(!(o1.isFile() == o2.isFile())) {
					return o1.isDirectory() ?  -1 : 1;
				}
				// 2. 같은 유형인 경우 이름으로 결정
				else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
		
		System.out.println("날짜                시간           형태                   크기             이름");
		System.out.println("--------------------------------------------------------------------------------");
		
		for(File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified())));
			
			if(file.isDirectory()) {
				System.out.println("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.println("\t\t\t" + file.length() + "\t" + file.getName());
			}
		}
		
		System.out.println();
	}
	
}
