import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {
	public static void main(String[] args) {
		Socket socket = null; // ���� ���� ����

		try(ServerSocket serverSocket = new ServerSocket(10000);) {
			socket = serverSocket.accept(); // ���� ���

			InputStream in = socket.getInputStream(); // ����(�Է�) ��Ʈ�� 
			OutputStream out = socket.getOutputStream(); // ����(���) ��Ʈ��
			
			byte arr[] = new byte[100];
			in.read(arr); // �޽��� ����
			System.out.println(new String(arr));
			
			String str = "Hello, Client";
			out.write(str.getBytes()); // �޽��� ����
			out.flush();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				socket.close();
			} catch(Exception e) {
			}
		}
	}
}