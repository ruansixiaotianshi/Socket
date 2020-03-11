package cn.com.pb.multi;

import java.net.*;
import java.io.*;
public class LoginClient {
	public static void main(String[] args) {
		try {
			//�����ͻ���Socket���ӣ�ָ����������λ���Լ��˿�
			Socket socket=new Socket("localhost",8800);
			//�����������
			OutputStream os=socket.getOutputStream();
			InputStream is=socket.getInputStream();
			//�������л�
			ObjectOutputStream oos=new ObjectOutputStream(os);
			//���Ϳͻ��˵�¼��Ϣ�����������д����Ϣ
			User user=new User();
			user.setLoginName("Tom");
			user.setPwd("123456");
			oos.writeObject(user);
			socket.shutdownOutput();
		
			//���շ������ε���Ӧ��������������ȡ��Ϣ
			String reply=null;
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			while(!((reply=br.readLine())==null)){
				System.out.println("���ǿͻ��ˣ�����������ӦΪ��"+reply);
			}
			//4.�ر���Դ
			oos.close();
			is.close();		
			os.close();
			socket.close();
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
