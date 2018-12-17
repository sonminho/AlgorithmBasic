package edu.autocar.contact.command;

import edu.autocar.contact.model.Contact;
import edu.autocar.contact.service.ContactService;

public class ContactListCommand implements Command {

	@Override
	public void execute() throws Exception {
		ContactService service = ContactService.getInstance();
		Contact[] contacts = service.getContactList();
		
		for(int i = 0; i < contacts.length; i++) {
			Contact c = contacts[i];
			System.out.printf("%3d) %-10s %-15s\n", i+1, c.getName(), c.getPhone(), c.getEmail());
		}
	}

}
