package test;

import java.util.List;
import org.junit.Test;
import dao.IUserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import tools.OutputExcel;

public class TestOutputExcel {
	@Test
	public void test(){
		IUserDao userDao = new UserDaoImpl();
		List<User> u = userDao.getAll();
		OutputExcel.listToExcel("参赛者信息表", OutputExcel.getUserTitle(), OutputExcel.convertUserData(u),"C:");
	}
}
