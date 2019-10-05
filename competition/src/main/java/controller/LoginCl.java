package controller;

import dao.IOrganizerDao;
import dao.IUserDao;
import dao.impl.OrganizerDaoImpl;
import dao.impl.UserDaoImpl;
import entity.Organizer;
import entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * MVC设计模式
 *
 * M (Model) - 模型层 (entity dao service test)
 * V (View) - 视图层 [由JSP技术]
 * C (Controller) - 控制层 (servlet)
 *
 */
@WebServlet(urlPatterns = "/logincl")
public class LoginCl extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //处理一下post请求的乱码问题
        req.setCharacterEncoding("utf-8");
        //通过表单控件的name属性的值来获取表单中的数据
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");
        String kap = req.getParameter("kaptcha");
        String googlecode = req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY).toString();
        String rdo = req.getParameter("radioOptions");
        Cookie cMail = new Cookie("name",email);
        Cookie cPwd = new Cookie("pwd",pwd);
        cMail.setMaxAge(60*60*24);
        cPwd.setMaxAge(60*60*24);
        resp.addCookie(cMail);
        resp.addCookie(cPwd);
        //判断是否是人在操作计算机(验证码校验)
        if(kap.equals(googlecode)) {
            //判断用户存在否
            try {
                if(rdo.equals("rdo1")) {
                    IUserDao userDao = new UserDaoImpl();
                    User u = userDao.getData(email);
                    if (null == u) {
                        //重定向到当前页面
                        resp.sendRedirect("/competition/jsp/login/login.jsp?error=0");
                    } else {
                        //用户是存在的,接下来判断密码...
                        if (u.getUpassword().equals(pwd)) {
                            req.getSession().setAttribute("userName",u.getUname());
                            req.getSession().setAttribute("userEmail",email);
                            req.getSession().setAttribute("userType","user");
                            resp.sendRedirect("/competition/competeInfo?webPageState=init");
                        } else {
                            resp.sendRedirect("/competition/jsp/login/login.jsp?error=1");
                        }
                    }
                }else{
                    IOrganizerDao orgDao = new OrganizerDaoImpl();
                    Organizer o = orgDao.getData(email);
                    if (null == o) {
                        //重定向到当前页面
                        resp.sendRedirect("/competition/jsp/login/login.jsp?error=0");
                    } else {
                        //用户是存在的,接下来判断密码...
                        if (o.getOpassword().equals(pwd)) {
                            req.getSession().setAttribute("userName",o.getOinfo());
                            req.getSession().setAttribute("userEmail",email);
                            req.getSession().setAttribute("userType","org");
                            resp.sendRedirect("/competition/competeInfo?webPageState=init");
                        } else {
                            resp.sendRedirect("/competition/jsp/login/login.jsp?error=1");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //决定最终跳转的去处...
        }else{
            resp.sendRedirect("/competition/jsp/login/login.jsp?error=2");
        }
    }
}
