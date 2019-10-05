package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ITodayCompeteDao;
import entity.TodayCompete;
import main.HibernateSessionFactory;

public class TodayCompeteDaoImpl implements ITodayCompeteDao{

	@SuppressWarnings("unchecked")
	public List<TodayCompete> get() {
		// TODO Auto-generated method stub
		List<TodayCompete> sList = new ArrayList<TodayCompete>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from TodayCompete";
        Query query = session.createQuery(hql);
        sList = (List<TodayCompete>)query.list();
        transaction.commit();;
        session.close();
		return sList;
	}
	
}
