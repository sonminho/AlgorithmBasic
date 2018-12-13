

public class DoubleLinkedList implements Queue {
	private Node head;
	private int size;
	
	private class Node {
		private Contact contact;
		private Node next;
		private Node prev;
		
		Node(Contact contact) {
			this.contact = contact;
		}

		public Contact getContact() {
			return contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}
	}
	
	public DoubleLinkedList() {
		head = new Node(null);
		size = 0;
		head.next = head;
		head.prev = head;
	}
	
	public void add(Contact contact) {
		Node newNode = new Node(contact);
		
		newNode.prev = head.prev;
		newNode.next = head;
		head.prev.next = newNode;		
		head.prev = newNode;
		
		size++;
	}
	
	public void add(int ix, Contact contact) {
		Node cur = getNode(ix);
		Node newNode = new Node(contact);
	
		cur.prev.next = newNode;
		newNode.next = cur;
		newNode.prev = cur.prev;
		cur.prev = newNode;
		
		size++;
	}
	
	public Contact get(int idx) {
		return getNode(idx).getContact();
	}
	
	public void traverse() {
		Node cur = head.next;
		
		while(cur != head) {
			System.out.println(cur.contact + " ");
			cur = cur.next;
		}
		
		System.out.println();
	}
	
	private Node getNode(int idx) {
		Node cur = head.next;
		
		while(idx-- > 0) {
			cur = cur.next;
		}
		
		return cur;
	}
	
	public Contact remove(int idx) {
		Node cur = getNode(idx);
		Contact contact = cur.contact;
		
		if(cur == head) {
			return null;
		}
		
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		
		size--;
		
		return contact;
	}
	
	public void set(int idx, Contact contact) {
		Node cur = getNode(idx);
		cur.setContact(contact);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void clear() {
		head = new Node(null);
		head.prev = head;
		head.next = head;
		size = 0;
	}

	@Override
	public void enqueue(Contact contact) {
		add(contact);
	}

	@Override
	public Contact dequeue() {
		return remove(0);
	}
}
