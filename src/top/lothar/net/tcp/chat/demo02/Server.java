package top.lothar.net.tcp.chat.demo02;
/**
 * ������
 * 
 * д������  ������  �ѿͻ�����������ܵ������� ����������������ȡ��������
 * 
 * д������  �����  �ѿͻ��˵��������� ��������Ž��ܵ�  �ڿͻ�������������ȡ
 * 
 * ���ܶ�������
 * 
 * ���Ҫ���ܶ���ͻ��ˣ�����Ҫѭ��client  ��Ҫ�����߳�
 * 
 * ��Ҫ�ر�����Ҫ�������ظ����ܿͻ�������
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
		
		//������ д������  ������   �������Կͻ���
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		while(true){
			String msg = dis.readUTF();
			dos.writeUTF("������-->"+msg);
			dos.flush();
		}
	}
}
