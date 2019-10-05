package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.IUserDao;
import entity.User;
import main.HibernateSessionFactory;
import java.util.*;

/**
 * 用户接口实现类
 * alt+enter
 */
public class UserDaoImpl implements IUserDao{
    public void save(User user) {
        //Hibernate经典编程步骤
        //1.获取Session
        Session session = HibernateSessionFactory.getSession();
        //2.打开事务
        Transaction tx = session.beginTransaction();
        //3.我们具体的CRUD操作
        //org.hibernate.Session中提供了CRUD方法
        session.save(user);
        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();
    }

    public User getData(String uemail) {
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
        String hql = "from User u where u.uemail=:uemail";
        //获取    query对象
        Query query =  session.createQuery(hql).setParameter("uemail",uemail);
        User user = (User) query.uniqueResult();//查询的结果是唯一的.
        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();
        return user;
    }
    
    @SuppressWarnings("unchecked")
	public List<User> getAll(){
        List<User> userList = new ArrayList<User>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from User";
        Query query = session.createQuery(hql);
        userList = (List<User>)query.list();
        transaction.commit();;
        session.close();
        return userList;
    }

	public void del(String email) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "delete User u WHERE uemail=:uemail";
		Query query = session.createQuery(hql).setParameter("uemail",email);
		query.executeUpdate();
        tran.commit();
        session.close();
	}
	
	public void alter(User u){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "UPDATE User u SET u.upassword=:upassword,uname=:uname  WHERE uemail=:uemail";
		Query query = session.createQuery(hql).setParameter("upassword", u.getUpassword()).setParameter("uname", u.getUname()).setParameter("uemail", u.getUemail());
		query.executeUpdate();
        //tran.commit();
        session.close();
	}
}
