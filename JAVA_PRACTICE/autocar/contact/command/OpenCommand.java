package edu.autocar.contact.command;

import java.io.File;

import edu.autocar.contact.service.ContactService;
import edu.autocar.contact.service.Input;

public class OpenCommand implements Command {

	@Override
	public void execute() throws Exception {
		ContactService service = ContactService.getInstance();
		
		String fname = Input.getString("열람할 파일명 : ");
		
		File file = new File("C:/temp", fname);
		
		try {
			service.open(file);
			System.out.println("파일 열기 성공");
		} catch(Exception e) {
			System.err.println("파일 열기에 실패했습니다.");
			System.err.println(e.getMessage());
		}
	}

}
