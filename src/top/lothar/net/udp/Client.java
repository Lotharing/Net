package top.lothar.net.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
/**
 * udp ���������ʹ������
 * @author Lothar
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		//�����ͻ��˿�
		DatagramSocket client = new DatagramSocket(6666);
		//׼������
		double num = 82.20;
		//����ת���ֽ�����
		byte [] data = convert(num);
		//��������͵ĵص�Ͷ˿ڣ�
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//����
		client.send(packet);
		//�ͷ�
		client.close();
	}
	/**
	 * �ֽ����������
	 * @param num
	 * @return
	 * @throws IOException
	 */
	public static byte[] convert(double num) throws IOException{
		
		byte[] data = null;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		DataOutputStream dos = new DataOutputStream(bos);
		
		dos.writeDouble(num);
		
		dos.flush();
		
		data = bos.toByteArray();
		
		return data;
		
	}
}
