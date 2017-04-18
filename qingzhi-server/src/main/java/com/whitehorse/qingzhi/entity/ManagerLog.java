package com.whitehorse.qingzhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ManagerLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "manager_log")

public class ManagerLog implements java.io.Serializable {

	// Fields

	private Integer mlogId;
	private Integer mlogManagerId;
	private String mlogContent;
	private Integer mlogType;
	private Integer mlogCreateTime;
	private Integer mlogCreateIp;

	// Constructors

	/** default constructor */
	public ManagerLog() {
	}

	/** minimal constructor */
	public ManagerLog(Integer mlogManagerId, Integer mlogType, Integer mlogCreateTime, Integer mlogCreateIp) {
		this.mlogManagerId = mlogManagerId;
		this.mlogType = mlogType;
		this.mlogCreateTime = mlogCreateTime;
		this.mlogCreateIp = mlogCreateIp;
	}

	/** full constructor */
	public ManagerLog(Integer mlogManagerId, String mlogContent, Integer mlogType, Integer mlogCreateTime,
			Integer mlogCreateIp) {
		this.mlogManagerId = mlogManagerId;
		this.mlogContent = mlogContent;
		this.mlogType = mlogType;
		this.mlogCreateTime = mlogCreateTime;
		this.mlogCreateIp = mlogCreateIp;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "mlog_id", unique = true, nullable = false)

	public Integer getMlogId() {
		return this.mlogId;
	}

	public void setMlogId(Integer mlogId) {
		this.mlogId = mlogId;
	}

	@Column(name = "mlog_manager_id", nullable = false)

	public Integer getMlogManagerId() {
		return this.mlogManagerId;
	}

	public void setMlogManagerId(Integer mlogManagerId) {
		this.mlogManagerId = mlogManagerId;
	}

	@Column(name = "mlog_content", length = 65535)

	public String getMlogContent() {
		return this.mlogContent;
	}

	public void setMlogContent(String mlogContent) {
		this.mlogContent = mlogContent;
	}

	@Column(name = "mlog_type", nullable = false)

	public Integer getMlogType() {
		return this.mlogType;
	}

	public void setMlogType(Integer mlogType) {
		this.mlogType = mlogType;
	}

	@Column(name = "mlog_create_time", nullable = false)

	public Integer getMlogCreateTime() {
		return this.mlogCreateTime;
	}

	public void setMlogCreateTime(Integer mlogCreateTime) {
		this.mlogCreateTime = mlogCreateTime;
	}

	@Column(name = "mlog_create_ip", nullable = false)

	public Integer getMlogCreateIp() {
		return this.mlogCreateIp;
	}

	public void setMlogCreateIp(Integer mlogCreateIp) {
		this.mlogCreateIp = mlogCreateIp;
	}

}