package top.lothar.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MyServer {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		//��������˿�
		DatagramSocket server = new DatagramSocket(8888);
		//׼����������
		byte [] container = new byte [1024];
		//������װΪ��
		DatagramPacket packet = new DatagramPacket(container, container.length);
		//����˽�������
		server.receive(packet);
		//��ȡ���ݵ��ֽڣ���������
		byte [] data = packet.getData();
		//��ȡ�ֽڳ���
		int len = packet.getLength();
		//��ӡ�ͻ��˷���������
		System.out.println(new String(data,0,len));
		//�ͷ�
		server.close();
	}

}
