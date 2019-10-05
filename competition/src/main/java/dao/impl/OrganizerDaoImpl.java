package dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.IOrganizerDao;
import entity.Organizer;
import entity.User;
import main.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/18.
 */
public class OrganizerDaoImpl implements IOrganizerDao{

    public void save(Organizer org){
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

    public Organizer getData(String email){
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
        String hql = "from Organizer o where o.oemail=:email";
        //获取    query对象
        Query query =  session.createQuery(hql).setParameter("email",email);
        Organizer organizer = (Organizer) query.uniqueResult();//查询的结果是唯一的.
        //  String hql = "from User u where u.username=?";
        //  session.createQuery(hql).setParameter(1,username);
        //4.提交事务
        tx.commit();
        //5.关闭session
        session.close();
        return organizer;
    }

    @SuppressWarnings("unchecked")
	public List<Organizer> getAll(){
        List<Organizer> orgList = new ArrayList<Organizer>();
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Organizer";
        Query query = session.createQuery(hql);
        orgList = (List<Organizer>)query.list();
        transaction.commit();;
        session.close();
        return orgList;
    }
    
	public void del(String email) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "delete Organizer o where o.oemail=:oemail";
		Query query = session.createQuery(hql).setParameter("oemail", email);
		query.executeUpdate();
		tran.commit();
		session.close();
	}
	
	public void alter(Organizer o){
		Session session = HibernateSessionFactory.getSession();
		Transaction tran = session.getTransaction();
		String hql = "UPDATE Organizer u SET u.opassword=:opassword,u.oinfo=:oinfo  WHERE u.oemail=:oemail";
		Query query = session.createQuery(hql).setParameter("opassword", o.getOpassword()).setParameter("oinfo", o.getOinfo()).setParameter("oemail", o.getOemail());
		query.executeUpdate();
        session.close();
	}
}
