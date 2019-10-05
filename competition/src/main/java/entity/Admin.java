package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2019/2/9.
 */
@Table(name = "admin")
@Entity
public class Admin implements Serializable {
    private String aID;
    private String aPassword;
    private String aName;
    private int id;

    public String getaID() {
        return aID;
    }

    public void setaID(String aID) {
        this.aID = aID;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aID='" + aID + '\'' +
                ", aPassword='" + aPassword + '\'' +
                ", aName='" + aName + '\'' +
                ", id=" + id +
                '}';
    }
}
