package cn.com.pb.base;

import java.net.*;
import java.io.*;
public class LoginClient {
	public static void main(String[] args) {
		try {
			//�����ͻ���Socket���ӣ�ָ����������λ���Լ��˿�
			Socket socket=new Socket("localhost",8800);
			//�����������
			OutputStream os=socket.getOutputStream();

			//���Ϳͻ��˵�¼��Ϣ�����������д����Ϣ
			String info="�û�����Tom;�û����룺123456";
			os.write(info.getBytes());
		
			//�ر���Դ
		
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
