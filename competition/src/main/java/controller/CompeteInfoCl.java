package controller;

import entity.Compete;
import entity.Organizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.util.Base64Decoder;

import dao.ICompeteDao;
import dao.IOrganizerDao;
import dao.impl.CompeteDaoImpl;
import dao.impl.OrganizerDaoImpl;

import java.io.IOException;
import java.util.List;
import sun.misc.*;

/**
 * Created by Administrator on 2019/1/21.
 */
@WebServlet(urlPatterns = "/competeInfo")
public class CompeteInfoCl extends HttpServlet{
    public static List<Compete> competeArray;
    private int pointer;
    private int max;
    private void showData(HttpServletRequest req) {
        req.getSession().setAttribute("max", "" + max);
        req.getSession().setAttribute("pointer", "" + pointer);
        req.getSession().setAttribute("cInfo", "");
        String str = "";
        for(int i=0;i<((pointer*5)>competeArray.size()?5-(pointer*5)+competeArray.size():5);i++){
        	new Base64Decoder();
			str += "<div onclick='selectedItem("+(i+1)+")'>"+
        			"<div class='row showItem' style='margin-left: 10px;margin-top: 10px;margin-right: 10px;'>"+
        			"<div class='col-md-4'>"+
        			"<img style='width: 100px;height: 100px;' src = '"+competeArray.get((pointer-1)*5+i).getcImg()+"'/>"+
        			"</div>"+
        			"<div class='col-md-8'>"+
        			"<div class='row'>"+
        			"<label class='titleFont'>"+
        			competeArray.get((pointer-1)*5+i).getcInfo()+
        			"</label>"+
        			"</div>"+
        			"<div class='row timeFont'>"+
        			"<div class='col-md-4'>"+
        			"<label>截止时间:</label>"+
        			"</div>"+
        			"<div class='col-md-8'>"+
        			"<label>"+competeArray.get((pointer-1)*5+i).getcTime()+"</label>"+
        			"</div></div></div></div></div>";
        }
        req.getSession().setAttribute("cInfo", str);
        return;
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("GET")) {
            String webPageState = req.getParameter("webPageState").toString();
            if (webPageState.equals("init")) {
                try {
                    ICompeteDao comDao = new CompeteDaoImpl();
                    this.competeArray = comDao.getAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(competeArray.size()!=0){
                	this.max = (competeArray.size() % 5 == 0) ? (competeArray.size() / 5) : (competeArray.size() / 5 + 1);
                	this.pointer = 1;                
                	showData(req);
                }
                else
                	req.getSession().setAttribute("cInfo","<div style='text-align:center;center,color:white'><h1>什么也没有找到</h1></div>");
                resp.sendRedirect("/competition/jsp/competition/showCompete.jsp");
            } else if(webPageState.equals("initWithoutSql")){
            	if(competeArray.size()!=0){
            		this.max = (competeArray.size() % 5 == 0) ? (competeArray.size() / 5) : (competeArray.size() / 5 + 1);
	                this.pointer = 1;
	                showData(req);
            	}
                else
                	req.getSession().setAttribute("cInfo","<div style='text-align;center,color:white'><h1>什么也没有找到</h1></div>");
                resp.sendRedirect("/competition/jsp/competition/showCompete.jsp");
            } else if (webPageState.equals("up") && pointer > 1) {
                pointer--;
                showData(req);
                resp.sendRedirect("/competition/jsp/competition/showCompete.jsp");
            } else if (webPageState.equals("down") && pointer < max) {
                pointer++;
                showData(req);
                resp.sendRedirect("/competition/jsp/competition/showCompete.jsp");
            } else if(webPageState.equals("selectedIndex")){
                String selected = req.getParameter("selectedIndex");
                int index = Integer.parseInt(selected);
                Compete c = competeArray.get((pointer - 1) * 5 + index - 1);
                System.out.println(c.getcInfo());
                req.getSession().setAttribute("comInfo", c.getcInfo());
                resp.sendRedirect("/competition/jsp/competition/showDetail.jsp");
            }
        }
        return;
    }
}
