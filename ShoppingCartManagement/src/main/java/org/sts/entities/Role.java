package org.sts.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable=false, unique=true)
	private String name;
	
	private String description;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	
	@ManyToMany
	@JoinTable(name = "role_permission" , joinColumns = {
			@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
	inverseJoinColumns={@JoinColumn(name="PERM_ID", referencedColumnName="ID")})
	private List<Permission> permission;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Permission> getPermission() {
		return permission;
	}


	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}

}
