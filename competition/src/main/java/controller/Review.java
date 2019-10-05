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

@WebServlet(urlPatterns = "/review")
public class Review extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String isValid = req.getParameter("isValid");
		String id = req.getParameter("id");
		ISignupDao is = new SignupDaoImpl();
		Signup s = is.getData(Integer.parseInt(id));
		System.out.println("审核情况："+isValid);
		if(isValid.equals("on")){
			s.setIsValid(1);
		}else{
			s.setIsValid(-1);
		}
		is.review(s);
		resp.sendRedirect("/competition/jsp/competition/showAllSignup.jsp");
	}
}
