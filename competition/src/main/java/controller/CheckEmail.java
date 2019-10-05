package controller;

import service.impl.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Administrator on 2019/1/17.
 */
@WebServlet(urlPatterns = "/checkemail")
public class CheckEmail extends HttpServlet{
    ISendEmailServiceImpl ises = new ISendEmailServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
        if(num.isEmpty()){
            resp.sendRedirect("/competition/jsp/login/checkEmail.jsp?error=2");
        }else{
            if(num.equals(ISendEmailServiceImpl.getNum())){
                resp.sendRedirect("/competition/jsp/login/register.jsp");
            }
            else{
                resp.sendRedirect("/competition/jsp/login/checkEmail.jsp?error=2");
            }
        }
    }
}
