package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.SignupDaoImpl;
import entity.Signup;

@WebServlet(urlPatterns = "/sinInfoChange")
public class SignupInfoChange extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("POST")) {
        	String sId = req.getParameter("id");
        	String sInfo = req.getParameter("info");
        	String sEmail = req.getParameter("email");
        	String sNumber = req.getParameter("number");
        	if(sId.isEmpty()||sInfo.isEmpty()||sEmail.isEmpty()||sNumber.isEmpty()){
        		resp.sendRedirect("/competition/jsp/Admin/changeSignup.jsp?error=0");
        	}else{
        		new SignupDaoImpl().alter(new Signup().setId(Integer.parseInt(sId)).setName(sInfo).setuEmail(sEmail).setcNumber(sNumber));
        		resp.sendRedirect("/competition/sinInfoAdmin?op=init");
        	}
        }
	}
}
