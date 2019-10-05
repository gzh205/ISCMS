package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ICompeteDao;
import dao.impl.CompeteDaoImpl;
import entity.Compete;
import service.IBaiduWordAnalysis;
import service.impl.BaiduWordAnalysisImpl;
import tools.ShowArray;

@WebServlet(urlPatterns = "/searchCtrl")
public class SearchCtrl extends HttpServlet{
	 @Override
	 protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("utf-8");
		 String search = req.getParameter("strSearch");
		 IBaiduWordAnalysis ibwa = new BaiduWordAnalysisImpl();
		 String[] vitalWords = ibwa.convertResult(ibwa.getResult(search));
		 ShowArray.ShowStringArray(vitalWords);
		 ICompeteDao icd = new CompeteDaoImpl();
		 List<Compete> cData = icd.getAll();
		 System.out.println(cData);
		 List<Compete> rData = new ArrayList<Compete>();
		 for(Compete tmp:cData){
			 int count = 0;
			 for(int j=0;j<vitalWords.length;j++){
				 if(tmp.getcInfo().indexOf(vitalWords[j])!=-1){
					 count++;					 
				 }
			 }
			 if(tmp.getcInfo().indexOf(search)!=-1){
				 count++;
			 }
			 System.out.println(tmp.getcInfo()+":"+count);
			 if(count != 0){
				 rData.add(tmp);
			 }
		 }
		 CompeteInfoCl.competeArray = rData;
		 cData = null;
		 System.gc();
		 resp.sendRedirect("/competition/competeInfo?webPageState=initWithoutSql");
	 }
}