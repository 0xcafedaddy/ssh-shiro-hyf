package com.whitehorse.qingzhi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.shiro.codec.Base64;

/**
* @author hyf
* @date 2017年4月11日
* @description 
*/
@Entity
@Table(name = "manager_info")

public class ManagerInfo implements java.io.Serializable {

	// Fields

	private Integer managerId;
	private String managerName;
	private String managerAccount;
	private String managerPassword;
	private String managerEmail;
	private String managerMobilephone;
	private Integer managerStatus;
	private Integer managerGrade;
	private String managerAuth;
	private Integer managerCreateTime;
	private Integer managerUpdateTime;
	private Integer managerCreateIp;
	private Boolean managerIsDelete;
	private Integer managerDeleteTime;
	private String salt;
	// Constructors

	/** default constructor */
	public ManagerInfo() {
	}

	/** minimal constructor */
	public ManagerInfo(String managerName, String managerAccount, String managerPassword, Integer managerStatus,
			Integer managerGrade, Integer managerCreateTime, Integer managerUpdateTime, Integer managerCreateIp,
			Boolean managerIsDelete) {
		this.managerName = managerName;
		this.managerAccount = managerAccount;
		this.managerPassword = managerPassword;
		this.managerStatus = managerStatus;
		this.managerGrade = managerGrade;
		this.managerCreateTime = managerCreateTime;
		this.managerUpdateTime = managerUpdateTime;
		this.managerCreateIp = managerCreateIp;
		this.managerIsDelete = managerIsDelete;
	}

	/** full constructor */
	public ManagerInfo(String managerName, String managerAccount, String managerPassword, String managerEmail,
			String managerMobilephone, Integer managerStatus, Integer managerGrade, String managerAuth,
			Integer managerCreateTime, Integer managerUpdateTime, Integer managerCreateIp, Boolean managerIsDelete,
			Integer managerDeleteTime) {
		this.managerName = managerName;
		this.managerAccount = managerAccount;
		this.managerPassword = managerPassword;
		this.managerEmail = managerEmail;
		this.managerMobilephone = managerMobilephone;
		this.managerStatus = managerStatus;
		this.managerGrade = managerGrade;
		this.managerAuth = managerAuth;
		this.managerCreateTime = managerCreateTime;
		this.managerUpdateTime = managerUpdateTime;
		this.managerCreateIp = managerCreateIp;
		this.managerIsDelete = managerIsDelete;
		this.managerDeleteTime = managerDeleteTime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "manager_id", unique = true, nullable = false)

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	@Column(name = "manager_name", nullable = false, length = 32)

	public String getManagerName() {
		return this.managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	@Column(name = "manager_account", nullable = false, length = 32)

	public String getManagerAccount() {
		return this.managerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
	}

	@Column(name = "manager_password", nullable = false)

	public String getManagerPassword() {
		return this.managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	@Column(name = "manager_email", length = 64)

	public String getManagerEmail() {
		return this.managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	@Column(name = "manager_mobilephone", length = 64)

	public String getManagerMobilephone() {
		return this.managerMobilephone;
	}

	public void setManagerMobilephone(String managerMobilephone) {
		this.managerMobilephone = managerMobilephone;
	}

	@Column(name = "manager_status", nullable = false)

	public Integer getManagerStatus() {
		return this.managerStatus;
	}

	public void setManagerStatus(Integer managerStatus) {
		this.managerStatus = managerStatus;
	}

	@Column(name = "manager_grade", nullable = false)

	public Integer getManagerGrade() {
		return this.managerGrade;
	}

	public void setManagerGrade(Integer managerGrade) {
		this.managerGrade = managerGrade;
	}

	@Column(name = "manager_auth", length = 65535)

	public String getManagerAuth() {
		return this.managerAuth;
	}

	public void setManagerAuth(String managerAuth) {
		this.managerAuth = managerAuth;
	}

	@Column(name = "manager_create_time", nullable = false)

	public Integer getManagerCreateTime() {
		return this.managerCreateTime;
	}

	public void setManagerCreateTime(Integer managerCreateTime) {
		this.managerCreateTime = managerCreateTime;
	}

	@Column(name = "manager_update_time", nullable = false)

	public Integer getManagerUpdateTime() {
		return this.managerUpdateTime;
	}

	public void setManagerUpdateTime(Integer managerUpdateTime) {
		this.managerUpdateTime = managerUpdateTime;
	}

	@Column(name = "manager_create_ip", nullable = false)

	public Integer getManagerCreateIp() {
		return this.managerCreateIp;
	}

	public void setManagerCreateIp(Integer managerCreateIp) {
		this.managerCreateIp = managerCreateIp;
	}

	@Column(name = "manager_is_delete", nullable = false)

	public Boolean getManagerIsDelete() {
		return this.managerIsDelete;
	}

	public void setManagerIsDelete(Boolean managerIsDelete) {
		this.managerIsDelete = managerIsDelete;
	}

	@Column(name = "manager_delete_time")

	public Integer getManagerDeleteTime() {
		return this.managerDeleteTime;
	}

	public void setManagerDeleteTime(Integer managerDeleteTime) {
		this.managerDeleteTime = managerDeleteTime;
	}
	public void injectSalt(String salt){
		this.salt = salt;
	}
	public String obtainCredentialsSalt(){
		String salt = managerAccount+ managerName;
    	
    	
    	String base64Encoded = Base64.encodeToString(salt.getBytes());
    	
		return base64Encoded;
	}
}