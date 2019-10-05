package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IOrganizerDao;
import dao.IUserDao;
import dao.impl.OrganizerDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Organizer;
import entity.User;

@WebServlet(urlPatterns = "/changePwd")
public class ChangePwd extends HttpServlet{
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getSession().getAttribute("regEmail").toString();
		String emailNum = req.getSession().getAttribute("emailNum").toString();
		String emailInput = req.getParameter("num");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		String rdo = req.getParameter("radioOptions");
		if(!pwd1.equals(pwd2)||pwd1.isEmpty()){
			resp.sendRedirect("/competition/jsp/login/forgetPwd.jsp?error=3");
		}else if(!emailInput.equals(emailNum)){
			resp.sendRedirect("/competition/jsp/login/forgetPwd.jsp?error=2");
		}else{
			if(rdo.equals("rdo1")){
				IUserDao userDao = new UserDaoImpl();
				User u = userDao.getData(email);
				if(u==null){
					resp.sendRedirect("/competition/jsp/login/forgetPwd.jsp?error=4");
				}else{
					userDao.alter(u.setUpassword(pwd1));
					resp.sendRedirect("/competition/jsp/login/forgetPwd.jsp?error=10");
				}
			}else if(rdo.equals("rdo2")){
				IOrganizerDao orgDao = new OrganizerDaoImpl();
				Organizer o = orgDao.getData(email);
				if(o==null){
					resp.sendRedirect("/competition/jsp/login/forgetPwd.jsp?error=4");
				}else{
					orgDao.alter(o.setOpassword(pwd1));
					resp.sendRedirect("/competition/jsp/login/forgetPwd.jsp?error=10");
				}
			}
		}
	}
}
