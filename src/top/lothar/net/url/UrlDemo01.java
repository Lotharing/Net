package top.lothar.net.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ����URL
 * ��ɣ� Э��    �����Դ����������	�˿�	��Դ�ļ���
 * ���·��   ����·�����ֹ�����ʽ
 * @author Lothar
 *
 */
public class UrlDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO �Զ����ɵķ������
		//����·������
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname=lothar");
		System.out.println("Э��"+url.getProtocol());
		System.out.println("����"+url.getHost());
		System.out.println("�˿�"+url.getPort());
		System.out.println("��Դ"+url.getFile());
		System.out.println("���·��"+url.getPath());
		System.out.println("ê��"+url.getRef());   //ê��
		System.out.println("����"+url.getQuery());  //������  ����ê��ʱ����null�������ڷ�����ȷ
		
		//���·������
		url = new URL("http://www.baidu.com:80/");
		url = new URL(url, "a.txt");
		System.out.println(url.toString());
	}

}
