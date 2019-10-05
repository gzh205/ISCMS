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

@Table(name = "sinup")
@Entity
public class Signup implements Serializable{
	private int id;
	private String cInfo;
	private String uEmail;
	private String cNumber;
	private String cImg;
	private String name;
	private int isValid;
	@Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public Signup setId(int id) {
		this.id = id;
		return this;
	}
	public String getcInfo() {
		return cInfo;
	}
	public Signup setcInfo(String cInfo) {
		this.cInfo = cInfo;
		return this;
	}
	public String getuEmail() {
		return uEmail;
	}
	public Signup setuEmail(String uEmail) {
		this.uEmail = uEmail;
		return this;
	}
	public String getcNumber() {
		return cNumber;
	}
	public Signup setcNumber(String cNumber) {
		this.cNumber = cNumber;
		return this;
	}
	@Lob 
	@Basic(fetch=FetchType.LAZY) 
	@Column(name="cImg", columnDefinition="BLOB", nullable=true)
	public String getcImg() {
		return cImg;
	}
	public Signup setcImg(String cImg) {
		this.cImg = cImg;
		return this;
	}
	public String getName(){
		return this.name;
	}
	public Signup setName(String name){
		this.name = name;
		return this;
	}
	public int getIsValid(){
		return this.isValid;
	}
	public Signup setIsValid(int dat){
		this.isValid = dat;
		return this;
	}
	@Override
	public String toString() {
		return "Signup [id=" + id + ", cInfo=" + cInfo + ", uEmail=" + uEmail + ", cNumber=" + cNumber + ", cImg="
				+ cImg + "]";
	}
}
