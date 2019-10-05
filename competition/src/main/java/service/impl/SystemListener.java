package service.impl;

import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SystemListener implements ServletContextListener {
	
	private java.util.Timer timer = null;

	@SuppressWarnings("deprecation")//Date.getHours该方法已经弃用
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		Date taskrun = new Date();
		System.out.println("taskrun:"+taskrun);
		timer = new Timer(true);
		sce.getServletContext().log("定时器启动");
		timer.schedule(new NoticeUser(),60*1000);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		timer.cancel();
		sce.getServletContext().log("定时器释放");
	}

}