package com.example.bean;

import java.util.List;

public class FetchProductResponse {
	
	private Long productId;
	private String productNm;
	private String productCategory;
	private Double productPrice;
	private Integer	productQty;
	private String manufacturer;
     private Integer versionId;
	
	private List<ProductBatchBean> BatchList;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductNm() {
		return productNm;
	}
	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductQty() {
		return productQty;
	}
	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public List<ProductBatchBean> getBatchList() {
		return BatchList;
	}
	public void setBatchList(List<ProductBatchBean> batchList) {
		BatchList = batchList;
	}
	
	}
	
	
	


