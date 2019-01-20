package edu.autocar.tourguide.menu;

import edu.autocar.tourguide.command.Command;

/**
 * <pre>
 * edu.autocar.tourguide.menu
 * 메뉴 아이템 클래스
 * 맵형태로 키와 사용자 입력값을 저장하고
 * Command 객체에 접근한다.
 * </pre>
 */
public class MenuItem {
	private String title;
	private String hotKey;
	private Command command;	
	
	public MenuItem(String title, String hotKey, Command command) {
		super();
		this.title = title;
		this.hotKey = hotKey;
		this.command = command;
	}

	public String getTitle() {
		return title;
	}

	public String getHotKey() {
		return hotKey;
	}
	
	public void execute() throws Exception{
		if(command!=null) {
			command.execute();
		}
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", title, hotKey);
	}	
}
