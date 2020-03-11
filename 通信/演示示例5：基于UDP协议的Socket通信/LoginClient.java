package cn.jbit.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * �ͻ���
 * */
public class LoginClient {
	public static void main(String[] args) {
		String info="���ã�������ѯһ�����⣡";
		byte[] infos=info.getBytes();
		DatagramSocket socket=null;
		try {
			InetAddress ia=InetAddress.getByName("localhost");
			//�����ͻ���Ҫ���͵����ݰ�����
			DatagramPacket dp=new DatagramPacket(infos, infos.length,ia,5000);
			//�ͻ�����Ҫһ��DatagramSocket����
			socket=new DatagramSocket();
			//ͨ��DatagramSocket���������ݰ���������
			socket.send(dp);
			
			//���շ���������Ӧ
			byte[] replys=new byte[1024];
			DatagramPacket dp1=new DatagramPacket(replys, replys.length);
			socket.receive(dp1);
			String reply=new String(dp1.getData(),0,dp1.getData().length);
			System.out.println("��������Ӧ��"+reply);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			socket.close();
		}

	}
}
