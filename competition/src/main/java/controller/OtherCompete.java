package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.WebMagicPro;
import us.codecraft.webmagic.Spider;

@WebServlet(urlPatterns = "/oCompete")
public class OtherCompete extends HttpServlet{
	WebMagicPro webmagic = new WebMagicPro();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		if(req.getMethod().equals("GET")){
			System.out.println("请稍后...");
			if(req.getParameter("op").equals("init")){
				Spider.create(webmagic).addUrl(WebMagicPro.url).thread(5).run();
				HashMap<String,String> fields = webmagic.getFields();
				String tmp = fields.get("first").toString();
				for(Integer i=1;i<webmagic.getNum();i++){
					tmp += fields.get(i.toString()).toString();
				}
				req.getSession().setAttribute("otherCompete", tmp);
			}
			resp.sendRedirect("/competition/jsp/competition/OtherCompete.jsp");
		}
	}
}
