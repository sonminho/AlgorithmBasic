package edu.autocar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuBar {
	List<MenuItem> list;
	Map<String, MenuItem> map;
	
	public MenuBar() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}
	
	public void add(MenuItem item) {
		list.add(item);
		map.put(item.getHotkey(), item);
	}
	
	public void print() {
		for(MenuItem item : list) {
			System.out.println(item + " ");
		}
		System.out.println();
	}
	
	public void execute(String hotKey) throws Exception {
		MenuItem item = map.get(hotKey);
		
		if(item != null) {
			item.execute();
		} else {
			System.out.println("잘못된 단축 키입니다.");
		}
	}
}
