package top.lothar.net.tcp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 基于Tcp协议
 * 客户端指定服务器加端口  这个时候就在连接
 * 
 * 接收数据+发送数据
 * @author Lothar
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO 自动生成的方法存根
		Socket client = new Socket("localhost", 8888);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		String str = dis.readUTF();
		
		System.out.println(str);
	}

}
