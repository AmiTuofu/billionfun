package com.billionfun.bms.product.mall.vo;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.billionfun.bms.product.mall.common.utils.PageUtil;
import com.billionfun.bms.product.mall.model.SysEvent;

public class SysEventVO extends PageUtil<SysEvent> {
	private String id;
	private String name;
	private String description;
	// @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy/MM/dd HH:mm:ss")
	private Date startDate;
	// @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format = "yyyy/MM/dd HH:mm:ss")
	private Date endDate;
	private Integer status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
