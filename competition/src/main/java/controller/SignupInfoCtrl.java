
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TransactionException;

import dao.impl.OrganizerDaoImpl;
import dao.impl.SignupDaoImpl;
import entity.Organizer;
import entity.Signup;
import tools.OutputExcel;

@WebServlet(urlPatterns = "/sinInfoAdmin")
public class SignupInfoCtrl extends HttpServlet{
	List<Signup> list;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("GET")) {
        	String para = req.getParameter("op");
        	if(para.equals("init")){
        		list = new SignupDaoImpl().getAll();
        		String dat = "";
        		if(list == null){
        			dat = "<div>什么也没找到</div>";
        		}else{
	        		for(int i=0;i<list.size();i++){
	        			Signup s = list.get(i);
	        			dat += "<tr>";
	        			dat += "<td>"+s.getId()+"</td>";
	        			dat += "<td>"+s.getuEmail()+"</td>";
	        			dat += "<td>"+s.getcInfo()+"</td>";
	        			dat += "<td>"+s.getcNumber()+"</td>";
	        			dat += "<td><a href='/competition/jsp/Admin/changeSignup.jsp?id="+s.getId()+"'>修改</a></td>";
	        			dat += "<td><a href='/competition/sinInfoAdmin?op=del&id="+s.getId()+"'>删除</a></td>";
	        		}
        		}
        		req.getSession().setAttribute("dat", dat);
        		resp.sendRedirect("/competition/jsp/Admin/signupInfoAdmin.jsp");
        	}else if(para.equals("xls")){
        		OutputExcel.listToExcel("主办方信息", OutputExcel.getSignupTitle(), OutputExcel.convertSignupData(list), OutputExcel.getTomcatPath(req) + "files/signupInfo.xls");
        		resp.sendRedirect("/competition/files/signupInfo.xls");
        	}else if(para.equals("del")){
        		try{
        			int id = Integer.parseInt(req.getParameter("id"));
        			new SignupDaoImpl().del(id);
        		}catch(TransactionException e){}finally{
        			resp.sendRedirect("/competition/sinInfoAdmin?op=init");
        		}
        	}
        }
	}
}
