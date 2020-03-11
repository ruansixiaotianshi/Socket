package cn.jbit.udpDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 * ��������
 * */
public class LoginServer {
	public static void main(String[] args) {
		byte[] infos=new byte[1024];
		DatagramPacket dp=new DatagramPacket(infos, infos.length);
		DatagramSocket socket=null;
		try {
			socket=new DatagramSocket(5000);
			//���տͻ��˵����ݰ���������Ϣ��װ��dp��
			socket.receive(dp);
			
			//����һ���ַ���
			String info=new String(dp.getData(),0,dp.getData().length);
			System.out.println("�ͻ���˵��"+info);
			
			//���ͻ���һ����Ӧ
			String reply="���ã����ڣ���˵��";
			//�ͻ��˵ĵ�ַ
			SocketAddress sa=dp.getSocketAddress();
			//��һ������
			DatagramPacket dp1=
					new DatagramPacket(reply.getBytes(),0,reply.getBytes().length,sa);
			//����������
			socket.send(dp1);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			socket.close();
		}
		
	}
}
