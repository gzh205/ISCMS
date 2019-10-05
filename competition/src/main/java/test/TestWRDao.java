package test;

import org.junit.Test;

import dao.impl.CompeteDaoImpl;
import dao.impl.SignupDaoImpl;

public class TestWRDao {
	@Test
	public void run(){
		System.out.println(new CompeteDaoImpl().selectOrg("1942592358@qq.com"));
	}
}
