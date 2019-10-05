package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.OrganizerDaoImpl;
import entity.Organizer;

@WebServlet(urlPatterns = "/orgInfoChange")
public class OrgInfoAdd extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("POST")) {
        	String email = req.getParameter("email");
        	String pwd = req.getParameter("pwd");
        	String name = req.getParameter("name");
        	if(email.isEmpty()||pwd.isEmpty()||name.isEmpty()){
        		resp.sendRedirect("/competition/jsp/Admin/addOrg.jsp?error=0");
        	}else{
        		new OrganizerDaoImpl().alter(new Organizer().setOemail(email).setOpassword(pwd).setOinfo(name));	        	
	        	resp.sendRedirect("/competition/orgInfoAdmin?op=init");
        	}
        }
	}
}
