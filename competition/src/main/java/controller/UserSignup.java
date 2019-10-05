package controller;

import java.io.IOException;
import tools.ShowArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CompeteDaoImpl;
import dao.impl.OrganizerDaoImpl;
import dao.impl.SignupDaoImpl;
import entity.Compete;
import entity.Organizer;
import entity.Signup;
import service.impl.ISendEmailServiceImpl;

@WebServlet(urlPatterns = "/usersignup")
public class UserSignup extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String email = req.getSession().getAttribute("userEmail").toString();
		String info = req.getParameter("cInfo");
		String name = req.getParameter("cName");
		String number = req.getParameter("cNumber");
		String img = GetImg.img;
		if(email.isEmpty()||info.isEmpty()||name.isEmpty()){
			resp.sendRedirect("/competition/jsp/competition/signup.jsp?error=0");
		}else{
			if(img==null){
				resp.sendRedirect("/competition/jsp/competition/signup.jsp?error=3");
			}else{
				if(!ShowArray.isInteger(number)){
					resp.sendRedirect("/competition/jsp/competition/signup.jsp?error=2");
				}else{
					Signup s = new Signup().setuEmail(email).setcInfo(info).setcImg(img).setName(name).setIsValid(0).setcNumber(number);
					new SignupDaoImpl().save(s);
					Compete c = new CompeteDaoImpl().getData(info);
					new ISendEmailServiceImpl().setQQMailHost().setUserInfo(c.getoEmail()).setSubject("信息安全竞赛管理系统").send("主办方:"+c.getoEmail()+"您有一条待审核的报名申请！\n请打开:http://127.0.0.1/competition/jsp/competition/review.jsp?id="+s.getId());
					resp.sendRedirect("/competition/competeInfo?webPageState=init");
				}
			}
		}
	}
}