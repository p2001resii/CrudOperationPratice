package com.example.bean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class UpdateProductsReq {
	@ApiModelProperty(value = "It indicates the organisation id", required = true)
	private Integer orgId;
	@ApiModelProperty(value = "It indicates the product list", required = true)
	private List<UpdateProductBean> productList;
	
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public List<UpdateProductBean> getProductList() {
		return productList;
	}
	public void setProductList(List<UpdateProductBean> productList) {
		this.productList = productList;
	}
	
	
}


