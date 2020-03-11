package cn.com.pb.base;

import java.net.*;
import java.io.*;
public class LoginServer {
	public static void main(String[] args) {
		try {
			//����һ��������Socket��ServerSocket��ָ���˿ڲ���ʼ����
			ServerSocket serverSocket=new ServerSocket(8800);
			//ʹ��accept()�����ȴ��ͻ��˴���ͨ��
			Socket socket=serverSocket.accept();
			//�����������
			InputStream is=socket.getInputStream();
	
			//��ȡ�ͻ�����Ϣ��������������ȡ��Ϣ
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while(!((info=br.readLine())==null)){
				System.out.println("���Ƿ��������ͻ���¼��ϢΪ��"+info);
			}			

			//�ر���Դ
			br.close();	
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
