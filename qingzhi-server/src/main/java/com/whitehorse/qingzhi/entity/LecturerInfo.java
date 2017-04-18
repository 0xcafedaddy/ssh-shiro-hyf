package com.whitehorse.qingzhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * LecturerInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lecturer_info",uniqueConstraints = @UniqueConstraint(columnNames = "lecturer_user_id"))

public class LecturerInfo implements java.io.Serializable {

	// Fields

	private Integer lecturerId;
	private Integer lecturerUserId;
	private String lecturerName;
	private String lecturerWxName;
	private Integer lecturerCategoryId;
	private String lecturerHeadImage;
	private String lecturerIntroduction;
	private String lecturerEmail;
	private String lecturerMobilephone;
	private Double lecturerMoney;
	private Double lecturerIncomeRatio;
	private String lecturerCashPassword;
	private Integer lecturerStatus;
	private Integer lecturerCreateTime;
	private Integer lecturerUpdateTime;
	private Boolean lecturerIsDelete;
	private Integer lecturerDeleteTime;

	// Constructors

	/** default constructor */
	public LecturerInfo() {
	}

	/** minimal constructor */
	public LecturerInfo(Integer lecturerUserId, String lecturerName, String lecturerWxName, Integer lecturerCategoryId,
			String lecturerHeadImage, Double lecturerMoney, Double lecturerIncomeRatio, Integer lecturerStatus,
			Integer lecturerCreateTime, Integer lecturerUpdateTime, Boolean lecturerIsDelete) {
		this.lecturerUserId = lecturerUserId;
		this.lecturerName = lecturerName;
		this.lecturerWxName = lecturerWxName;
		this.lecturerCategoryId = lecturerCategoryId;
		this.lecturerHeadImage = lecturerHeadImage;
		this.lecturerMoney = lecturerMoney;
		this.lecturerIncomeRatio = lecturerIncomeRatio;
		this.lecturerStatus = lecturerStatus;
		this.lecturerCreateTime = lecturerCreateTime;
		this.lecturerUpdateTime = lecturerUpdateTime;
		this.lecturerIsDelete = lecturerIsDelete;
	}

	/** full constructor */
	public LecturerInfo(Integer lecturerUserId, String lecturerName, String lecturerWxName, Integer lecturerCategoryId,
			String lecturerHeadImage, String lecturerIntroduction, String lecturerEmail, String lecturerMobilephone,
			Double lecturerMoney, Double lecturerIncomeRatio, String lecturerCashPassword, Integer lecturerStatus,
			Integer lecturerCreateTime, Integer lecturerUpdateTime, Boolean lecturerIsDelete,
			Integer lecturerDeleteTime) {
		this.lecturerUserId = lecturerUserId;
		this.lecturerName = lecturerName;
		this.lecturerWxName = lecturerWxName;
		this.lecturerCategoryId = lecturerCategoryId;
		this.lecturerHeadImage = lecturerHeadImage;
		this.lecturerIntroduction = lecturerIntroduction;
		this.lecturerEmail = lecturerEmail;
		this.lecturerMobilephone = lecturerMobilephone;
		this.lecturerMoney = lecturerMoney;
		this.lecturerIncomeRatio = lecturerIncomeRatio;
		this.lecturerCashPassword = lecturerCashPassword;
		this.lecturerStatus = lecturerStatus;
		this.lecturerCreateTime = lecturerCreateTime;
		this.lecturerUpdateTime = lecturerUpdateTime;
		this.lecturerIsDelete = lecturerIsDelete;
		this.lecturerDeleteTime = lecturerDeleteTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "lecturer_id", unique = true, nullable = false)

	public Integer getLecturerId() {
		return this.lecturerId;
	}

	public void setLecturerId(Integer lecturerId) {
		this.lecturerId = lecturerId;
	}

	@Column(name = "lecturer_user_id", unique = true, nullable = false)

	public Integer getLecturerUserId() {
		return this.lecturerUserId;
	}

	public void setLecturerUserId(Integer lecturerUserId) {
		this.lecturerUserId = lecturerUserId;
	}

