package top.lothar.net.url;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * url.openStream 打开流
 * 获取资源 个人博客源代码  类似于爬虫
 * 利用装换流对字节码问题解决
 * @author Lothar
 *
 */
public class UrlDemo02 {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
//		netIo();
		netBuferedReaderIo();
	}
	
	/**
	 * 利用网络流拿源代码
	 * @throws IOException
	 */
	public static void netIo() throws IOException{
		
		URL url = new URL("http://www.lothar.top");
		//获取资源  网络流
		InputStream is = url.openStream();
		
		byte[] flush = new byte[1024];
		
		int len = 0;
		
		while(-1!=(len=is.read(flush))){
			
			String str = new String(flush,0,len);
			System.out.println(str);
		}
		is.close();
	}
	/**
	 * 转换流，更改解码方式
	 * 写入文件
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static void netBuferedReaderIo() throws UnsupportedEncodingException, IOException{
		
		URL url = new URL("http://www.lothar.top");
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(url.openStream(),"utf-8"));
		
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream("E:/lothar.txt"),"utf-8"));
		
		String msg = null;
		
		while((msg=br.readLine())!=null){
			
			bw.append(msg);
			//分行读取，记得换行
			bw.newLine();
			System.out.println(msg);
		}
		bw.flush();
		
		bw.close();
		br.close();
	}
}
