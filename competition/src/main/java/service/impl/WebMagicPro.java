package service.impl;

import java.util.HashMap;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class WebMagicPro implements PageProcessor{
	
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
	public static final String url = "http://www.ciscn.cn/competition";
	private HashMap<String, String> fields = new HashMap<String, String>();
	private Integer num;
	
	public Site getSite() {
		// TODO Auto-generated method stub
		return site;
	}

	public void process(Page page) {
		// TODO Auto-generated method stub
		page.putField("name", page.getHtml().xpath("//*[@id='going']/div"));
		this.fields.put("first",page.getResultItems().get("name").toString());
		for(Integer i=1;;i++){
			page.putField(i.toString(), page.getHtml().xpath("//*[@id='end']/div["+i+"]"));
			String s = page.getResultItems().get(i.toString()).toString();
			if(s==null){
				page.setSkip(true);
				this.num = i-1;
				break;
			}else{
				this.fields.put(i.toString(), s);
			}
		}
	}
	
	public HashMap<String,String> getFields(){
		return this.fields;
	}
	
	public Integer getNum(){
		return this.num;
	}
}
