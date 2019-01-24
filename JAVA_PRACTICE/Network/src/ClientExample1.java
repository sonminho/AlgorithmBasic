import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample1 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		try(Socket socket = new Socket("127.0.0.1", 10000)) {
			InputStream in = socket.getInputStream(); // 수신(입력) 스트림
			OutputStream out = socket.getOutputStream(); // 전송(출력) 스트림
			
			String str = "Hello, Server";
			out.write(str.getBytes());
			out.flush();
			
			byte arr[] = new byte[100]; // 수신 버퍼
			in.read(arr); // 메시지 수신
			System.out.println(new String(arr));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
