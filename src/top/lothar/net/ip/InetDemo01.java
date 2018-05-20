package top.lothar.net.ip;
/**
 * InetAddress ��װip  dns
 * getHostAddress ����ip��ַ
 * getHostName ��������������Ϊ�������
 * add.getLocalHost()  ��ȡ����
 * getByName("localhost");   ���������� �� Ҳ������ip��ַ
 * 
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {
	
	public static void main(String[] args) throws UnknownHostException {
		//����inetAddress���󣬻�ȡ����
		InetAddress add = InetAddress.getLocalHost();
		
		System.out.println(add.getHostAddress());  //����169.254.94.85
		System.out.println(add.getAddress());
		System.out.println(add.getHostName());    //�������
		System.out.println(add.getLocalHost());
		
		//��������
		add = InetAddress.getByName("www.baidu.com");
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
		
		add = InetAddress.getByName("61.135.253.15");
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
	}
}
