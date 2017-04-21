package com.paric.asset.bean;

import java.util.List;

public class TableBean<T> {
	private Integer page; //当前所在页
    private Integer rows; //每页显示的条数
    private String sidx; //排序的列
    private String sord; //排序规则:asc或desc
    
    private Integer totalRows; //查询出来的对象总条数
    private Integer totalPages; //根据totalRows计算出来的对象总页数
    private List<T> objectList; //查询出来的对象
    
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	
	public Integer getTotalPages() {
		if(totalRows != null && rows != null && totalRows.intValue() != 0){
			this.totalPages = new Double(Math.ceil(this.totalRows.doubleValue()/this.rows.doubleValue())).intValue();
			return totalPages;
		}
		return this.totalPages =0;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
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
