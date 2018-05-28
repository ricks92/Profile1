package com.hsc.cat.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//New added class
@Entity
@Table(name="profile_details")
public class ProfileEntity {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="emp_id")
	private String empId;
	
	@Column(name="project_role")
	private String projectRole;
	
	@Column(name="description")
	private String description;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	public ProfileEntity() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "ProfileEntity [id=" + id + ", empId=" + empId + ", projectRole=" + projectRole + ", description="
				+ description + ", creationDate=" + creationDate + "]";
	}

	
	
	
	
}
