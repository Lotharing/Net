package top.lothar.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 不同协议下可以指定相同端口，同一协议不可以
 * 
 * 必须先启动服务器，在连接
 * 
 * 发送数据+接收数据
 */


public class Server {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//创建服务器指定端口 ServerSocket(int port);
		ServerSocket server = new ServerSocket(8888);
		//接收客户端连接  阻塞式
		Socket socket = server.accept();
		
		System.out.println("一个客户端已连接");
		
		String str = "欢迎使用";
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		dos.writeUTF(str);
		
		dos.flush();
	}

}
