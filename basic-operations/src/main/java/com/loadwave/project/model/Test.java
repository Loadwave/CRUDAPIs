package com.loadwave.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loadwave.project.audit.AuditModel;

@Entity
@Table(name="tests")
public class Test extends AuditModel{

	@Id
	@GeneratedValue
	@Column(name="test_id")
	private Long test_Id;

	@Column(name="test_name")
	private String test_Name;

	@Column(name="note")
	private String desc;

	@Column(name="test_Type_Id")
	private int  test_Type_Id;

	@Column(name="path")
	private String path;

	@Column(name="duration")
	private int duration;

	@Column(name="users")
	private int Users;


	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
	private Project project;

	public Test() {
		super();
	}

	public Long getTest_Id() {
		return test_Id;
	}

	public void setTest_Id(Long test_Id) {
		this.test_Id = test_Id;
	}

	public String getTest_Name() {
		return test_Name;
	}

	public void setTest_Name(String test_Name) {
		this.test_Name = test_Name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTest_Type_Id() {
		return test_Type_Id;
	}

	public void setTest_Type_Id(int test_Type_Id) {
		this.test_Type_Id = test_Type_Id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getUsers() {
		return Users;
	}

	public void setUsers(int users) {
		Users = users;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
