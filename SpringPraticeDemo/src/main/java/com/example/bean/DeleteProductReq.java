package com.example.bean;

import io.swagger.annotations.ApiModelProperty;

public class DeleteProductReq {
	@ApiModelProperty(value = "It indicates product id", required = true)
	private Integer productId;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
}


