package top.lothar.net.tcp.chat.demo01;
/**
 * 服务器
 * 
 * 写出数据  输入流  把客户端输出流进管道的数据 服务器用输入流读取保存起来
 * 
 * 写入数据  输出流  把客户端得来的数据 用输出流放进管道  在客户端用输入流读取
 * 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		
		ServerSocket socket = new ServerSocket(9999);
		
		Socket client = socket.accept();
		
		//服务器 写出数据  输入流   数据来自客户端
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		//写入服务器--》msg   客户端接收msg 并输出
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("服务器-->"+msg);
		dos.flush();
		dos.close();
		
		dis.close();
	}
}
