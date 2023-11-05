package com.example.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class UpdateBatchProductReq {
	//private Long orgId;

	@ApiModelProperty(value = "It is db generated id for particular product detail", required = true)
	private Long productId;
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
	@ApiModelProperty(value = "It indicates versions", required = true)
	private Integer versionId;
	@ApiModelProperty(value = "It indicates date and time modified", required = true)
	private Timestamp modifiedDttm;
	@ApiModelProperty(value = "It indicates product details list", required = true)
	private List<UpdateProductBean> productList;
	
//	public Long getOrgId() {
//		return orgId;
//	}
//	public void setOrgId(Long orgId) {
//		this.orgId = orgId;
//	}
	
	
	
	public List<UpdateProductBean> getProductList() {
		return productList;
	}
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
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public Timestamp getModifiedDttm() {
		return modifiedDttm;
	}
	public void setModifiedDttm(Timestamp modifiedDttm) {
		this.modifiedDttm = modifiedDttm;
	}
	public void setProductList(List<UpdateProductBean> productList) {
		this.productList = productList;
	}
	
}