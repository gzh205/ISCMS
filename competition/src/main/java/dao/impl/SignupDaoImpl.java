package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ISignupDao;
import entity.Signup;
import main.HibernateSessionFactory;

public class SignupDaoImpl implements ISignupDao{

	public void save(Signup org) {
		// TODO Auto-generated method stub
		//Hibernate经典编程步骤
        //1.获取Session
        Session session = HibernateSessionFactory.getSession();
        //2.打开事务
        Transaction tx = session.beginTransaction();
        //3.我们具体的CRUD操作
        //org.hibernate.Session中提供了CRUD方法
        session.save(org);
        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();		
	}

	@SuppressWarnings("unchecked")
	public List<Signup> getAll() {
		// TODO Auto-generated method stub
		List<Signup> sList = new ArrayList<Signup>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Signup";
        Query query = session.createQuery(hql);
        sList = (List<Signup>)query.list();
        transaction.commit();;
        session.close();
		return sList;
	}

	public Signup getData(int id) {
		// TODO Auto-generated method stub
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
        String hql = "from Signup s where s.id=:id";
        //获取    query对象
        Query query =  session.createQuery(hql).setParameter("id",id);
        Signup signup = (Signup) query.uniqueResult();//查询的结果是唯一的.
        //  String hql = "from User u where u.username=?";
        //  session.createQuery(hql).setParameter(1,username);
        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();
		return signup;
	}

	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "delete Signup s where s.id=:id";
		Query query = session.createQuery(hql).setParameter("id", id);
		query.executeUpdate();
		tran.commit();
		session.close();
	}

	public void alter(Signup u) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "UPDATE Signup s SET s.cNumber=:cNumber,s.cImg=:cImg,s.cInfo=:cInfo,s.uEmail=:uEmail  where s.id=:id";
		Query query = session.createQuery(hql).setParameter("cNumber", u.getcNumber()).setParameter("cImg", u.getcImg()).setParameter("cInfo", u.getcInfo()).setParameter("uEmail", u.getuEmail()).setParameter("id", u.getId());
		query.executeUpdate();
        session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Signup> userSignup(String email){
		List<Signup> sList = new ArrayList<Signup>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Signup s where s.uEmail=:email";
        Query query = session.createQuery(hql).setParameter("email", email);
        sList = (List<Signup>)query.list();
        transaction.commit();
        session.close();
		return sList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Signup> userComSignup(String info){
		List<Signup> sList = new ArrayList<Signup>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Signup s where s.cInfo=:cInfo";
        Query query = session.createQuery(hql).setParameter("cInfo", info);
        sList = (List<Signup>)query.list();
        transaction.commit();
        session.close();
		return sList;
	}
	
	public int getOrgCompete(String cInfo){
		Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select count(*) from Signup s where s.cInfo=:cInfo";
        Query query = session.createQuery(hql).setParameter("cInfo", cInfo);
        String n = query.uniqueResult().toString();
        transaction.commit();
        session.close();
        return Integer.parseInt(n);
	}
	
	public void review(Signup s){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "UPDATE Signup s SET s.isValid=:isValid where s.id=:id";
		Query query = session.createQuery(hql).setParameter("isValid", s.getIsValid()).setParameter("id", s.getId());
		query.executeUpdate();
        session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Signup> getCompeteList(String cInfo){
		List<Signup> list = new ArrayList<Signup>();
		Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Signup s where s.cInfo=:cInfo";
        Query query = session.createQuery(hql).setParameter("cInfo", cInfo);
        list = (List<Signup>)query.list();
        transaction.commit();
        session.close();
        return list;
	}

}
