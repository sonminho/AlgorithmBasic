package edu.autocar;

import edu.autocar.contact.command.ContactAddCommand;
import edu.autocar.contact.command.ContactListCommand;
import edu.autocar.contact.command.ExitCommand;
import edu.autocar.contact.command.OpenCommand;
import edu.autocar.contact.command.SaveCommand;

public class ContactApp extends Application {

	@Override
	protected void createMenu(MenuBar menu) {
		menu.add(new MenuItem("열기", "o", new OpenCommand()));
		menu.add(new MenuItem("목록", "l", new ContactListCommand()));
		menu.add(new MenuItem("추가", "a", new ContactAddCommand()));
		menu.add(new MenuItem("저장", "s", new SaveCommand()));
		menu.add(new MenuItem("종료", "q", new ExitCommand()));
	}

	public static void main(String[] args) {
		ContactApp app = new ContactApp();
		app.run();
	}
}
