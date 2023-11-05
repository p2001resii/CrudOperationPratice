package com.example.dao;

import java.util.List;
import java.util.Map;

import com.example.bean.DeleteProductReq;
import com.example.bean.FetchProductReq;
import com.example.bean.FetchProductResponse;
import com.example.bean.FetchProductsReq;
import com.example.bean.InsertBatchProductReq;
import com.example.bean.InsertFetchProductBean;
import com.example.bean.InsertFetchProductReq;
import com.example.bean.InsertProductBean;
import com.example.bean.InsertProductReq;
import com.example.bean.InsertProductsReq;
import com.example.bean.ProductBatchBean;
import com.example.bean.UpdateBatchProductReq;
import com.example.bean.UpdateProductReq;
import com.example.bean.UpdateProductsReq;

public interface ProductDao {

	Boolean insertProductDetails(InsertProductReq insertProductReq);

	Boolean insertProductDetailsByUsingMapSql(InsertProductReq insertProductReq);

	Boolean insertProductDetailsByBeanProperty(InsertProductReq insertProductReq);


	Boolean updateProductDetails(UpdateProductReq updateProductReq);

	Boolean updateProductDetailsBySqlMap(UpdateProductReq updateProductReq);

	Boolean updateProductDetailsByBeanProperty(UpdateProductReq updateProductReq);



	Boolean deleteProductDetails(DeleteProductReq deleteProductReq);

	Boolean deleteProductDetailsBySqlMap(DeleteProductReq deleteProductReq);

	Boolean deleteProductDetailsByBeanProperty(DeleteProductReq deleteProductReq);

	//========================batch insert and update namedjdbc=====================================//
	Boolean insertBatchProductReq(InsertBatchProductReq insertBatchProductReq);

	Boolean updateBatchProductReq(UpdateBatchProductReq updateBatchProductReq);

	//=============================batch insert and update jdbc templete===============================//
	Boolean insertProductReqByJdbcTemplate(InsertProductsReq insertProductsReq);

	Boolean updateProductReqByJdbcTemplate(UpdateProductsReq updateProductsReq);

	//================================ insert and update single API=======================================//
	Boolean insertProductDetails(List<InsertProductBean> saveProductList);

	Boolean updateProductDetails(List<InsertProductBean> updateProductList);

	//============================================fetch by mutiple tables===================================//
	Long insertProduct(InsertFetchProductBean insertFetchProductObj);

	Boolean updateProduct(InsertFetchProductBean insertFetchProductObj);

	Boolean insertProductDetails(List<ProductBatchBean> saveBatchList, InsertFetchProductReq insertFetchProductReq);

	Boolean updateProductDetails(List<ProductBatchBean> updateBatchList, InsertFetchProductReq InsertFetchProductReq);

	//===============================fetch by  query for object==================================//
	FetchProductReq getProductDetailsByUsingObject(FetchProductReq fetchProductReq);

	//================================fetch by query for map=========================================//
	Map<String, Object> fetchProductDetailsByUsingMap(FetchProductReq fetchProductReq);
	
	Map<String, Object> fetchProductDetailsByMapDynamic(FetchProductReq fetchProductReq);
	
	//===================================fetch by query for list========================================//
	List<Map<String, Object>> fetchProductDetailsByUsingList(FetchProductReq fetchProductReq);
	
	//=============================fetch by query====================================================//
	List<FetchProductResponse> fetchPersonDetailsByQuery(FetchProductReq fetchProductReq);
   //===============================fetch by set===================================================//
	List<Map<String, Object>> fetchProductDetailsBySet(FetchProductsReq fetchProductsReq);


}
