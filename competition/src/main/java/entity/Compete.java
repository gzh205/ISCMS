package entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019/1/21.
 */
@Table(name = "compete")
@Entity
public class Compete implements Serializable{
    private Integer cid;
    private String cInfo;
    private Float cFee;
    private String cTime;
    private String cImg;
    private String cRemark;
    private String oEmail;

    @Id
    @GeneratedValue
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcInfo() {
        return cInfo;
    }

    public Compete setcInfo(String cInfo) {
        this.cInfo = cInfo;
		return this;
    }

    public Float getcFee() {
        return cFee;
    }

    public Compete setcFee(Float cFee) {
        this.cFee = cFee;
        return this;
    }

    public String getcTime() {
        return cTime;
    }

    public Compete setcTime(String cTime) {
        this.cTime = cTime;
        return this;
    }

    @Lob 
	@Basic(fetch=FetchType.LAZY) 
	@Column(name="cImg", columnDefinition="BLOB", nullable=true)
    public String getcImg() {
        return cImg;
    }

    public Compete setcImg(String cImg) {
        this.cImg = cImg;
        return this;
    }

    public String getcRemark() {
        return cRemark;
    }

    public Compete setcRemark(String cRemark) {
        this.cRemark = cRemark;
        return this;
    }

    public String getoEmail() {
        return oEmail;
    }

    public Compete setoEmail(String oEmail) {
        this.oEmail = oEmail;
        return this;
    }

    @Override
    public String toString() {
        return "Compete{" +
                "cid=" + cid +
                ", cInfo='" + cInfo + '\'' +
                ", cFee=" + cFee +
                ", cTime='" + cTime + '\'' +
                ", cImg='" + cImg + '\'' +
                ", cRemark='" + cRemark + '\'' +
                ", oEmail='" + oEmail + '\'' +
                '}';
    }
}
