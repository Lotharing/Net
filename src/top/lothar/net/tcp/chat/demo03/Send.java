package top.lothar.net.tcp.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
	//����̨������
	private BufferedReader console;
	//�ܵ������
	private DataOutputStream dos;
	//�̱߳�ʶ
	private boolean isRunning = true;
	
	public Send(){
		console = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Send(Socket client){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			isRunning = false;
			CloseUtil.closeAll(dos,console);
		}
	}
	
	public String getMsgFromConsole(){
		try {
			return console.readLine();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return "";
	}
	
	public void send(){
		String msg = getMsgFromConsole();
		
		if(msg!=null && !msg.equals("")){
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				isRunning = false;
				CloseUtil.closeAll(dos,console);
			}
		}
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(isRunning){
			send();
		}
	}
}
