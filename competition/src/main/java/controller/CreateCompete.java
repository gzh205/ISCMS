package controller;

import java.io.IOException;
import java.net.SocketTimeoutException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.impl.CompeteDaoImpl;
import entity.Compete;

@WebServlet(urlPatterns = "/createCompete")
public class CreateCompete extends HttpServlet{
	@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(req.getMethod().equals("POST")){
			req.setCharacterEncoding("utf-8");
			String info = req.getParameter("cInfo");
			String date = req.getParameter("cDate");
			String fee = req.getParameter("cFee");
			String remark = req.getParameter("cRemark");
			String img = GetImg.img;
			System.out.println("info="+info+"\ndate="+date+"\nfee="+fee+"\nremark="+remark);
			if(info.isEmpty()||date.isEmpty()||fee.isEmpty()||img==null||img.isEmpty()){
				resp.sendRedirect("/competition/jsp/competition/createCompete.jsp?error=0");
			}else{
				Compete c = new CompeteDaoImpl().getData(info);
				if(c!=null){
					resp.sendRedirect("/competition/jsp/competition/createCompete.jsp?error=1");
				}else{
					try{
						float f = Float.parseFloat(fee);
						Compete cDat = new Compete().setcFee(f).setcInfo(info).setcTime(date).setoEmail(req.getSession().getAttribute("userEmail").toString()).setcImg(GetImg.img).setcRemark(remark);
						new CompeteDaoImpl().save(cDat);
						resp.sendRedirect("/competition/jsp/competition/createCompete.jsp?error=5");
					}catch(NumberFormatException e){
						resp.sendRedirect("/competition/jsp/competition/createCompete.jsp?error=2");
					}catch(SocketTimeoutException se){
						resp.getWriter().print("alert('网络连接超时，请检查网络')");
					}catch(NullPointerException ne){
						resp.sendRedirect("/competition/jsp/competition/createCompete.jsp?error=3");
					}
				}
			}
		}
	}
}
