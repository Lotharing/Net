package top.lothar.net.tcp.chat.demo03;

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
			// TODO 自动生成的 catch 块
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}
	
	public String receive(){
		String msg = "";
		
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			isRunning = false;
			CloseUtil.closeAll(dis);
		}
		return msg;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(isRunning){
			System.out.println(receive());
		}
	}

}
