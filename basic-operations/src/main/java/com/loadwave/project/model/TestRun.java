package com.loadwave.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loadwave.project.audit.AuditModel;

@Entity
@Table(name="testrun")
public class TestRun extends AuditModel {
	
	@Id
	@GeneratedValue
	@Column(name="testrun_id")
	private Long testrun_Id;
	
	@Column(name="testrun_name")
	private String testrun_Name;
	
	
	@Column(name="tag")
	private String tag;
	
	@Column(name="resultpath")
	private String resultPath;
	
	@Column(name="user")
	private int user;
	
	@Column(name="location")
	private String location;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "test_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Test test;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public TestRun() {
		super();
	}

	public Long getTestrun_Id() {
		return testrun_Id;
	}

	public void setTestrun_Id(Long testrun_Id) {
		this.testrun_Id = testrun_Id;
	}

	public String getTestrun_Name() {
		return testrun_Name;
	}

	public void setTestrun_Name(String testrun_Name) {
		this.testrun_Name = testrun_Name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getResultPath() {
		return resultPath;
	}

	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	

	
	
	/*
	 * @Column(name="duration") private int duration;
	 */
	/*
	 * @Column(name="response_threshold") private int response_Threshold;
	 */
	
	
	

}
