package top.lothar.net.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
/**
 * udp �������������ͽ���
 * @author Lothar
 *
 */
public class Server {

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
		//��ȡ���ݵ��ֽڲ�ת����Ӧ�������ͣ���������
		double data = convert(packet.getData());
		//��ӡ�ͻ��˷���������
		System.out.println(data);
		//�ͷ�
		server.close();
	}
	
	public static double convert(byte[] data) throws IOException{
		
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		
		double num = dis.readDouble();
		
		dis.close();
		
		
		return num;
	}
}
