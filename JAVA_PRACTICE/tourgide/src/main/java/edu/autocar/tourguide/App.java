package edu.autocar.tourguide;

import java.io.IOException;

import edu.autocar.tourguide.menu.MenuBar;
import edu.autocar.tourguide.util.Input;

/**
 * <pre>
 * edu.autocar.tourguide
 * 2019. 1. 7.
 * </pre>
 */
public class App {
	MenuBar menuBar;

	public App() {
		init();
		menuBar = new MenuBar();
		createMenu(menuBar);
	}

	protected void createMenu(MenuBar menubar) {

	}

	protected void init() {
		
	}
	
	public void run() throws IOException {
		while (true) {
			menuBar.print();
			String sel = Input.getString("\n메뉴 입력 : ");
			try {
				menuBar.execute(sel);
			} catch (Exception e) {
				System.out.println("에러 발생.");
				e.printStackTrace();
			}
		}
	}
}
