package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "todaycompete")
@Entity
public class TodayCompete implements Serializable{
	private String uEmail;
	private String cInfo;
	private String cTime;
	@Id
	public String getuEmail() {
		return uEmail;
	}
	public TodayCompete setuEmail(String uEmail) {
		this.uEmail = uEmail;
		return this;
	}
	public String getcInfo() {
		return cInfo;
	}
	public TodayCompete setcInfo(String cInfo) {
		this.cInfo = cInfo;
		return this;
	}
	public String getcTime() {
		return cTime;
	}
	public TodayCompete setcTime(String cTime) {
		this.cTime = cTime;
		return this;
	}
	@Override
	public String toString() {
		return "TodayCompete [uEmail=" + uEmail + ", cInfo=" + cInfo + ", cTime=" + cTime + "]";
	}
}
