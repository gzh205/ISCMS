package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ISignupDao;
import dao.impl.SignupDaoImpl;
import entity.Signup;

@WebServlet(urlPatterns = "/userChangeSignup")
public class UserChangeSignup extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reqUrl = req.getHeader("referer");
		String id = req.getParameter("id");
		String cName = req.getParameter("cName");
		String cNumber = req.getParameter("cNumber");
		String img = GetImg.img;
		ISignupDao si = new SignupDaoImpl(); 
		Signup s = si.getData(Integer.parseInt(id));
		if(s == null){
			resp.sendRedirect(reqUrl+"?error=1");
		}else{
			if(img == null){
				resp.sendRedirect(reqUrl+"?error=3");
			}else{
				si.alter(s.setcImg(img).setcNumber(cNumber).setName(cName));
				resp.sendRedirect("/competition/competeInfo?webPageState=init");
			}
		}
	}
}
