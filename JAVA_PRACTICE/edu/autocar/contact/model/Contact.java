package edu.autocar.contact.model;

import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact>{
	private String name;
	private String phone;
	private String email;
	private String group;
	private String memo;
	
	public Contact() {
		
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + ", group=" + group + ", memo=" + memo
				+ "]";
	}

	public Contact(String name, String phone, String email, String group, String memo) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.group = group;
		this.memo = memo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public int compareTo(Contact c) {
		return name.compareTo(c.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
}