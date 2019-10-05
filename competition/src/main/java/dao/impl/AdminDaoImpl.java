package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.IAdminDao;
import entity.Admin;
import java.util.ArrayList;
import java.util.List;
import main.HibernateSessionFactory;;

/**
 * Created by Administrator on 2019/2/9.
 */
public class AdminDaoImpl implements IAdminDao{
    public void save(Admin admin) {
        //Hibernate经典编程步骤
        //1.获取Session
        Session session = HibernateSessionFactory.getSession();
        //2.打开事务
        Transaction tx = session.beginTransaction();

        //3.我们具体的CRUD操作
        //org.hibernate.Session中提供了CRUD方法
        session.save(admin);

        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();
    }

    public Admin getData(String id) {
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

        String hql = "from Admin a where a.aID=:aID";
        //获取    query对象
        Query query =  session.createQuery(hql).setParameter("aID",id);
        Admin admin = (Admin) query.uniqueResult();//查询的结果是唯一的.

        //  String hql = "from User u where u.username=?";
        //  session.createQuery(hql).setParameter(1,username);

        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();

        return admin;
    }

    @SuppressWarnings("unchecked")
	public List<Admin> getAll() {
        List<Admin> userList = new ArrayList<Admin>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Admin";
        Query query = session.createQuery(hql);
        userList = (List<Admin>)query.list();
        transaction.commit();;
        session.close();
        return userList;
    }
}
