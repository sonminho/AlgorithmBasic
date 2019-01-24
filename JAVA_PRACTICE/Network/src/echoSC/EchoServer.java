package echoSC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args) {
		Socket socket = null;
		try(ServerSocket serverSocket = new ServerSocket(9999)) {
			while(true) {
				socket = serverSocket.accept();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				
				String line = br.readLine();
				System.out.println("서버 수신 메시지 > : " +  line);
				
				pw.println(line);
				pw.flush();
				socket.close();
			}
		} catch(Exception e) {
			
		} finally {
			try {
			} catch(Exception e) {
				
			}
		}
	}	
}
