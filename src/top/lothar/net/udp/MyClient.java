package top.lothar.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;

public class MyClient {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		//�����ͻ��˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		String msg = "ɵ��";
		//ת���ֽ�
		byte [] data = msg.getBytes();
		//��������͵ĵص�Ͷ˿ڣ�
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//����
		client.send(packet);
		//�ͷ�
		client.close();
	}

}
