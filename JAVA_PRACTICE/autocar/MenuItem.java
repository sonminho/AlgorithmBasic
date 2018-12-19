package edu.autocar;

import edu.autocar.contact.command.Command;

public class MenuItem {
	private String title;
	private String hotkey;
	private Command command;
	
	public MenuItem(String title, String hotkey, Command command) {
		super();
		this.title = title;
		this.hotkey = hotkey;
		this.command = command;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHotkey() {
		return hotkey;
	}
	public void setHotkey(String hotkey) {
		this.hotkey = hotkey;
	}
	public Command getComnad() {
		return command;
	}
	public void setComnad(Command command) {
		this.command = command;
	}
	public void execute() throws Exception { 
		if(command != null) 
			command.execute();
	}
	@Override
	public String toString() {
		return "MenuItem [title=" + title + ", hotkey=" + hotkey + "]";
	}	
}
