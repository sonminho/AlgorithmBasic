
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class WordCounter {
	Map<String, Integer> map;
	List<String> list;
	
	WordCounter(List<String> list) {
		super();
		this.map = new HashMap<String, Integer>();
		this.list = list;
	}
	
	public void parse() {
		for(String line : list) {
			StringTokenizer stk = new StringTokenizer(line, " \t,\"'.?!");
			
			while(stk.hasMoreTokens()) {
				String token = stk.nextToken();
				
				// 처음등장했으면
				if(!map.containsKey(token)) {
					map.put(token, 1);
				} else {
					int count = map.get(token);
					count++;
					map.put(token, count);
				}
			}
		}
	}
	
	public void printResult(PrintStream out) {
		for(String key : map.keySet()) {
			out.println(key +  " : " + map.get(key));
		}
	}
	
	public void printResult(PrintStream out, Comparator<Map.Entry<String, Integer>> comparator) {
		// Map.Entry 만들기
		List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		
		Collections.sort(entries, comparator);
		
		for(Map.Entry<String, Integer> entry : entries) {
			out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
