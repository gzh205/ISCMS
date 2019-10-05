package dao;

import entity.User;
import java.util.*;

/**
 * 用户的业务接口
 * 接口是一个契约,规定了主要完成的功能,但是不关注具体怎么去是实现.
 * */
public interface IUserDao {
    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名查找用户
     * @param username 传入的用户名
     * @return 该用户名对应的的单个用户对象
     */
    User getData(String uemail);

    /**
     * 查看整张表
     * @return 该整张表的list对象
     */
    List<User> getAll();
    
    /**
     * 删除用户
     * @param email要删除的用户名 
     * */
    void del(String email);
    
    public void alter(User u); 
}
