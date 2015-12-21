package com.billionfun.bms.product.mall.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the sys_data_dictionary database table.
 * 
 */
@Entity
@Table(name="sys_data_dictionary")
@NamedQuery(name="SysDataDictionary.findAll", query="SELECT s FROM SysDataDictionary s")
public class SysDataDictionary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String code;

	private String name;

	@Column(name="parent_id")
	private BigInteger parentId;

	private int status;

	public SysDataDictionary() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigInteger getParentId() {
		return this.parentId;
	}

	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}