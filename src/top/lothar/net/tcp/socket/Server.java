package top.lothar.net.tcp.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��ͬЭ���¿���ָ����ͬ�˿ڣ�ͬһЭ�鲻����
 * 
 * ������������������������
 * 
 * ��������+��������
 */


public class Server {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		//����������ָ���˿� ServerSocket(int port);
		ServerSocket server = new ServerSocket(8888);
		//���տͻ�������  ����ʽ
		Socket socket = server.accept();
		
		System.out.println("һ���ͻ���������");
		
		String str = "��ӭʹ��";
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		dos.writeUTF(str);
		
		dos.flush();
	}

}
