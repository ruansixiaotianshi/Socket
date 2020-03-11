package cn.com.pb.base;

import java.net.*;
import java.io.*;
public class LoginClient {
	public static void main(String[] args) {
		try {
			//建立客户端Socket连接，指定服务器的位置以及端口
			Socket socket=new Socket("localhost",8800);
			//打开输入输出流
			OutputStream os=socket.getOutputStream();

			//发送客户端登录信息，即向输出流写入信息
			String info="用户名：Tom;用户密码：123456";
			os.write(info.getBytes());
		
			//关闭资源
		
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
