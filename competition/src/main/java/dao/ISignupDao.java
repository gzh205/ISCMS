package dao;

import java.util.List;

import entity.Signup;

public interface ISignupDao {
	/**
     * 保存主办方
     * @param org
     */
    void save(Signup sign);

    /**
     * 根据用户名查找用户
     * @param email 传入的邮箱
     * @return 该邮箱对应的的单个主办方对象
     */
    Signup getData(int id);

    /**
     * 查看整张表
     * @return 该整张表的list对象
     */
    List<Signup> getAll();
    
    public void del(int id);
    
    public void alter(Signup u);
    
    public List<Signup> userSignup(String email);
    
    public int getOrgCompete(String cInfo);
    
    public List<Signup> userComSignup(String info);
    
    public void review(Signup s);

}
