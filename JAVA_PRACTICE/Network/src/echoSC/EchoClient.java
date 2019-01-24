package echoSC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		try(Socket socket = new Socket("127.0.0.1", 10000)) {
			// ���ſ� Reader
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// ���ۿ� Writer
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Scanner s = new Scanner(System.in);
			System.out.print("���ڿ� �Է� > ");
			
			String line = s.nextLine(); // ������ ���ڿ� �Է�

			bw.write(line+"\n");
			bw.flush();
			
			String receiveLine = br.readLine();
			System.out.println("���� �޽��� : " + receiveLine);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
