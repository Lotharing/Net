package top.lothar.net.tcp.chat.demo01;
/**
 * ������
 * 
 * д������  ������  �ѿͻ�����������ܵ������� ����������������ȡ��������
 * 
 * д������  �����  �ѿͻ��˵��������� ��������Ž��ܵ�  �ڿͻ�������������ȡ
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
		
		//������ д������  ������   �������Կͻ���
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String msg = dis.readUTF();
		//д�������--��msg   �ͻ��˽���msg �����
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF("������-->"+msg);
		dos.flush();
		dos.close();
		
		dis.close();
	}
}
