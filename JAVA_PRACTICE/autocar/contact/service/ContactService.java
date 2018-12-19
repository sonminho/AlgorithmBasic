package edu.autocar.contact.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.contact.model.Contact;

public class ContactService {
	// 싱글톤 패턴 적용
	private ContactService() {
		
	}
	
	private static ContactService instance = new ContactService();
	
	public static ContactService getInstance() {
		return instance;
	}
	
	// 주소록 리스트
	List<Contact> contactList = new ArrayList<>();
	
	public void add(Contact contact) {
		contactList.add(contact);
	}
	
	public void save(File file) throws Exception {
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(contactList);
			oos.flush();
		}
	}
	
	public void open(File file) throws Exception {
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			contactList = (List<Contact>)ois.readObject();
		}
	}
	
	public Contact[] getContactList() {
		Contact[] arr = new Contact[contactList.size()];
		
		return contactList.toArray(arr);
	}
}
