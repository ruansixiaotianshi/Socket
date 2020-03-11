package cn.jbit.obj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ��������
 * */
public class LoginServer {
	public static void main(String[] args) {
		try {
			//1.����һ��������Socket
			ServerSocket serverSocket=new ServerSocket(5000);
			//2.ʹ��accept()�ȴ��ͻ���ͨ��
			Socket socket=serverSocket.accept();
			//3.����������������Ӧ���û�����
			InputStream is=socket.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			User user=(User)ois.readObject();
			System.out.println("���Ƿ����������յ�����Ϣ��"+user.getUserName()+"--"+user.getPwd());
			
			//���ͻ���һ����Ӧ
			String reply="��ӭ��¼��";
			byte[] replys=reply.getBytes();
			OutputStream os=socket.getOutputStream();
			os.write(replys);
			
			//4.�ͷ���Ӧ��Դ
			os.close();
			ois.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
