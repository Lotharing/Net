package top.lothar.net.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 解析URL
 * 组成： 协议    存放资源的主机域名	端口	资源文件名
 * 相对路径   绝对路径两种构建方式
 * @author Lothar
 *
 */
public class UrlDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO 自动生成的方法存根
		//绝对路径构建
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=lothar");
		System.out.println("协议"+url.getProtocol());
		System.out.println("域名"+url.getHost());
		System.out.println("端口"+url.getPort());
		System.out.println("资源"+url.getFile());
		System.out.println("相对路径"+url.getPath());
		System.out.println("锚点"+url.getRef());   //锚点
		System.out.println("参数"+url.getQuery());  //？参数  存在锚点时返回null，不存在返回正确
		
		//相对路径构建
		url = new URL("http://www.baidu.com:80/");
		url = new URL(url, "a.txt");
		System.out.println(url.toString());
	}

}
