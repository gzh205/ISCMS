package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TransactionException;

import dao.impl.UserDaoImpl;
import entity.User;
import tools.OutputExcel;

@WebServlet(urlPatterns = "/userInfoAdmin")
public class UserInfoCrtl extends HttpServlet{
	List<User> list;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("GET")) {
        	String para = req.getParameter("op");
        	if(para.equals("init")){
        		list = new UserDaoImpl().getAll();
        		String dat = "";
        		if(list == null){
        			dat = "<div>什么也没找到</div>";
        		}else{
	        		for(int i=0;i<list.size();i++){
	        			User u = list.get(i);
	        			dat += "<tr>";
	        			dat += "<td>"+u.getUemail()+"</td>";
	        			dat += "<td>"+u.getUpassword()+"</td>";
	        			dat += "<td>"+u.getUname()+"</td>";
	        			dat += "<td><a href='/competition/jsp/Admin/changeUser.jsp?email="+u.getUemail()+"'>修改</a></td>";
	        			dat += "<td><a href='/competition/userInfoAdmin?op=del&email="+u.getUemail()+"'>删除</a></td>";
	        		}
        		}
        		req.getSession().setAttribute("dat", dat);
        		resp.sendRedirect("/competition/jsp/Admin/userInfoAdmin.jsp");
        	}else if(para.equals("xls")){
        		OutputExcel.listToExcel("参赛者信息", OutputExcel.getUserTitle(), OutputExcel.convertUserData(list), OutputExcel.getTomcatPath(req) + "files/userInfo.xls");
        		resp.sendRedirect("/competition/files/userInfo.xls");
        	}else if(para.equals("del")){
        		try{
        			new UserDaoImpl().del(req.getParameter("email"));
        		}catch(TransactionException e){
        			//
        		}finally{
        			resp.sendRedirect("/competition/userInfoAdmin?op=init");
        		}
        	}
        }
	}
}
