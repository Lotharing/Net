package top.lothar.net.tcp.chat.demo02;
/**
 * 创建客户端  发送数据+接收服务器反馈数据
 * 
 * 写出数据  输出流
 * 
 * 读取数据 输入流
 * 
 * 下一步更新 应该把输入流和输出流分为两个线程 ，因为输入输出在聊天中没有先后顺序
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
