package test;

import java.util.Date;

import org.junit.Test;

public class testTools {
	@SuppressWarnings("deprecation")
	@Test
	public void test1(){
		String[] str = "2019-5-2".split("-");
		System.out.println(str[0]+"/"+str[1]+"/"+str[2]);
	}
}
