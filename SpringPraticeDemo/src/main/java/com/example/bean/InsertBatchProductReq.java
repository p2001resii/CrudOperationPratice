package com.example.bean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class InsertBatchProductReq {
	@ApiModelProperty(value = "It indicates the organisation id", required = true)
	private Long orgId;
	@ApiModelProperty(value = "It indicates the product list", required = true)
	private List<InsertProductBean> productList;
	
	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public List<InsertProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<InsertProductBean> productList) {
		this.productList = productList;
	}
	

}
