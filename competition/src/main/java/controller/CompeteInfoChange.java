package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CompeteDaoImpl;
import dao.impl.OrganizerDaoImpl;
import entity.Compete;
import entity.Organizer;

@WebServlet(urlPatterns = "/comInfoChange")
public class CompeteInfoChange extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("POST")) {
        	String info = req.getParameter("info");
        	String time = req.getParameter("time");
        	String fee = req.getParameter("fee");
        	String remark = req.getParameter("remark");
        	if(info.isEmpty()||time.isEmpty()||fee.isEmpty()||remark.isEmpty()){
        		resp.sendRedirect("/competition/jsp/Admin/changeCompete.jsp?error=0");
        	}else{
        		try{
	        		Compete c = new CompeteDaoImpl().getData(info);
	        		new CompeteDaoImpl().alter(c.setcFee(Float.parseFloat(fee)).setcTime(time).setcRemark(remark));       	
		        	resp.sendRedirect("/competition/orgInfoAdmin?op=init");
        		}catch(NumberFormatException ne){
        			resp.sendRedirect("/competition/jsp/Admin/changeCompete.jsp?error=1");
        		}
        	}
        }
	}
}
