package com.pranjit.student.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "studentinfo")
public class StudentVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int slno;
	private int rollNo;
	private int PRN;
	private String fname;
	private String mname;
	private String lname;
	private String email;
	private String gender;
	private String sem;
	private String dept;
	public int getSlno() {
		return slno;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public int getPRN() {
		return PRN;
	}
	public void setPRN(int pRN) {
		PRN = pRN;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	@Override
	public String toString() {
		return "StudentVO [slno=" + slno + ", rollNo=" + rollNo + ", PRN=" + PRN + ", fname=" + fname + ", mname="
				+ mname + ", lname=" + lname + ", email=" + email + ", gender=" + gender + ", sem=" + sem + ", dept="
				+ dept + "]";
	}
	
	}
