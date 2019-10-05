package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.ICompeteDao;
import entity.Compete;
import main.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/21.
 */

public class CompeteDaoImpl implements ICompeteDao{

    @SuppressWarnings("unchecked")
	public List<Compete> getAll() {
        List<Compete> userList = new ArrayList<Compete>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Compete";
        Query query = session.createQuery(hql);
        userList = (List<Compete>)query.list();
        transaction.commit();;
        session.close();
        return userList;
    }

    public Compete getData(String cInfo) {
        //Hibernate经典编程步骤
        //1.获取Session
        Session session = HibernateSessionFactory.getSession();
        //2.打开事务
        Transaction tx = session.beginTransaction();

        //3.我们具体的CRUD操作
        //org.hibernate.Session中提供了CRUD方法

        //HQL语法
        //:变量 是一个占位符
        //SQL = select * from tbl_user u where u.username = 'tom';

        // String hql = "from User u where u.username='"+username+"'";

        String hql = "from Compete c where c.cInfo=:cInfo";
        //获取    query对象
        Query query =  session.createQuery(hql).setParameter("cInfo",cInfo);
        Compete compete = (Compete) query.uniqueResult();//查询的结果是唯一的.

        //  String hql = "from User u where u.username=?";
        //  session.createQuery(hql).setParameter(1,username);

        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();

        return compete;
    }

    public void save(Compete compete) {
        //Hibernate经典编程步骤
        //1.获取Session
        Session session = HibernateSessionFactory.getSession();
        //2.打开事务
        Transaction tx = session.beginTransaction();

        //3.我们具体的CRUD操作
        //org.hibernate.Session中提供了CRUD方法
        session.save(compete);

        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();
    }

	public void del(String info) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "delete Compete c where c.cInfo=:cInfo";
		Query query = session.createQuery(hql).setParameter("cInfo", info);
		query.executeUpdate();
		tran.commit();
		session.close();
	}

	public void alter(Compete c) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "UPDATE Compete c SET c.cFee=:cFee,c.cTime=:cTime,c.cImg=:cImg,c.cRemark=cRemark  WHERE c.cInfo=:cInfo";
		Query query = session.createQuery(hql).setParameter("cFee", c.getcFee()).setParameter("cTime", c.getcTime()).setParameter("cImg", c.getcImg()).setParameter("cRemark", c.getcRemark()).setParameter("cInfo", c.getcInfo());
		query.executeUpdate();
        tran.commit();
        session.close();
	}
	
	public List<Compete> selectOrg(String email){
		List<Compete> userList = new ArrayList<Compete>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Compete c where c.oEmail=:email";
        Query query = session.createQuery(hql).setParameter("email", email);
        userList = (List<Compete>)query.list();
        transaction.commit();;
        session.close();
        return userList;
	}
}
