package top.lothar.net.ip;
import java.net.InetAddress;
/**
 * ��װ�˿�  �� InetAddress ������+�˿�
 */
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetsocketDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		// TODO �Զ����ɵķ������
		
		InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
		//�����getByName��InetSocketAddress���Ѿ���������
		address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9999);
		
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
	}

}
