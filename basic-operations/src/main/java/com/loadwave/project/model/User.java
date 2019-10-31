package com.loadwave.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.loadwave.project.audit.AuditModel;

@Entity
@Table(name = "users")
public class User extends AuditModel{
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Long user_Id;
	
	@Column(name = "user_name", nullable = false)
	private String user_Name;
	
	@Column(name = "first_name", nullable = false)
	private String first_Name;
	
	@Column(name = "last_name", nullable = false)
	private String last_Name;
	
	//@Transient
	@Column(name = "password", nullable = false)
	private String password;
	
	
	@Column(name = "number_tests")
	private Integer number_Tests;
	
	@Column(name = "activation_code")
	private String activation_Code;
	
	@ManyToMany
	@JoinTable(name = "user_role", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> roles;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "account_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Account account;

	

	public void setAccount(Account account) {
		this.account = account;
	}

	public User() {
		super();
	}

	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNumber_Tests() {
		return number_Tests;
	}

	public void setNumber_Tests(Integer number_Tests) {
		this.number_Tests = number_Tests;
	}

	public String getActivation_Code() {
		return activation_Code;
	}

	public void setActivation_Code(String activation_Code) {
		this.activation_Code = activation_Code;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Account getAccount() {
		return account;
	}

	
	
	
	
	
	
	
	
	

}
