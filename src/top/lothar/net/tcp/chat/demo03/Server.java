package top.lothar.net.tcp.chat.demo03;
/**
 * ������
 * 
 * ���ܶ���ͻ��ˣ������߳�
 * 
 * ���������Ŷ���ͻ���
 * 
 * ���������еĿͻ��˷��͸��Ѿ����ӵĿͻ���
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
	 * ��ͻ��˵Ľ����߳�
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
 * �ڲ��࣬�����ⲿ����
 * ��ÿ���ͻ��˴���һ���߳�
 * һ���ͻ���һ��CHannel���󣬷���List��ʵ�ֶ��̻߳��ഫ������
 * ������ ��������
 * ����� ��������	
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
				// TODO �Զ����ɵ� catch ��
				isRunning = false;
				CloseUtil.closeAll(dos,dis);
			}
		}
		/**
		 * ��������
		 * @return
		 */
		public String receive(){
			String msg = "";
			
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				isRunning = false;
				CloseUtil.closeAll(dis);
			}
			return msg;
		}
		/**
		 * ��������
		 * @param msg
		 */
		public void send(String msg){
			if(msg!=null && !msg.equals("")){
				try {
					dos.writeUTF(msg);
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					isRunning = false;
					CloseUtil.closeAll(dos);
					//�Ƴ���ǰ�ͻ��ˣ��Լ��������Լ���Ϣ
					list.remove(this);
				}
			}
		}
		/**
		 * ���͸������ͻ���
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
			// TODO �Զ����ɵķ������
			while(isRunning){
				sendOthers();			
			}
		}
	}
}


