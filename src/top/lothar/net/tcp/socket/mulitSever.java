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
 * 
 * while ��ѭ��ʹ�ͻ��˿���һֱ���ӷ�������ÿ���ͻ����ڷ������д��������ܽ�����һ���ͻ��˵�����
 * 
 * ���Ҫʹ����ͻ������ӷ�����  ������߳�  ����������
 */


public class mulitSever {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		//����������ָ���˿� ServerSocket(int port);
		ServerSocket server = new ServerSocket(8888);
		//���տͻ�������  ����ʽ
		while(true){
			
		Socket socket = server.accept();
		
		System.out.println("һ���ͻ���������");
		
		String str = "��ӭʹ��";
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		dos.writeUTF(str);
		
		dos.flush();
		
		}
	}

}
