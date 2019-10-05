package test;

import org.junit.Test;

import service.impl.WebMagicPro;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

public class TestWebMagic {
	@Test
	public void Test(){
		WebMagicPro m = new WebMagicPro();
		Spider.create(m).addUrl(WebMagicPro.url).run();
		System.out.println(m.getFields().toString());
	}
}