import java.net.InetAddress;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("郴 哪腔磐 IP 林家 : " +  local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP 林家 : " + remote.getHostAddress());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}