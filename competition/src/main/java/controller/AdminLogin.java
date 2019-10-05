package controller;

import dao.IAdminDao;
import dao.impl.AdminDaoImpl;
import entity.Admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2019/2/9.
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/adminLog")
public class AdminLogin extends HttpServlet {
    private Admin admin;
    private IAdminDao adminDao = new AdminDaoImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理一下post请求的乱码问题
        req.setCharacterEncoding("utf-8");
        //通过表单控件的name属性的值来获取表单中的数据
        String aid = req.getParameter("aID");
        String pwd = req.getParameter("pwd");
        admin = adminDao.getData(aid);
        if(admin == null){
            resp.sendRedirect("/competition/jsp/Admin/adminLogin.jsp?error=0");
        }else{
            if(admin.getaPassword().equals(pwd)){
                req.getSession().setAttribute("userType","admin");
                req.getSession().setAttribute("userName",admin.getaName());
                resp.sendRedirect("/competition/userInfoAdmin?op=init");
            }else{
                resp.sendRedirect("/competition/jsp/Admin/adminLogin.jsp?error=1");
            }
        }
    }
}
