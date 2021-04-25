package com.rain.domain;

import java.io.Serializable;

public class Notice  implements Serializable{
	private Integer id;
	private String title;
	private String pabulum;
	private String create_date;
	private String heat;
	private String price;
	private String type;
	private String remark;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPabulum() {
		return pabulum;
	}

	public void setPabulum(String pabulum) {
		this.pabulum = pabulum;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getHeat() {
		return heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Notice(){
		super();
	}
	
}
