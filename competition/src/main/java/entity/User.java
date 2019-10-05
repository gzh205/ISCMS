package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 用户实体类
 */
//自动映射的表的名称
@Table(name="user")
//标识它是一个实体类
@Entity
public class User implements Serializable{
    //对象标识
    private Integer id;
    //用户名
    private String uemail;
    //密码
    private String upassword;
    //标识
    private String uname;//0 代表超级管理员  1代表普通人员
    //提供空参构造
    public User(){

    }
    //快速生成带参构造以及getter/setter  toString
    //使用快捷键alt + insert
    //id属性是不需要提供的
    public User(String uemail, String upassword, String uname) {
        this.uemail = uemail;
        this.upassword = upassword;
        this.uname = uname;
    }
    //配置主键的生成策略
    //id是唯一的,自动生成的
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUemail() {
        return uemail;
    }
    public User setUemail(String uemail) {
        this.uemail = uemail;
        return this;
    }
    public String getUpassword() {
        return upassword;
    }
    public User setUpassword(String upassword) {
        this.upassword = upassword;
        return this;
    }
    public String getUname() {
        return uname;
    }
    public User setUname(String uname) {
        this.uname = uname;
        return this;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uemail='" + uemail + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }
}
