package top.lothar.net.tcp.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ����TcpЭ��
 * �ͻ���ָ���������Ӷ˿�  ���ʱ���������
 * 
 * ��������+��������
 * @author Lothar
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO �Զ����ɵķ������
		Socket client = new Socket("localhost", 8888);
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		String str = dis.readUTF();
		
		System.out.println(str);
	}

}
