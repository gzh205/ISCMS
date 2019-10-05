package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.UserDaoImpl;
import entity.User;

@WebServlet(urlPatterns = "/userInfoChange")
public class UserInfoChange extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("POST")) {
        	String email = req.getParameter("email");
        	String pwd = req.getParameter("pwd");
        	String name = req.getParameter("name");
        	if(email.isEmpty()||pwd.isEmpty()||name.isEmpty()){
        		resp.sendRedirect("/competition/jsp/Admin/changeUser.jsp>error=0");
        	}
        	else{
	        	new UserDaoImpl().alter(new User().setUemail(email).setUpassword(pwd).setUname(name));
	        	resp.sendRedirect("/competition/userInfoAdmin?op=init");
        	}
        }
	}
}