	@Column(name = "lecturer_name", nullable = false, length = 32)

	public String getLecturerName() {
		return this.lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	@Column(name = "lecturer_wx_name", nullable = false, length = 32)

	public String getLecturerWxName() {
		return this.lecturerWxName;
	}

	public void setLecturerWxName(String lecturerWxName) {
		this.lecturerWxName = lecturerWxName;
	}

	@Column(name = "lecturer_category_id", nullable = false)

	public Integer getLecturerCategoryId() {
		return this.lecturerCategoryId;
	}

	public void setLecturerCategoryId(Integer lecturerCategoryId) {
		this.lecturerCategoryId = lecturerCategoryId;
	}

	@Column(name = "lecturer_head_image", nullable = false)

	public String getLecturerHeadImage() {
		return this.lecturerHeadImage;
	}

	public void setLecturerHeadImage(String lecturerHeadImage) {
		this.lecturerHeadImage = lecturerHeadImage;
	}

	@Column(name = "lecturer_introduction", length = 16777215)

	public String getLecturerIntroduction() {
		return this.lecturerIntroduction;
	}

	public void setLecturerIntroduction(String lecturerIntroduction) {
		this.lecturerIntroduction = lecturerIntroduction;
	}

	@Column(name = "lecturer_email", length = 64)

	public String getLecturerEmail() {
		return this.lecturerEmail;
	}

	public void setLecturerEmail(String lecturerEmail) {
		this.lecturerEmail = lecturerEmail;
	}

	@Column(name = "lecturer_mobilephone", length = 64)

	public String getLecturerMobilephone() {
		return this.lecturerMobilephone;
	}

	public void setLecturerMobilephone(String lecturerMobilephone) {
		this.lecturerMobilephone = lecturerMobilephone;
	}

	@Column(name = "lecturer_money", nullable = false, precision = 10)

	public Double getLecturerMoney() {
		return this.lecturerMoney;
	}

	public void setLecturerMoney(Double lecturerMoney) {
		this.lecturerMoney = lecturerMoney;
	}

	@Column(name = "lecturer_income_ratio", nullable = false, precision = 4)

	public Double getLecturerIncomeRatio() {
		return this.lecturerIncomeRatio;
	}

	public void setLecturerIncomeRatio(Double lecturerIncomeRatio) {
		this.lecturerIncomeRatio = lecturerIncomeRatio;
	}

	@Column(name = "lecturer_cash_password", length = 10)

	public String getLecturerCashPassword() {
		return this.lecturerCashPassword;
	}

	public void setLecturerCashPassword(String lecturerCashPassword) {
		this.lecturerCashPassword = lecturerCashPassword;
	}

	@Column(name = "lecturer_status", nullable = false)

	public Integer getLecturerStatus() {
		return this.lecturerStatus;
	}

	public void setLecturerStatus(Integer lecturerStatus) {
		this.lecturerStatus = lecturerStatus;
	}

	@Column(name = "lecturer_create_time", nullable = false)

	public Integer getLecturerCreateTime() {
		return this.lecturerCreateTime;
	}

	public void setLecturerCreateTime(Integer lecturerCreateTime) {
		this.lecturerCreateTime = lecturerCreateTime;
	}

	@Column(name = "lecturer_update_time", nullable = false)

	public Integer getLecturerUpdateTime() {
		return this.lecturerUpdateTime;
	}

	public void setLecturerUpdateTime(Integer lecturerUpdateTime) {
		this.lecturerUpdateTime = lecturerUpdateTime;
	}

	@Column(name = "lecturer_is_delete", nullable = false)

	public Boolean getLecturerIsDelete() {
		return this.lecturerIsDelete;
	}

	public void setLecturerIsDelete(Boolean lecturerIsDelete) {
		this.lecturerIsDelete = lecturerIsDelete;
	}

	@Column(name = "lecturer_delete_time")

	public Integer getLecturerDeleteTime() {
		return this.lecturerDeleteTime;
	}

	public void setLecturerDeleteTime(Integer lecturerDeleteTime) {
		this.lecturerDeleteTime = lecturerDeleteTime;
	}

}