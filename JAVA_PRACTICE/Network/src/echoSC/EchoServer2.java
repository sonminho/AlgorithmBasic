package echoSC;

import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer2 {
	public static void main(String[] args) {
		Socket socket = null;
		
		try(ServerSocket server = new ServerSocket(9999)) {
			while(true) {
				socket = server.accept();
				/*
				 * BufferedReader r = new BufferedReader(new
				 * InputStreamReader(socket.getInputStream())); 
				 * PrintWriter w = new PrintWriter(socket.getOutputStream());
				 * 
				 * String line = r.readLine(); System.out.println("���� ���� �޽��� : " + line);
				 * 
				 * w.println(line); w.flush(); socket.close();
				 */
				WorkThread work = new WorkThread(socket);
				work.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
