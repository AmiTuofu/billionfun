package com.billionfun.bms.product.mall.common.utils;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName: PageUtil 
 * @Description: TODO
 * @author  AmiTuofu
 * @date  2015年12月20日 下午3:14:29 
 *
 * @param <T>
 */
@Component
public class PageUtil<T> {
	private int rows = 10;			//每页数据
	private int page = 1;			//当前页面
	private int total = 0;			//总页数
	private int records = 0;		//总条数
	private String sort;			//排序字段
	private String order;			//排序
	private String search;			//搜索
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		if( this.records % this.rows == 0){
			return this.records / this.rows;
		}else{
			return this.records / this.rows + 1;
		}
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getRows() {
		return rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
