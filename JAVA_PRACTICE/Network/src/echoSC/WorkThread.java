package echoSC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class WorkThread extends Thread {
	private Socket socket;
	
	public WorkThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); 

			String line = r.readLine();
			System.out.println("서버 수신 메시지 : " + line);

			w.write(line+"\n");
			w.flush();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
