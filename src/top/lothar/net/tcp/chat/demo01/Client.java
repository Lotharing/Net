package top.lothar.net.tcp.chat.demo01;
/**
 * �����ͻ���  ��������+���շ�������������
 * 
 * д������  �����
 * 
 * ��ȡ���� ������
 * 
 * ��һ������ Ӧ�ð����������������Ϊ�����߳� ����Ϊ���������������û���Ⱥ�˳��
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO �Զ����ɵķ������
		Socket client = new Socket("localhost",9999);
		//����̨������
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		DataInputStream dis = new DataInputStream(client.getInputStream());
		
		while(true){
			//�õ����Ƶ�����
			String info = console.readLine();
			// writeд���� ��������ӹܵ���   Ȼ�����������յ���������ȡ��
			dos.writeUTF(info);
			
			dos.flush();
			
			//���������͹��������� �������� ��ȡ,�������
			String msg = dis.readUTF();
			
			System.out.println(msg);
		}
	}

}
