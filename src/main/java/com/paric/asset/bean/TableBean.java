package com.paric.asset.bean;

import java.util.List;

public class TableBean<T> {
	private Integer offset; //起始条数
    private Integer limit; //每页显示的条数
    private String sidx; //排序的列
    private String order; //排序规则:asc或desc
    private String search; //搜索条件(可能为""或null)
    
    private Integer totalRows; //查询出来的对象总条数
    
    private List<T> objectList; //查询出来的对象
    
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
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
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public List<T> getObjectList() {
		return objectList;
	}
	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
	}
    
}
