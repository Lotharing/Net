package top.lothar.net.tcp.chat.demo02;
/**
 * 服务器
 * 
 * 写出数据  输入流  把客户端输出流进管道的数据 服务器用输入流读取保存起来
 * 
 * 写入数据  输出流  把客户端得来的数据 用输出流放进管道  在客户端用输入流读取
 * 
 * 接受多条数据
 * 
 * 如果要接受多个客户端，还需要循环client  扔要加入线程
 * 
 * 不要关闭流，要不不能重复接受客户端数据
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
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		while(true){
			String msg = dis.readUTF();
			dos.writeUTF("服务器-->"+msg);
			dos.flush();
		}
	}
}
