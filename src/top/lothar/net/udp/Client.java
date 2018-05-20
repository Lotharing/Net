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
 * udp 对数据类型打包传输
 * @author Lothar
 *
 */
public class Client {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		//创建客户端口
		DatagramSocket client = new DatagramSocket(6666);
		//准备数据
		double num = 82.20;
		//数据转换字节数组
		byte [] data = convert(num);
		//打包（发送的地点和端口）
		DatagramPacket packet = new DatagramPacket(data, data.length,new InetSocketAddress("localhost",8888));
		//发送
		client.send(packet);
		//释放
		client.close();
	}
	/**
	 * 字节数字输出流
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
