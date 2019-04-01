package scraping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResult<T> {
	String lastBuildDate;
	int total;
	int start;
	int display;
	T[] items;
}
