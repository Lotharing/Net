package top.lothar.net.tcp.chat.demo01;
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
		//控制台输入流
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		while(true){
			//得到控制到数据
			String info = console.readLine();
			// write写数据 输出到连接管道中   然后服务器会接收到用输入流取出
			dos.writeUTF(info);
			
			dos.flush();
			
			//服务器发送过来的数据 ，输入流 读取,获得数据
			String msg = dis.readUTF();
			
			System.out.println(msg);
		}
	}

}
