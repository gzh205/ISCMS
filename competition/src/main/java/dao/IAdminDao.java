package dao;

import entity.Admin;
import java.util.List;

/**
 * Created by Administrator on 2019/2/9.
 */
public interface IAdminDao {
    /**
     * 保存用户
     * @param user
     */
    void save(Admin admin);

    /**
     * 根据用户名查找用户
     * @param username 传入的用户名
     * @return 该用户名对应的的单个用户对象
     */
    Admin getData(String id);

    /**
     * 查看整张表
     * @return 该整张表的list对象
     */
    List<Admin> getAll();
}
