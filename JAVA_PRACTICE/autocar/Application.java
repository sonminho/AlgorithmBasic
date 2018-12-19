package edu.autocar;

import util.Input;

public class Application {
	MenuBar mainMenu;
	
	public Application() {
		mainMenu = new MenuBar();
		createMenu(mainMenu);
	}
	
	protected void createMenu(MenuBar menu) {
		
	}
	
	public void run() {
		while(true) {
			mainMenu.print();
			String sel = Input.getString("열기(O), 목록(L), 추가(A), 저장(S), 종료(Q) : ");
			
			try {
				mainMenu.execute(sel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
