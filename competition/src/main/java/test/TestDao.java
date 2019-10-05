package test;

import org.junit.Test;

import dao.impl.CompeteDaoImpl;
import dao.impl.OrganizerDaoImpl;
import dao.impl.SignupDaoImpl;
import dao.impl.TodayCompeteDaoImpl;
import entity.Compete;

public class TestDao {
	@Test
	public void testTodayCompete(){
		System.out.println(new CompeteDaoImpl().getAll());
	}
}
