package top.lothar.net.tcp.chat.demo02;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
	
	private DataInputStream dis;
	
	private boolean isRunning = true;
	
	
	public Receive() {
		
	}
	public Receive(Socket client) {
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	
	public String receive(){
		String msg = "";
		
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(isRunning){
			System.out.println(receive());
		}
	}

}