package com.loadwave.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.loadwave.project.audit.AuditModel;

@Entity
@Table(name = "accounts")
public class Account extends AuditModel{

	
	@Id
	@GeneratedValue
	@Column(name="account_id")
	private Long account_Id;
	
	@Column(name = "account_name", nullable = false)
	private String account_Name;
	
	@Column(name = "note")
	private String desc;

	public Account() {
		super();
	}

	
	
	public Long getAccount_Id() {
		return account_Id;
	}

	public void setAccount_Id(Long account_Id) {
		this.account_Id = account_Id;
	}

	

	public String getAccount_Name() {
		return account_Name;
	}

	public void setAccount_Name(String account_Name) {
		this.account_Name = account_Name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	
}
