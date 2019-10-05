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

/**
 * Created by Administrator on 2019/1/18.
 */
@WebServlet(urlPatterns = "/createUser")
public class CreateUser extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String email = req.getSession().getAttribute("regEmail").toString();
        String pwd1 = req.getParameter("pwd1");
        String pwd2 = req.getParameter("pwd2");
        String uname = req.getParameter("uname");
        String rdo = req.getParameter("radioOptions");
        if(!email.isEmpty()){
            if(!pwd1.isEmpty()){
                if(pwd1.equals(pwd2)){
                    if(!uname.isEmpty()){
	                    if (rdo.equals("rdo1")) {
	                        IUserDao userDao = new UserDaoImpl();
	                        User u = userDao.getData(email);
	                        if(u==null){
	                        	u = new User().setUemail(email).setUname(uname).setUpassword(pwd1);
	                        	userDao.save(u);
	                        	resp.getWriter().print("<script>alert('注册成功');</script>");
	                            resp.sendRedirect("/competition/jsp/login/finishReg.jsp");
	                        }else{
	                        	resp.sendRedirect("/competition/jsp/login/register.jsp?error=4");
	                        }
	                        
	                    } else {
	                        IOrganizerDao orgDao = new OrganizerDaoImpl();
	                        Organizer o = orgDao.getData(email);
	                        if(o==null){
	                        	o = new Organizer().setOemail(email).setOinfo(uname).setOpassword(pwd1);
	                        	orgDao.save(o);
	                        	resp.getWriter().print("<script>alert('注册成功');</script>");
	                            resp.sendRedirect("/competition/jsp/login/finishReg.jsp");
	                        }else{
	                        	resp.sendRedirect("/competition/jsp/login/register.jsp?error=4");
	                        }
	                    }
                    }
                    else{
                        resp.sendRedirect("/competition/jsp/login/register.jsp?error=3");
                    }
                }
                else{
                    resp.sendRedirect("/competition/jsp/login/register.jsp?error=2");
                }
            }else {
                resp.sendRedirect("/competition/jsp/login/register.jsp?error=1");
            }
        }else{
            resp.sendRedirect("/competition/jsp/login/register.jsp?error=0");
        }
    }
}
