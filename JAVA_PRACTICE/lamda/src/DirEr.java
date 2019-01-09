import java.io.File;
import java.io.FilenameFilter;

public class DirEr {
	public static void main(String[] args) {
		String path = "C:/temp";
		printDir(path, (dir, name) -> name.endsWith(".txt"));
		System.out.println("======================");
		printDir(path, (dir, name) -> name.endsWith(".jpg"));
	}

	public static void printDir(String path, FilenameFilter fFilter) {
		File tempFile = new File(path);
		
//		FilenameFilter fFilter = new FilenameFilter() {
//			@Override 
//			public boolean accept(File dir, String name) {
//				return name.endsWith(".txt"); 
//			} 
//		};		 

		//String[] files = tempFile.list(fFilter);
		
//		FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
//		String[] files = tempFile.list(filter);
//		String[] files = tempFile.list((dir, name)->name.endsWith(".txt"));
		
		String[] files = tempFile.list(fFilter);
		
		for(String file : files)
			System.out.println(file);	
	}
}
