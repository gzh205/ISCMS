package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019/1/18.
 */
//自动映射的表的名称
@Table(name="organizer")
//标识它是一个实体类
@Entity
public class Organizer implements Serializable{
    private String oemail;
    private String opassword;
    private String oinfo;
    private Integer id;

    public String getOemail() {
        return oemail;
    }

    public Organizer setOemail(String oemail) {
        this.oemail = oemail;
        return this;
    }

    public String getOpassword() {
        return opassword;
    }

    public Organizer setOpassword(String opassword) {
        this.opassword = opassword;
        return this;
    }

    public String getOinfo() {
        return oinfo;
    }

    public Organizer setOinfo(String oinfo) {
        this.oinfo = oinfo;
        return this;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "oemail='" + oemail + '\'' +
                ", opassword='" + opassword + '\'' +
                ", oinfo='" + oinfo + '\'' +
                ", id=" + id +
                '}';
    }
}
