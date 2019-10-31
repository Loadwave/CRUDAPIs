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
@Table(name = "projects")
public class Project extends AuditModel{

	@Id
	@GeneratedValue
	@Column(name="project_id")
	private Long projectId;

	@Column(name = "project_name", nullable = false)
	private String projectName;

	@Column(name = "note")
	private String desc;
	/* @Temporal(TemporalType.TIMESTAMP) 
	 * @Column(name = "created_at", nullable = false, updatable = false)
	 * @CreatedDate private Date createdAt;
	 */
	//private Date updatedAt;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_Id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Account  account;
	


	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public Project() {
		super();
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDecs() {
		return desc;
	}

	public void setDecs(String decs) {
		this.desc = decs;
	}

	



}
