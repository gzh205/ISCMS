package service;

import service.impl.ISendEmailServiceImpl;

/**
 * Created by Administrator on 2019/1/17.
 */
public interface ISendEmailService {
	public boolean getIsSend();
	public boolean validNum(String input);
	public ISendEmailServiceImpl setQQMailHost();
	public ISendEmailServiceImpl setUserInfo(String userEmail);
	public void send();
	public void send(String str);
	public ISendEmailService setSubject(String c);
}
