package top.lothar.net.ip;
import java.net.InetAddress;
/**
 * 封装端口  在 InetAddress 基础上+端口
 */
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetsocketDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO 自动生成的方法存根
		
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
		//这里的getByName在InetSocketAddress中已经做出处理
		address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9999);
		
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	}

}
