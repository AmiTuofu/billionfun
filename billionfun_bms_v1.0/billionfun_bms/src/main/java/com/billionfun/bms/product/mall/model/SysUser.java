package com.billionfun.bms.product.mall.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="sys_user",catalog="billionfun")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SysUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Long id;
	private String username;
	private String password;
	private String fullName;
	private Integer userType;
	private Integer provCode;
	private Integer cityCode;
	private Integer distCode;
	private Date effectStartDate;
	private Date effectEndDate;
	private String telephone;
	private String mobile;
	private String email;
	private String address;
	private Date createDate;
	private String createOptr;
	private String modifyOptr;
	private String remark;
	private Integer status;
	private String roleIds;
	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** full constructor */
	public SysUser(String username, String password, String fullName,
			Integer userType, Integer provCode, Integer cityCode,
			Date effectStartDate, Date effectEndDate, String telephone,
			String mobile, String email, String address, Date createDate,
			String createOptr, String modifyOptr, String remark, Integer status) {
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.userType = userType;
		this.provCode = provCode;
		this.cityCode = cityCode;
		this.effectStartDate = effectStartDate;
		this.effectEndDate = effectEndDate;
		this.telephone = telephone;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.createDate = createDate;
		this.createOptr = createOptr;
		this.modifyOptr = modifyOptr;
		this.remark = remark;
		this.status = status;
	}

	// Property accessors

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false,length=52)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false,length=52)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name", nullable = false,length=52)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getUserType() {
		return this.userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getProvCode() {
		return this.provCode;
	}

	public void setProvCode(Integer provCode) {
		this.provCode = provCode;
	}

	public Integer getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public Date getEffectStartDate() {
		return this.effectStartDate;
	}

	public void setEffectStartDate(Date effectStartDate) {
		this.effectStartDate = effectStartDate;
	}

	public Date getEffectEndDate() {
		return this.effectEndDate;
	}

	public void setEffectEndDate(Date effectEndDate) {
		this.effectEndDate = effectEndDate;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateOptr() {
		return this.createOptr;
	}

	public void setCreateOptr(String createOptr) {
		this.createOptr = createOptr;
	}

	public String getModifyOptr() {
		return this.modifyOptr;
	}

	public void setModifyOptr(String modifyOptr) {
		this.modifyOptr = modifyOptr;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDistCode() {
		return distCode;
	}

	public void setDistCode(Integer distCode) {
		this.distCode = distCode;
	}
}