package com.billionfun.bms.product.mall.common.utils;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.displaytag.properties.SortOrderEnum;
/**
 * 
 * @ClassName: PageUtil 
 * @Description: TODO
 * @author  AmiTuofu
 * @date  2015年12月20日 下午3:14:29 
 *
 * @param <T>
 */
public class PageUtil<T> {
	private List<T> list;
	private int pageNumber = 1;
	private int objectsPerPage = 15;
	private int fullListSize = 0;
	private String sortCriterion;
	private SortOrderEnum sortDirection = SortOrderEnum.ASCENDING;
	private String searchId;
	@SuppressWarnings("unused")
	private int totalPage = 0;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	public int getFullListSize() {
		return fullListSize;
	}

	public void setFullListSize(int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public String getSortCriterion() {
		return sortCriterion;
	}

	public void setSortCriterion(String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public SortOrderEnum getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(SortOrderEnum sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("pageNumber", pageNumber).append("objectsPerPage", objectsPerPage).append("fullListSize",
				fullListSize).append("sortCriterion", sortCriterion).append("sortDirection", sortDirection).append("searchId", searchId).toString();
	}

	public int getTotalPage() {
		if( this.fullListSize % this.objectsPerPage == 0){
			return this.fullListSize / this.objectsPerPage;
		}else{
			return this.fullListSize / this.objectsPerPage + 1;
		}
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
