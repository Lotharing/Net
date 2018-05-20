package top.lothar.net.ip;
/**
 * InetAddress 封装ip  dns
 * getHostAddress 返回ip地址
 * getHostName 返回域名，本机为计算机名
 * add.getLocalHost()  获取本机
 * getByName("localhost");   可以是域名 ， 也可以是ip地址
 * 
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {
	
	public static void main(String[] args) throws UnknownHostException {
		//创建inetAddress对象，获取本机
		InetAddress add = InetAddress.getLocalHost();
		
		System.out.println(add.getHostAddress());  //返回169.254.94.85
		System.out.println(add.getAddress());
		System.out.println(add.getHostName());    //计算机名
		System.out.println(add.getLocalHost());
		
		//根据域名
		add = InetAddress.getByName("www.baidu.com");
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
		
		add = InetAddress.getByName("61.135.253.15");
		System.out.println(add.getHostAddress());
		System.out.println(add.getHostName());
	}
}
