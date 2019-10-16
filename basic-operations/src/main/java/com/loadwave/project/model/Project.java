package com.loadwave.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "note", nullable = false)
	private String decs;
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "created_at", nullable = false, updatable = false)
	 * 
	 * @CreatedDate private Date createdAt;
	 */
	
	
	//private Date updatedAt;

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
		return decs;
	}

	public void setDecs(String decs) {
		this.decs = decs;
	}



	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", decs=" + decs + ", createdAt="
				 + "]";
	}
	


}
