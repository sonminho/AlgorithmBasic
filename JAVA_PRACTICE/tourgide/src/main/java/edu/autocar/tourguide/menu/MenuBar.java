package edu.autocar.tourguide.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * edu.autocar.tourguide.menu
 * 메뉴 아이템의 리스트를 관리와
 * Command 객체의 실행을 담당한다.
 * </pre>
 */
public class MenuBar {
	List<MenuItem> list;
	Map<String, MenuItem> map;
	
	public MenuBar() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}
	
	public void add(MenuItem item) {
		list.add(item);
		map.put(item.getHotKey(), item);
	}
	
	public void print() {
		for(MenuItem item : list) {
			System.out.print(item + "\t");
		}
		System.out.println();
	}	
	
	public void execute(String hotKey) throws Exception{
		MenuItem item = map.get(hotKey.toUpperCase());
		if(item != null) {
			item.execute();
		} else {
			System.out.println("\n잘못된 명령입니다.\n");
		}
	}
}
