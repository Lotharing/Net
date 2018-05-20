package top.lothar.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {

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
		//获取数据的字节，分析数据
		byte [] data = packet.getData();
		//获取字节长度
		int len = packet.getLength();
		//打印客户端发来的数据
		System.out.println(new String(data,0,len));
		//释放
		server.close();
	}

}
