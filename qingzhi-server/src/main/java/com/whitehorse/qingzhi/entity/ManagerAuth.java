package com.whitehorse.qingzhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ManagerAuth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "manager_auth")

public class ManagerAuth implements java.io.Serializable, Comparable<ManagerAuth> {

	// Fields

	private Integer mauthId;
	private String mauthName;
	private String mauthUrl;
	private Integer mauthStatus;
	private Integer mauthCreateTime;
	private Boolean mauthIsDelete;
	private Integer mauthDeleteTime;

	// Constructors

	/** default constructor */
	public ManagerAuth() {
	}

	/** minimal constructor */
	public ManagerAuth(String mauthName, String mauthUrl, Integer mauthStatus, Integer mauthCreateTime,
			Boolean mauthIsDelete) {
		this.mauthName = mauthName;
		this.mauthUrl = mauthUrl;
		this.mauthStatus = mauthStatus;
		this.mauthCreateTime = mauthCreateTime;
		this.mauthIsDelete = mauthIsDelete;
	}

	/** full constructor */
	public ManagerAuth(String mauthName, String mauthUrl, Integer mauthStatus, Integer mauthCreateTime,
			Boolean mauthIsDelete, Integer mauthDeleteTime) {
		this.mauthName = mauthName;
		this.mauthUrl = mauthUrl;
		this.mauthStatus = mauthStatus;
		this.mauthCreateTime = mauthCreateTime;
		this.mauthIsDelete = mauthIsDelete;
		this.mauthDeleteTime = mauthDeleteTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "mauth_id", unique = true, nullable = false)

	public Integer getMauthId() {
		return this.mauthId;
	}

	public void setMauthId(Integer mauthId) {
		this.mauthId = mauthId;
	}

	@Column(name = "mauth_name", nullable = false)

	public String getMauthName() {
		return this.mauthName;
	}

	public void setMauthName(String mauthName) {
		this.mauthName = mauthName;
	}

	@Column(name = "mauth_url", nullable = false)

	public String getMauthUrl() {
		return this.mauthUrl;
	}

	public void setMauthUrl(String mauthUrl) {
		this.mauthUrl = mauthUrl;
	}

	@Column(name = "mauth_status", nullable = false)

	public Integer getMauthStatus() {
		return this.mauthStatus;
	}

	public void setMauthStatus(Integer mauthStatus) {
		this.mauthStatus = mauthStatus;
	}

	@Column(name = "mauth_create_time", nullable = false)

	public Integer getMauthCreateTime() {
		return this.mauthCreateTime;
	}

	public void setMauthCreateTime(Integer mauthCreateTime) {
		this.mauthCreateTime = mauthCreateTime;
	}

	@Column(name = "mauth_is_delete", nullable = false)

	public Boolean getMauthIsDelete() {
		return this.mauthIsDelete;
	}

	public void setMauthIsDelete(Boolean mauthIsDelete) {
		this.mauthIsDelete = mauthIsDelete;
	}

	@Column(name = "mauth_delete_time")

	public Integer getMauthDeleteTime() {
		return this.mauthDeleteTime;
	}

	public void setMauthDeleteTime(Integer mauthDeleteTime) {
		this.mauthDeleteTime = mauthDeleteTime;
	}

	@Override
	public int compareTo(ManagerAuth o) {
		String[] thisAuth = this.getMauthName().split(":");
		String[] otherAuth = o.getMauthName().split(":");
		int min = Math.min(thisAuth.length, otherAuth.length);
		int result = 0;
		for (int i = 0; i < min; i++) {
			if (thisAuth[i].equals(otherAuth[i])) {
				continue;
			} else {
				if ("*".equals(thisAuth[i])) {
					result = 1;
				} else if ("*".equals(otherAuth[i])) {
					result = -1;
				} else {
					result = 0;
				}
				break;
			}

		}
		return result;
	}

}