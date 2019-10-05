package dao;

import entity.Organizer;
import java.util.List;

/**
 * Created by Administrator on 2019/1/18.
 */
public interface IOrganizerDao {
    /**
     * 保存主办方
     * @param org
     */
    void save(Organizer org);

    /**
     * 根据用户名查找用户
     * @param email 传入的邮箱
     * @return 该邮箱对应的的单个主办方对象
     */
    Organizer getData(String email);

    /**
     * 查看整张表
     * @return 该整张表的list对象
     */
    List<Organizer> getAll();
    
    public void del(String email);
    
    public void alter(Organizer u);
}
