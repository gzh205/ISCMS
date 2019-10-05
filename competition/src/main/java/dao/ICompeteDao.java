package dao;

import entity.Compete;
import java.util.List;

/**
 * Created by Administrator on 2019/1/21.
 */
public interface ICompeteDao {
    /*
    *   得到竞赛表中的所有信息；
    *   返回值:关于竞赛信息的集合
    */
    List<Compete> getAll();

    /*
    *   得到竞赛表中的指定信息；
    *   参数:竞赛的信息
    *   返回值:查询到的竞赛信息，若没有查询到，则返回空
    */
    Compete getData(String cInfo);

    /*
    *   将指定信息指定信息保存到竞赛表中；
    *   参数:竞赛信息类
    */
    void save(Compete compete);
    
    public void del(String info);
    
    public void alter(Compete c);
    
    public List<Compete> selectOrg(String email);
}
