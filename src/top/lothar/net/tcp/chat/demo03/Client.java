package top.lothar.net.tcp.chat.demo03;
/*
 * �����������������Ϊ�����߳� ����Ϊ���������������û���Ⱥ�˳��
 * 
 */
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO �Զ����ɵķ������
		Socket client = new Socket("localhost",9999);
		//�������ݵ��߳�
		new Thread(new Send(client)).start();
		
		new Thread(new Receive(client)).start();
	}

}
