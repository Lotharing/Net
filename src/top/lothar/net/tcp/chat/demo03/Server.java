package top.lothar.net.tcp.chat.demo03;
/**
 * 服务器
 * 
 * 接受多个客户端，加入线程
 * 
 * 创建容器放多个客户端
 * 
 * 遍历容器中的客户端发送给已经连接的客户端
 * 
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
	
	private List<Channel> list = new ArrayList<Channel>();
	
	public static void main(String[] args) throws IOException {
		
		new Server().start();
		
	}
	/**
	 * 与客户端的交互线程
	 * @throws IOException
	 */
	public void start() throws IOException{
		ServerSocket socket = new ServerSocket(9999);
		while(true){
			Socket client = socket.accept();
			Channel channel = new Channel(client);
			
			list.add(channel);
			
			new Thread(channel).start();
		}
	}
/**
 * 内部类，访问外部属性
 * 给每个客户端创建一个线程
 * 一个客户端一个CHannel对象，放入List中实现多线程互相传输数据
 * 输入流 发送数据
 * 输出流 接受数据	
 * @author Lothar
 *
 */
private	class Channel implements Runnable{
		
		private DataInputStream dis;
		
		private DataOutputStream dos;
		
		private boolean isRunning = true;
		
		public Channel(Socket client){
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				isRunning = false;
				CloseUtil.closeAll(dos,dis);
			}
		}
		/**
		 * 接受数据
		 * @return
		 */
		public String receive(){
			String msg = "";
			
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				isRunning = false;
				CloseUtil.closeAll(dis);
			}
			return msg;
		}
		/**
		 * 发送数据
		 * @param msg
		 */
		public void send(String msg){
			if(msg!=null && !msg.equals("")){
				try {
					dos.writeUTF(msg);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					isRunning = false;
					CloseUtil.closeAll(dos);
					//移除当前客户端，自己不接受自己消息
					list.remove(this);
				}
			}
		}
		/**
		 * 发送给其他客户端
		 */
		public void sendOthers(){
			
			String msg = receive();
			
			for(Channel channel : list){
				if(channel==this){
					continue;
				}
				channel.send(msg);
			}
		}
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while(isRunning){
				sendOthers();			
			}
		}
	}
}


