package controller;

import service.impl.ISendEmailServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2019/1/17.
 */
@WebServlet(urlPatterns = "/sendemail")
public class SendEmail extends HttpServlet {
    ISendEmailServiceImpl ises = new ISendEmailServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String kap = req.getParameter("kaptcha");
        String reqUrl = req.getHeader("referer");
        String googlecode = req.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY).toString();
        System.out.println("kap:"+kap);
        System.out.println("googlecode:"+googlecode);
        if(reqUrl.indexOf("?error=")!=-1)
        	reqUrl = reqUrl.replaceAll("?error=[0-9]", "");
        if (kap.equals(googlecode)) {
            if (email.isEmpty()) {           		
                resp.sendRedirect(reqUrl+"?error=0");
            } else {
                ises.setQQMailHost().setUserInfo(email).send();
                if (ises.getIsSend()) {
                    HttpSession session = req.getSession();
                    session.setAttribute("emailNum", ISendEmailServiceImpl.getNum());
                    session.setAttribute("regEmail",email);
                }
                resp.sendRedirect(reqUrl);
            }
        }else{
            resp.sendRedirect(reqUrl+"?error=1");
        }
    }
}
