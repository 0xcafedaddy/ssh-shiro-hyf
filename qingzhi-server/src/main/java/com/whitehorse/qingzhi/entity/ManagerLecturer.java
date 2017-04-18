package com.whitehorse.qingzhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ManagerLecturer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "manager_lecturer")

public class ManagerLecturer implements java.io.Serializable {

	// Fields

	private Integer mlId;
	private Integer mlManagerId;
	private Integer mlLecturerId;
	private Integer mlStatus;
	private Integer mlCreateTime;
	private Integer mlUpdateTime;
	private Integer mlCreateIp;
	private Boolean mlIsDelete;
	private Integer mlDeleteTime;

	// Constructors

	/** default constructor */
	public ManagerLecturer() {
	}

	/** minimal constructor */
	public ManagerLecturer(Integer mlManagerId, Integer mlLecturerId, Integer mlStatus, Integer mlCreateTime,
			Integer mlUpdateTime, Integer mlCreateIp, Boolean mlIsDelete) {
		this.mlManagerId = mlManagerId;
		this.mlLecturerId = mlLecturerId;
		this.mlStatus = mlStatus;
		this.mlCreateTime = mlCreateTime;
		this.mlUpdateTime = mlUpdateTime;
		this.mlCreateIp = mlCreateIp;
		this.mlIsDelete = mlIsDelete;
	}

	/** full constructor */
	public ManagerLecturer(Integer mlManagerId, Integer mlLecturerId, Integer mlStatus, Integer mlCreateTime,
			Integer mlUpdateTime, Integer mlCreateIp, Boolean mlIsDelete, Integer mlDeleteTime) {
		this.mlManagerId = mlManagerId;
		this.mlLecturerId = mlLecturerId;
		this.mlStatus = mlStatus;
		this.mlCreateTime = mlCreateTime;
		this.mlUpdateTime = mlUpdateTime;
		this.mlCreateIp = mlCreateIp;
		this.mlIsDelete = mlIsDelete;
		this.mlDeleteTime = mlDeleteTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ml_id", unique = true, nullable = false)

	public Integer getMlId() {
		return this.mlId;
	}

	public void setMlId(Integer mlId) {
		this.mlId = mlId;
	}

	@Column(name = "ml_manager_id", nullable = false)

	public Integer getMlManagerId() {
		return this.mlManagerId;
	}

	public void setMlManagerId(Integer mlManagerId) {
		this.mlManagerId = mlManagerId;
	}

	@Column(name = "ml_lecturer_id", nullable = false)

	public Integer getMlLecturerId() {
		return this.mlLecturerId;
	}

	public void setMlLecturerId(Integer mlLecturerId) {
		this.mlLecturerId = mlLecturerId;
	}

	@Column(name = "ml_status", nullable = false)

	public Integer getMlStatus() {
		return this.mlStatus;
	}

	public void setMlStatus(Integer mlStatus) {
		this.mlStatus = mlStatus;
	}

	@Column(name = "ml_create_time", nullable = false)

	public Integer getMlCreateTime() {
		return this.mlCreateTime;
	}

	public void setMlCreateTime(Integer mlCreateTime) {
		this.mlCreateTime = mlCreateTime;
	}

	@Column(name = "ml_update_time", nullable = false)

	public Integer getMlUpdateTime() {
		return this.mlUpdateTime;
	}

	public void setMlUpdateTime(Integer mlUpdateTime) {
		this.mlUpdateTime = mlUpdateTime;
	}

	@Column(name = "ml_create_ip", nullable = false)

	public Integer getMlCreateIp() {
		return this.mlCreateIp;
	}

	public void setMlCreateIp(Integer mlCreateIp) {
		this.mlCreateIp = mlCreateIp;
	}

	@Column(name = "ml_is_delete", nullable = false)

	public Boolean getMlIsDelete() {
		return this.mlIsDelete;
	}

	public void setMlIsDelete(Boolean mlIsDelete) {
		this.mlIsDelete = mlIsDelete;
	}

	@Column(name = "ml_delete_time")

	public Integer getMlDeleteTime() {
		return this.mlDeleteTime;
	}

	public void setMlDeleteTime(Integer mlDeleteTime) {
		this.mlDeleteTime = mlDeleteTime;
	}

}