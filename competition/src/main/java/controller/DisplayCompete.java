package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICompeteDao;
import dao.ISignupDao;
import dao.impl.CompeteDaoImpl;
import dao.impl.SignupDaoImpl;
import entity.Compete;
import entity.Signup;
import tools.ShowArray;

@WebServlet(urlPatterns = "/displayCompete")
public class DisplayCompete extends HttpServlet{
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		String userType = req.getSession().getAttribute("userType").toString();
		if(userType.equals("org")){
			String data = "";
			String email = req.getSession().getAttribute("userEmail").toString();
			List<Compete> comList = new CompeteDaoImpl().selectOrg(email);
			if(comList.isEmpty()){
				data += "空空如也";
			}else{
				data += "<thead><tr><th style='text-align: center;color:white;'>竞赛名称</th><th style='text-align: center;color:white;'>开始日期</th><th style='text-align: center;color:white;'>报名人数</th></tr></thead><tbody>";
				ISignupDao s = new SignupDaoImpl();
				for(Compete c:comList){
					if(!ShowArray.isAfterToday(c.getcTime())){
						data += "<tr class='trStyle' onclick=\"location.href='/competition/jsp/student/downloadSignup.jsp?info=";
					}else{
						data += "<tr class='trStyle' onclick=\"location.href='/competition/jsp/competition/showAllSignup.jsp?info=";
					}
					data += "" + c.getcInfo() + "'\"><td>" + c.getcInfo() + "</td><td>" + c.getcTime() + "</td><td>" + s.getOrgCompete(c.getcInfo()) + "</td></tr>";
				}
				data += "</tbody>";
			}
			req.getSession().setAttribute("data", data);
			resp.sendRedirect("/competition/jsp/competition/userMyCompete.jsp");
		}else if(userType.equals("user")){
			String data = "";
			String email = req.getSession().getAttribute("userEmail").toString();
			List<Signup> signList = new SignupDaoImpl().userSignup(email);
			if(signList.isEmpty()){
				data += "您现在没有任何报名记录";
			}
			else{
				data += "<thead><tr><th style='text-align: center;color:white;'>竞赛名称</th><th style='text-align: center;color:white;'>开始时间</th><th style='text-align: center;color:white;'>身份证号</th><th style='text-align: center;color:white;'>审核是否通过</th></tr></thead><tbody>";
				ICompeteDao c = new CompeteDaoImpl();
				for(Signup s:signList){
					if(s.getIsValid()==1){
						data += "<tr class='trStyle' onclick=\"location.href='/competition/jsp/student/printSignup.jsp?id=" + s.getId() + "'\"><td>" + s.getcInfo() + "</td><td>" + c.getData(s.getcInfo()).getcTime() + "</td><td>" + s.getcNumber() + "</td>";
						data += "<td>" + "审核通过" + "</td></tr>";
					}else if(s.getIsValid()==0){
						data += "<tr class='trStyle' onclick=\"location.href='/competition/jsp/student/ChangeMySignup.jsp?id=" + s.getId() + "'\"><td>" + s.getcInfo() + "</td><td>" + c.getData(s.getcInfo()).getcTime() + "</td><td>" + s.getcNumber() + "</td>";
						data += "<td>" + "未审核" + "</td></tr>";
					}else{
						data += "<tr class='trStyle' onclick=\"location.href='/competition/jsp/student/ChangeMySignup.jsp?id=" + s.getId() + "'\"><td>" + s.getcInfo() + "</td><td>" + c.getData(s.getcInfo()).getcTime() + "</td><td>" + s.getcNumber() + "</td>";
						data += "<td>" + "审核不通过" + "</td></tr>";
					}
				}
				data += "</tbody>";
			}
			req.getSession().setAttribute("data", data);
			resp.sendRedirect("/competition/jsp/competition/userMyCompete.jsp");
		}else{
			resp.sendRedirect("/competition/jsp/competition/userMyCompete.jsp?error=0");
		}
	}
}
