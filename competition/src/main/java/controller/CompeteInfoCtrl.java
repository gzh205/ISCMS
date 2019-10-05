package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TransactionException;

import dao.impl.CompeteDaoImpl;
import entity.Compete;
import tools.OutputExcel;

@WebServlet(urlPatterns = "/comInfoAdmin")
public class CompeteInfoCtrl extends HttpServlet{
	List<Compete> list;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		if (req.getMethod().equals("GET")) {
			String para = req.getParameter("op");
        	if(para.equals("init")){
        		list = new CompeteDaoImpl().getAll();
        		String dat = "";
        		if(list == null){
        			dat = "<div>什么也没找到</div>";
        		}else{
        			for(int i=0;i<list.size();i++){
        				Compete c = list.get(i);
	        			dat += "<tr>";
	        			dat += "<td>"+c.getcInfo()+"</td>";
	        			dat += "<td>"+c.getcTime()+"</td>";
	        			dat += "<td>"+c.getcFee()+"</td>";
	        			dat += "<td>"+c.getcRemark()+"</td>";
	        			dat += "<td><a href='/competition/jsp/Admin/changeCompete.jsp?info="+c.getcInfo()+"'>修改</a></td>";
	        			dat += "<td><a href='/competition/comInfoAdmin?op=del&info="+c.getcInfo()+"'>删除</a></td>";
        			}
        			req.getSession().setAttribute("dat", dat);
            		resp.sendRedirect("/competition/jsp/Admin/competeInfoAdmin.jsp");
        		}
        	}else if(para.equals("xls")){
        		OutputExcel.listToExcel("比赛信息", OutputExcel.getCompeteTitle(), OutputExcel.convertCompeteData(list), OutputExcel.getTomcatPath(req)+"files/competeInfo.xls");
        		resp.sendRedirect("/competition/files/competeInfo.xls");
        	}else if(para.equals("del")){
        		try{
        			String info = req.getParameter("info");
        			new CompeteDaoImpl().del(info);
        		}catch(TransactionException e){  			
        		}finally{
        			resp.sendRedirect("/competition/competeInfoAdmin?op=init");
        		}
        	}
        	
		}
	}
}
