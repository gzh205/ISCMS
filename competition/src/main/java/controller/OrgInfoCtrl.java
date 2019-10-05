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
import dao.impl.UserDaoImpl;
import entity.Organizer;
import tools.OutputExcel;

@WebServlet(urlPatterns = "/orgInfoAdmin")
public class OrgInfoCtrl extends HttpServlet{
	List<Organizer> list;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("GET")) {
        	String para = req.getParameter("op");
        	if(para.equals("init")){
        		list = new OrganizerDaoImpl().getAll();
        		String dat = "";
        		if(list == null){
        			dat = "<div>什么也没找到</div>";
        		}else{
	        		for(int i=0;i<list.size();i++){
	        			Organizer u = list.get(i);
	        			dat += "<tr>";
	        			dat += "<td>"+u.getOemail()+"</td>";
	        			dat += "<td>"+u.getOpassword()+"</td>";
	        			dat += "<td>"+u.getOinfo()+"</td>";
	        			dat += "<td><a href='/competition/jsp/Admin/changeOrg.jsp?email="+u.getOemail()+"'>修改</a></td>";
	        			dat += "<td><a href='/competition/orgInfoAdmin?op=del&email="+u.getOemail()+"'>删除</a></td>";
	        		}
        		}
        		req.getSession().setAttribute("dat", dat);
        		resp.sendRedirect("/competition/jsp/Admin/orgInfoAdmin.jsp");
        	}else if(para.equals("xls")){
        		OutputExcel.listToExcel("主办方信息", OutputExcel.getOrgTitle(), OutputExcel.convertOrgData(list), OutputExcel.getTomcatPath(req) + "files/orgInfo.xls");
        		resp.sendRedirect("/competition/files/orgInfo.xls");
        	}else if(para.equals("del")){
        		try{
        			String email = req.getParameter("email");
        			new OrganizerDaoImpl().del(email);
        		}catch(TransactionException e){}finally{
        			resp.sendRedirect("/competition/orgInfoAdmin?op=init");
        		}
        	}
        }
	}
}