import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {
	
	private List<T> list;
	private int totalPage;
	
	public Pagination(List<T> list) {
		super();
		this.list = list;
		
		totalPage = (int)Math.ceil(list.size()/10.);
		/*if(list.size()%10 > 0) {
			this.totalPage = (list.size()/10) + 1;
		} else {
			this.totalPage = list.size()/10;
		}*/
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	@Override
	public String toString() {
		return "Pagination [list=" + list + ", totalPage=" + totalPage + "]";
	}
	
	public List<T> getPage(int page) { 
		List<T> newList = new ArrayList<T>();
		
		int start = (page-1)*10;
		int end = (page < totalPage) ? start + 10 : list.size();
		
		for(int i = start; i < end; i++) {
			newList.add(list.get(i));
		}
		
		/*for(int i = (page-1)*10; i < page*10; i++) {
			if(page != totalPage) {
				newList.add(list.get(i));
			} else {
				for(int j = i; j < list.size(); j++) {
					newList.add(list.get(j));
				}
				break;
			}
		}*/		
		
		return newList;
	}
}
