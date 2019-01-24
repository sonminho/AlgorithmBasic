package chatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiverThread extends Thread {
	Socket socket;

	ReceiverThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			while (true) {
				String str = reader.readLine();

				if (str == null) // 송신측에서 소켓을 닫았을때
					break;
				
				System.out.println("수신 > " + str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
