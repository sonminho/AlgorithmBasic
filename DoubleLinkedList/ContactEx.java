

public class ContactEx {
	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();
		
		list.add(new Contact("홍길동", "hong@naver.com", "010-1234-1234", "서울시 강남구"));
		list.add(new Contact("손민호", "son@naver.com", "010-4567-4567", "서울시 성동구"));
		
		list.traverse();
	}
}
