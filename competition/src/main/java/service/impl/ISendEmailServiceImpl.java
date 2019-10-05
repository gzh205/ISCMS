package service.impl;

import service.ISendEmailService;
import service.impl.MSender;
/**
 * Created by Administrator on 2019/1/17.
 */
public class ISendEmailServiceImpl implements ISendEmailService{
    MSender mSender = new MSender();
    static String num = "";//验证的数字
    boolean isSend = false;//是否发送过邮件

    public static String getNum(){
        return num;
    }

    public boolean getIsSend(){
        return isSend;
    }

    public boolean validNum(String input){
        if(num.equals(input))
            return true;
        else
            return false;
    }

    public ISendEmailServiceImpl setQQMailHost() {
        mSender.setHost("smtp.qq.com");
        mSender.setUser("2049192198@qq.com");
        mSender.setPwd("jqfjlgsfilsddagd");
        mSender.setFrom("2049192198@qq.com");
        mSender.setSubject("验证您的邮箱");
        return this;
    }
    
    public ISendEmailService setSubject(String c){
    	mSender.setSubject(c);
    	return this;
    }

    public ISendEmailServiceImpl setUserInfo(String userEmail){
        mSender.setTo(userEmail);
        return this;
    }

    public void send() {
        num = ""+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10);
        isSend = true;
        mSender.setText("欢迎您使用信息安全竞赛管理系统，您的验证码为：\t\n【"+num+"】\n若非本人操作，请忽略此邮件。");
        mSender.send();
    }
    
    public void send(String msg){
    	mSender.setText(msg);
    	mSender.send();
    }
}
