package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.SignupDaoImpl;
import entity.Signup;

@WebServlet(urlPatterns = "/changeSignupInfo")
public class ChangeSignup extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cInfo = req.getParameter("cInfo");
		String id = req.getParameter("id");
		String cName = req.getParameter("cName");
		String cNumber = req.getParameter("cNumber");
		if(cInfo==""||id==""||cName==""||cNumber==""){
			resp.sendRedirect("/competition/jsp/student/ChangeMySignup.jsp?error=0");
		}else{
			Signup s = new SignupDaoImpl().getData(Integer.parseInt(id));
			new SignupDaoImpl().alter(s.setcInfo(cInfo).setName(cName).setcNumber(cNumber));
			resp.sendRedirect("/competition/index.jsp");
		}
	}
}
