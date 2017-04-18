package com.whitehorse.qingzhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user")

public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private Long organizationId;
	private String username;
	private String password;
	private String salt;
	private Boolean locked;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Long organizationId, String username, String password, String salt, Boolean locked) {
		this.organizationId = organizationId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.locked = locked;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "organization_id")

	public Long getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Column(name = "username", unique = true, length = 100)

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 100)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", length = 100)

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "locked")

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	public String obtainCredentialsSalt() {
        return username + salt;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", organizationId=" + organizationId + ", username=" + username + ", password="
				+ password + ", salt=" + salt + ", locked=" + locked + "]";
	}
	
}