package cn.com.pb.multi;

import java.net.*;
import java.io.*;
public class LoginServer {
	public static void main(String[] args)   {
		try {
			//����һ��������Socket��ServerSocket��ָ���˿ڲ���ʼ����
			ServerSocket serverSocket=new ServerSocket(8800);
			//ʹ��accept()�����ȴ��ͻ��˴���ͨ��
			Socket socket=null;
			//����һֱ������
			while(true){
				socket=serverSocket.accept();
				LoginThread LoginThread=new LoginThread(socket);
				LoginThread.start();
			}
		}  catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
