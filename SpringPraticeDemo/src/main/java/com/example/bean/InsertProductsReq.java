package com.example.bean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class InsertProductsReq {
	@ApiModelProperty(value = "It indicates the organisation id", required = true)
	private Integer orgId;
	@ApiModelProperty(value = "It indicates the product list", required = true)
	private List<InsertProductBean> productList;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public List<InsertProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<InsertProductBean> productList) {
		this.productList = productList;
	}
	
	
}


