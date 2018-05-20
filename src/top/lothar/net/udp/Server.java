package top.lothar.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * udp 对数据数据类型接收
 * @author Lothar
 *
 */
public class Server {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//创建服务端口
		DatagramSocket server = new DatagramSocket(8888);
		//准备接受容器
		byte [] container = new byte [1024];
		//容器封装为包
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//服务端接收数据
		server.receive(packet);
		//获取数据的字节并转换对应数据类型，分析数据
		double data = convert(packet.getData());
		//打印客户端发来的数据
		System.out.println(data);
		//释放
		server.close();
	}
	
	public static double convert(byte[] data) throws IOException{
		
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		
		double num = dis.readDouble();
		
		dis.close();
		
		
		return num;
	}
}
