public class Bridge {
	private int counter = 0;
	private String name = "�ƹ���";
	private String address = "��";
	
	public synchronized void across(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		check();
	}
	
	@Override
	public synchronized String toString() {
		return "�̸� : " + name + ", ��� : " + address + ", ���� Ƚ�� : " +  counter;
	}
	
	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("���� �߻� !!!!!! " + toString());
		}
	}
}