package test;

import org.junit.Test;
import service.IBaiduWordAnalysis;
import service.impl.BaiduWordAnalysisImpl;
import tools.ShowArray;

public class testBaiduWordAnalysis {
	@Test
	public void test(){	
		IBaiduWordAnalysis ib = new BaiduWordAnalysisImpl();
		String[] re = ib.convertResult(ib.getResult("显示由信息工程学院举办的比赛信息"));
		ShowArray.ShowStringArray(re);
	}
}
