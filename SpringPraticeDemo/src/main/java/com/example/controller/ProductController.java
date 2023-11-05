package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.DeleteProductReq;
import com.example.bean.FetchProductReq;
import com.example.bean.FetchProductResponse;
import com.example.bean.FetchProductsReq;
import com.example.bean.InsertBatchProductReq;
import com.example.bean.InsertFetchProductReq;
import com.example.bean.InsertProductReq;
import com.example.bean.InsertProductsReq;
import com.example.bean.UpdateBatchProductReq;
import com.example.bean.UpdateProductReq;
import com.example.bean.UpdateProductsReq;
import com.example.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
     
	@ApiResponses(value = {

			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error"), @ApiResponse(code = 400, message = "Bad request")

	})

	@ApiOperation(value = "This api is used to insert product details.", response = InsertProductReq.class, responseContainer = "INSERT")
	@PostMapping("/insertProductDetatils")
	public Boolean insertProductDetails(@RequestBody InsertProductReq insertProductReq) {
		return productService.insertProductDetails(insertProductReq);
	}
	
	@ApiOperation(value = "This api is used to insert product details.", response = InsertProductReq.class, responseContainer = "INSERT")
	@PostMapping("/insetByMapSqlParameterSource")
	public Boolean insertProductDetailsByUsingMapSql(@RequestBody InsertProductReq insertProductReq) {
		return productService.insertProductDetailsByUsingMapSql(insertProductReq);
	}
	
	@ApiOperation(value = "This api is used to insert product details.", response = InsertProductReq.class, responseContainer = "INSERT")
	@PostMapping("/insetByBeanPropertySqlParameterSource")
	public Boolean insertProductDetailsByBeanProperty(@RequestBody InsertProductReq insertProductReq) {
		return productService.insertProductDetailsByBeanProperty(insertProductReq);
	}
    
	@ApiOperation(value = "This api is used to update person details ", response = UpdateProductReq.class, responseContainer = "UPDATE")
	@PutMapping("/updateProduct")
	public Boolean updateProductDetails(@RequestBody UpdateProductReq updateProductReq) {
		return productService.updateProductDetails(updateProductReq);
	}
	
	@ApiOperation(value = "This api is used to update person details ", response = UpdateProductReq.class, responseContainer = "UPDATE")
	@PutMapping("/updateByMapSqlParameterSource")
	public Boolean updateProductDetailsBySqlMap(@RequestBody UpdateProductReq updateProductReq) {
		return productService.updateProductDetailsBySqlMap(updateProductReq);
	}
	
	@ApiOperation(value = "This api is used to update person details ", response = UpdateProductReq.class, responseContainer = "UPDATE")
	@PutMapping("/updateByBeanPropertySqlParameterSource")
	public Boolean updateProductDetailsByBeanProperty(@RequestBody UpdateProductReq updateProductReq) {
		return productService.updateProductDetailsByBeanProperty(updateProductReq);
	}
	
	@ApiOperation(value = "This api is used to delete person details ", response = DeleteProductReq.class, responseContainer = "DELETE")
	@DeleteMapping("/deleteByMap")
	public Boolean deleteProductDetails(@RequestBody DeleteProductReq deleteProductReq) {
		return productService.deleteProductDetails(deleteProductReq);
	}
	
	@ApiOperation(value = "This api is used to delete person details ", response = DeleteProductReq.class, responseContainer = "DELETE")
	@DeleteMapping("/deleteByMapSqlParameterSource")
	public Boolean deleteProductDetailsBySqlMap(@RequestBody DeleteProductReq deleteProductReq) {
		return productService.deleteProductDetailsBySqlMap(deleteProductReq);
	}
	@ApiOperation(value = "This api is used to delete person details ", response = DeleteProductReq.class, responseContainer = "DELETE")
	@DeleteMapping("/deleteByBeanPropertySqlParameterSource")
	public Boolean deleteProductDetailsByBeanProperty(@RequestBody DeleteProductReq deleteProductReq) {
		return productService.deleteProductDetailsByBeanProperty(deleteProductReq);
	}
	//==================================batch insert and update using namedjdbc templete==============================================//
	
	@ApiOperation(value = "This api is used to insert product details.", response = InsertBatchProductReq.class, responseContainer = "INSERT")
	@PostMapping("/insertBatchProductReqByNamedJdbcTemplate")
	public Boolean insertBatchProductReq(@RequestBody InsertBatchProductReq insertBatchProductReq) {

		return  productService.insertBatchProductReq(insertBatchProductReq);

	}
	@ApiOperation(value = "This api is used to update person details ", response = UpdateBatchProductReq.class, responseContainer = "UPDATE")
	@PutMapping("/updateBatchProductReqByNamedJdbcTemplate")
	public Boolean updateBatchProductReq(@RequestBody UpdateBatchProductReq updateBatchProductReq) {

		return  productService.updateBatchProductReq(updateBatchProductReq);
	}
	//===========================================batch insert and update using jdbctemplete============================================//
	@ApiOperation(value = "This api is used to insert product details.", response = InsertProductsReq.class, responseContainer = "INSERT")
	@PostMapping("/insertProductReqByJdbcTemplate")
	public Boolean insertProductReqByJdbcTemplate(@RequestBody InsertProductsReq insertProductsReq) {

		return  productService.insertProductReqByJdbcTemplate(insertProductsReq);

	}
	@ApiOperation(value = "This api is used to update person details ", response = UpdateProductsReq.class, responseContainer = "UPDATE")
	@PutMapping("/updateProductReqByJdbcTemplate")
	public Boolean updateProductReqByJdbcTemplate(@RequestBody UpdateProductsReq updateProductsReq) {

		return  productService.updateProductReqByJdbcTemplate(updateProductsReq);

	}
	//==========================================Insert and update single API==================================================//
	@ApiOperation(value = "This api is used to insert And update product details ", response = InsertProductsReq.class, responseContainer = "INSERT AND UPDATE")
	@PostMapping("/insertAndUpdateProductDetails")
	public Boolean insertAndUpdateProductDetails(@RequestBody InsertProductsReq insertProductsReq) {
		return productService.insertAndUpdateProductDetails(insertProductsReq);
	}
	//=============================================MULTIPLE TABLES ==========================================//
	@ApiOperation(value = "This api is used to insert And update product details ", response = InsertFetchProductReq.class, responseContainer = "INSERT AND UPDATE")
	@PostMapping("/insertAndUpdateProduct")
	public Boolean insertAndUpdateProductByBatch(@RequestBody InsertFetchProductReq insertFetchProductReq) {
		return productService.insertAndUpdateProductByBatch(insertFetchProductReq);
	}
	//==============================================fetch by query for object===================================//
	@ApiOperation(value = "This api is used to fetch product details ", response = FetchProductReq.class, responseContainer = "FETCH")
	@PostMapping("/getProductDetailsByUsingObject")
	public FetchProductReq getProductDetailsByUsingObject(@RequestBody FetchProductReq fetchProductReq) {
		return productService.getProductDetailsByUsingObject(fetchProductReq);
	}
	//========================================fetch by query for map============================================//
	@ApiOperation(value = "This api is used to fetch product details ", response = FetchProductReq.class, responseContainer = "FETCH")
	@PostMapping("/getProductDetailsByMap")
	public FetchProductResponse getProductDetailsByUsingMap(@RequestBody FetchProductReq fetchProductReq) {
		return productService.getProductDetailsByUsingMap(fetchProductReq);
	}
	@PostMapping("/fetchProductDetailsByMapDynamic")
	public FetchProductResponse fetchProductDetailsByMapDynamic(@RequestBody FetchProductReq fetchProductReq) {
		return productService.fetchProductDetailsByMapDynamic(fetchProductReq);
	}
	//=========================================fetch by query for list=====================================//
	@ApiOperation(value = "This api is used to fetch product details ", response = FetchProductReq.class, responseContainer = "LIST OF FETCH")
	@PostMapping("/findByList")
	public List<FetchProductResponse> getProductDetailsByUsingList(@RequestBody FetchProductReq fetchProductReq) {
		return productService.getProductDetailsByUsingList(fetchProductReq);
		
	}
	//=========================================fetch by query===========================================//
	@ApiOperation(value = "This api is used to fetch product details ", response = FetchProductReq.class, responseContainer = "FETCH")
	@PostMapping("/fetchPersonDetailsByQuery")
	public List<FetchProductResponse> fetchPersonDetailsByQuery(@RequestBody FetchProductReq fetchProductReq) {
		return productService.fetchPersonDetailsByQuery(fetchProductReq);
	}
	///===========================================fetch by set============================================//
	
	@PostMapping("/fetchProductDetails")
	public List<FetchProductResponse> fetchProductDetailsBySet(@RequestBody FetchProductsReq fetchProductsReq){
		return productService.fetchProductDetailsBySet(fetchProductsReq);
	}
}


