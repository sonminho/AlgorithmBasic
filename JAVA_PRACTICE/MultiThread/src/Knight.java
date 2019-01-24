
public class Knight extends Thread {
	private final Bridge bridge; // ���� ��ü
	
	private final String name;
	private final String address;
	
	public Knight(Bridge bridge, String name, String address) {
		this.bridge = bridge;
		this.name = name;
		this.address = address;
	}
	
	public void run() {
		System.out.println(name + " ��簡 �����Ѵ�.");
		
		while(true) {
			bridge.across(name, address);
		}
	}
}
