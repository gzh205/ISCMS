package service.impl;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import dao.impl.TodayCompeteDaoImpl;
import entity.TodayCompete;
import service.ISendEmailService;

public class NoticeUser extends TimerTask{
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<TodayCompete> arr = new TodayCompeteDaoImpl().get();
		ISendEmailService ises = new ISendEmailServiceImpl().setQQMailHost().setSubject("您报名的比赛将在今天开始");
		Date d = new Date();
		String dataString = d.getYear() + "-" + d.getMonth() + "-" + d.getDay();
		for(TodayCompete tc:arr){
			if(tc.getcTime().equals(dataString))
				ises.setUserInfo(tc.getuEmail()).send(tc.getuEmail()+"：您报名的“"+tc.getcInfo()+"”将与今天开始，请勿忘记参加！");
		}
	}
}
