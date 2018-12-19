
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounterExample {
	public static void main(String[] args) {
		File file = new File("C:/Temp/test.txt");
		
		try {
			//List<String> lines = readLines(file);
			List<String> lines = Files.readAllLines(file.toPath());
			WordCounter wc = new WordCounter(lines);
			wc.parse();
			
			// 단어 철자순
			wc.printResult(System.out, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o1.getKey().compareTo(o2.getKey());
				}
				
			});
			
			System.out.println("\n단어의 출연 빈도순(내림차순)\n");
			wc.printResult(System.out, new Comparator<Map.Entry<String, Integer>>(){
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					return o2.getValue().compareTo(o1.getValue());
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<String> readLines(File file) throws Exception {
		 List<String> list = new ArrayList<>();
		 
		 try(
		     FileReader fr = new FileReader(file);
		     BufferedReader br = new BufferedReader(fr);
		 ) {
			 String line;
			 while((line = br.readLine()) != null) {
				 list.add(line);
			 }
		 } catch(Exception e){
			 e.printStackTrace();
		 }
		 return list;
	 }
}
