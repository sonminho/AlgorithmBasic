package edu.autocar.contact.command;

import edu.autocar.contact.model.Contact;
import edu.autocar.contact.service.ContactService;
import util.Input;

public class ContactAddCommand implements Command {
	@Override
	public void execute() throws Exception {
		ContactService service = ContactService.getInstance();

		Contact contact = createContact();
		service.add(contact);
	}
	
	Contact createContact() {
		System.out.println("주소록 정보를 ");
		String name = Input.getString("이름 : ");
		String phone = Input.getString("전화번호 : ");
		String email = Input.getString("이메일 : ");
		String group = Input.getString("그룹 : ");
		String memo = Input.getString("메모 : ");
		
		return new Contact(name, phone, email, group, memo);
	}
}
