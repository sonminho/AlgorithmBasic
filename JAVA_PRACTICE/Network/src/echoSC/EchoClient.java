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
			// 수신용 Reader
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			// 전송용 Writer
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			Scanner s = new Scanner(System.in);
			System.out.print("문자열 입력 > ");
			
			String line = s.nextLine(); // 전송할 문자열 입력

			bw.write(line+"\n");
			bw.flush();
			
			String receiveLine = br.readLine();
			System.out.println("수신 메시지 : " + receiveLine);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
