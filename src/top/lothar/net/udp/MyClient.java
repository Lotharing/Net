package top.lothar.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class MyClient {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//创建客户端口
		DatagramSocket client = new DatagramSocket(6666);
		//准备数据
		String msg = "傻叉";
		//转换字节
		byte [] data = msg.getBytes();
		//打包（发送的地点和端口）
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//发送
		client.send(packet);
		//释放
		client.close();
	}

}
