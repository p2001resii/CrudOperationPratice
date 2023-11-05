package com.example.bean;

import java.sql.Date;

import io.swagger.annotations.ApiModelProperty;

public class FetchProductReq {
	@ApiModelProperty(value = "It is db generated id for particular product detail", required = true)
	private Long ProductId;
	@ApiModelProperty(value = "It indicates productNm of the product", required = true)
	private String productNm;
	@ApiModelProperty(value = "It indicates productCategory of the product", required = true)
	private String productCategory;
	@ApiModelProperty(value = "It indicates description of the product", required = true)
	private String description;
	@ApiModelProperty(value = "It indicates distributerNm of the product", required = true)
	private String distributerNm;
	@ApiModelProperty(value = "It indicates manufacturer of the product", required = true)
	private String manufacturer;
	@ApiModelProperty(value = "It indicates originCountry of the product", required = true)
    private String originCountry;
	@ApiModelProperty(value = "It indicates productPrice of the product", required = true)
	private Double productPrice;
	@ApiModelProperty(value = "It indicates productQty of the product", required = true)
	private Integer	productQty;
	@ApiModelProperty(value = "It indicates brandName of the product", required = true)
	private String brandName;
	@ApiModelProperty(value = "It indicates expiryDate of the product", required = true)
	private Date expiryDate;
	@ApiModelProperty(value = "It indicates weightUnit of the product", required = true)
	private String weightUnit;
	@ApiModelProperty(value = "It indicates color of the product", required = true)
	private String color; 
	@ApiModelProperty(value = "It indicates size of the product", required = true)
	private String size; 
	@ApiModelProperty(value = "It indicates productURL of the product", required = true)
	 private String productURL;
	@ApiModelProperty(value = "It indicates organisation id", required = true)
	 private Integer orgId;
	@ApiModelProperty(value = "It indicates isactive", required = true)
	 private Boolean isactive;
	@ApiModelProperty(value = "It indicates PageNo", required = true)
	 private Integer PageNo;
	 
	 
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDistributerNm() {
		return distributerNm;
	}
	public void setDistributerNm(String distributerNm) {
		this.distributerNm = distributerNm;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getProductURL() {
		return productURL;
	}
	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}
	public Integer getOrgId() {
		return orgId;
	}
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	public Integer getPageNo() {
		return PageNo;
	}
	public void setPageNo(Integer pageNo) {
		PageNo = pageNo;
	}
	 
	 
	

}
