package cn.com.pb.multi;

import java.io.Serializable;
/**
 * �û���
 * */
public class User implements Serializable{
	private String loginName; //�û���
	private String pwd; //�û�����
	
	public User() {
	}
	public User(String loginName, String pwd) {
		super();
		this.loginName = loginName;
		this.pwd = pwd;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}

