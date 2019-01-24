package multi_chatting;

import java.net.Socket;
import java.util.Scanner;

public class MultiChattingClient {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("user name > ");
		String userName = s.nextLine();
		
		try {
			Socket socket = new Socket("70.12.112.142", 9002);
			Thread thread1 = new SenderThread(socket, userName);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
