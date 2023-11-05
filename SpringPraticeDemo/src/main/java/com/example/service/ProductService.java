package com.example.service;

import java.io.ByteArrayInputStream;
import java.util.List;

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

public interface ProductService {

	Boolean insertProductDetails(InsertProductReq insertProductReq);

	Boolean insertProductDetailsByUsingMapSql(InsertProductReq insertProductReq);

	Boolean insertProductDetailsByBeanProperty(InsertProductReq insertProductReq);



	Boolean updateProductDetails(UpdateProductReq updateProductReq);

	Boolean updateProductDetailsBySqlMap(UpdateProductReq updateProductReq);

	Boolean updateProductDetailsByBeanProperty(UpdateProductReq updateProductReq);



	Boolean deleteProductDetails(DeleteProductReq deleteProductReq);

	Boolean deleteProductDetailsBySqlMap(DeleteProductReq deleteProductReq);

	Boolean deleteProductDetailsByBeanProperty(DeleteProductReq deleteProductReq);

	//============batch namedjdbctemplete==========================//
	Boolean insertBatchProductReq(InsertBatchProductReq insertBatchProductReq);

	Boolean updateBatchProductReq(UpdateBatchProductReq updateBatchProductReq);

	//==========================batch jdbctemplete===========================//

	Boolean insertProductReqByJdbcTemplate(InsertProductsReq insertProductsReq);

	Boolean updateProductReqByJdbcTemplate(UpdateProductsReq updateProductsReq);


	//===============================insert and update single API========================//
	Boolean insertAndUpdateProductDetails(InsertProductsReq insertProductsReq);

	//====================================insert mutiple tables====================================//

	Boolean insertAndUpdateProductByBatch(InsertFetchProductReq insertFetchProductReq);

	//===========================fetch by query for object===============================//
	FetchProductReq getProductDetailsByUsingObject(FetchProductReq fetchProductReq);

	//==============================fetch by query for map====================================//
	FetchProductResponse getProductDetailsByUsingMap(FetchProductReq fetchProductReq);

	FetchProductResponse fetchProductDetailsByMapDynamic(FetchProductReq fetchProductReq);

	//=============================fetch by query for list===================================//
	List<FetchProductResponse> getProductDetailsByUsingList(FetchProductReq fetchProductReq);

	//==============================fetch by query ========================================//

	List<FetchProductResponse> fetchPersonDetailsByQuery(FetchProductReq fetchProductReq);
	
	//=====================================fetch by set=============================================//
	List<FetchProductResponse> fetchProductDetailsBySet(FetchProductsReq fetchProductsReq);


    ByteArrayInputStream getDataDownloaded();




}
