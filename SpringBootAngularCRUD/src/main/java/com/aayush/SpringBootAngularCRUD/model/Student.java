package com.aayush.SpringBootAngularCRUD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="stdtab")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer stdId;

	@Column(name="sname")
	private String stdName;
	
	@Column(name="sfee")
	private Double stdFee;
	
	@Column(name="scourse")
	private String stdCourse;
	
	@Column(name="sfeedisc")
	private Double stdFeeDisc;
	
	@Column(name="sfeegst")
	private Double stdFeeGst;
	
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public Double getStdFee() {
		return stdFee;
	}
	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}
	public String getStdCourse() {
		return stdCourse;
	}
	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}
	public Double getStdFeeDisc() {
		return stdFeeDisc;
	}
	public void setStdFeeDisc(Double stdFeeDisc) {
		this.stdFeeDisc = stdFeeDisc;
	}
	public Double getStdFeeGst() {
		return stdFeeGst;
	}
	public void setStdFeeGst(Double stdFeeGst) {
		this.stdFeeGst = stdFeeGst;
	}

 

}
