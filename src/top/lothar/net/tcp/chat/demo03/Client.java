package top.lothar.net.tcp.chat.demo03;
/*
 * 把输入流和输出流分为两个线程 ，因为输入输出在聊天中没有先后顺序
 * 
 */
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO 自动生成的方法存根
		Socket client = new Socket("localhost",9999);
		//发送数据的线程
		new Thread(new Send(client)).start();
		
		new Thread(new Receive(client)).start();
	}

}
