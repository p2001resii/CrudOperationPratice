package com.example.service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.example.dao.ProductDao;

@Service
public class ProductServiceImp  implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public Boolean insertProductDetails(InsertProductReq insertProductReq) {
		return productDao.insertProductDetails(insertProductReq);
	}

	@Override
	public Boolean insertProductDetailsByUsingMapSql(InsertProductReq insertProductReq) {
		return productDao.insertProductDetailsByUsingMapSql(insertProductReq);
	}

	@Override
	public Boolean insertProductDetailsByBeanProperty(InsertProductReq insertProductReq) {
		return productDao.insertProductDetailsByBeanProperty(insertProductReq);
	}



	@Override
	public Boolean updateProductDetails(UpdateProductReq updateProductReq) {
		return productDao.updateProductDetails(updateProductReq);
	}

	@Override
	public Boolean updateProductDetailsBySqlMap(UpdateProductReq updateProductReq) {
		return productDao.updateProductDetailsBySqlMap(updateProductReq);
	}

	@Override
	public Boolean updateProductDetailsByBeanProperty(UpdateProductReq updateProductReq) {
		return productDao.updateProductDetailsByBeanProperty(updateProductReq);
	}



	@Override
	public Boolean deleteProductDetails(DeleteProductReq deleteProductReq) {
		return productDao.deleteProductDetails(deleteProductReq);
	}

	@Override
	public Boolean deleteProductDetailsBySqlMap(DeleteProductReq deleteProductReq) {
		return productDao.deleteProductDetailsBySqlMap(deleteProductReq);
	}

	@Override
	public Boolean deleteProductDetailsByBeanProperty(DeleteProductReq deleteProductReq) {
		return productDao.deleteProductDetailsByBeanProperty(deleteProductReq);
	}
	//========================================batch insert and update by namedjdbctemplete=================================//

	@Override
	public Boolean insertBatchProductReq(InsertBatchProductReq insertBatchProductReq) {
		return productDao.insertBatchProductReq(insertBatchProductReq);
	}

	@Override
	public Boolean updateBatchProductReq(UpdateBatchProductReq updateBatchProductReq) {
		return productDao.updateBatchProductReq(updateBatchProductReq);
	}

	//===============================batch insert and update by jdbctemplete======================================//

	@Override
	public Boolean insertProductReqByJdbcTemplate(InsertProductsReq insertProductsReq) {

		return productDao.insertProductReqByJdbcTemplate(insertProductsReq);
	}

	@Override
	public Boolean updateProductReqByJdbcTemplate(UpdateProductsReq updateProductsReq) {

		return productDao.updateProductReqByJdbcTemplate(updateProductsReq);
	}

	//=================================== insert and update single API======================================//

	@Override
	public Boolean insertAndUpdateProductDetails(InsertProductsReq insertProductsReq) {
		Boolean insertFlag = false;
		Boolean updateFlag = false;
		if (CollectionUtils.isNotEmpty(insertProductsReq.getProductList())) {
			List<InsertProductBean> saveProductList = new ArrayList<>();
			List<InsertProductBean> updateProductList = new ArrayList<>();
			for (InsertProductBean insertProductObj : insertProductsReq.getProductList()) {

				insertProductObj.setOrgId(insertProductsReq.getOrgId());
				if (insertProductObj.getProductId() == null) {
					saveProductList.add(insertProductObj);
				} else {
					updateProductList.add(insertProductObj);
				}
			}
			if (CollectionUtils.isNotEmpty(saveProductList)) {
				insertFlag = productDao.insertProductDetails(saveProductList);
			}
			if (CollectionUtils.isNotEmpty(updateProductList)) {
				updateFlag = productDao.updateProductDetails(updateProductList);
			}
		}
		return insertFlag || updateFlag;
	}
	//==================================multiple tables=======================================

	@Override
	public Boolean insertAndUpdateProductByBatch(InsertFetchProductReq insertFetchProductReq) {
		Boolean result = false;
		List<InsertFetchProductBean> updateProductList = new ArrayList<>();
		List<ProductBatchBean> saveBatchList = new ArrayList<>();
		List<ProductBatchBean> updateBatchList = new ArrayList<>();
		Long productId = null;
		for (InsertFetchProductBean insertFetchProductObj : insertFetchProductReq.getProductList()) {

			insertFetchProductObj.setOrgId(insertFetchProductReq.getOrgId());
			if (insertFetchProductObj.getProductId() == null) {
				productId = productDao.insertProduct(insertFetchProductObj);
				insertFetchProductObj.setProductId(productId);
			
               
				for (ProductBatchBean productBatchObj : insertFetchProductObj.getProductBatchList()) {
					productBatchObj.setOrgId(insertFetchProductReq.getOrgId());
					//productBatchObj.setBatchId(productBatchObj.getBatchId());;
					if (productBatchObj.getProductBatchId() == null) {
						saveBatchList.add(productBatchObj);
					} else {
						updateBatchList.add(productBatchObj);
					}
				}
			} else {
				for (ProductBatchBean productBatchObj : insertFetchProductObj.getProductBatchList()) {
					//productBatchObj.setBatchId(productBatchObj.getBatchId());
					productBatchObj.setOrgId(insertFetchProductReq.getOrgId());
					if (productBatchObj.getProductBatchId() == null) {

						saveBatchList.add(productBatchObj);
					} else {
						updateBatchList.add(productBatchObj);
					}
					updateProductList.add(insertFetchProductObj);
				}
			}
			
			if (CollectionUtils.isNotEmpty(saveBatchList)) {
				productDao.insertProductDetails(saveBatchList, insertFetchProductReq);
			}
			if (CollectionUtils.isNotEmpty(updateBatchList)) {
				productDao.insertProductDetails(updateBatchList, insertFetchProductReq);
			}
		}
		return result;
	}
	
	//======================================fetch by query for  object=====================================//

	@Override
	public FetchProductReq getProductDetailsByUsingObject(FetchProductReq fetchProductReq) {
		return productDao.getProductDetailsByUsingObject(fetchProductReq);
	}
	//========================================fetch by query for map======================================//
	@Override
	public FetchProductResponse getProductDetailsByUsingMap(FetchProductReq fetchProductReq) {
		Map<String, Object> map = productDao.fetchProductDetailsByUsingMap(fetchProductReq);

		if(map!=null) {   
			FetchProductResponse fetchProductDetails = new FetchProductResponse();

			fetchProductDetails.setProductId((Long)map.get("product_Id"));  
			fetchProductDetails.setProductNm((String)map.get("product_Nm"));
			fetchProductDetails.setProductCategory((String)map.get("product_category"));
			fetchProductDetails.setProductPrice((Double)map.get("product_Price"));
			fetchProductDetails.setProductQty((Integer)map.get("product_Qty"));
			fetchProductDetails.setManufacturer((String)map.get("manufacturer"));
			return fetchProductDetails;
		}
		return null;
	}
	@Override
	public FetchProductResponse fetchProductDetailsByMapDynamic(FetchProductReq fetchProductReq) {
		Map<String, Object> map = productDao.fetchProductDetailsByMapDynamic(fetchProductReq);
		FetchProductResponse fetchPersonsDto = new FetchProductResponse();
		return fetchPersonsDto;
	}
	
	//==========================================fetch by query for list=============================================//

	@Override
	public List<FetchProductResponse> getProductDetailsByUsingList(FetchProductReq fetchProductReq) {
		List<Map<String, Object>> list = productDao.fetchProductDetailsByUsingList(fetchProductReq);
		List<FetchProductResponse> beanResponse = new ArrayList<>();
		if (list != null && !list.isEmpty()) {
			for (Map<String, Object> map : list) {
				FetchProductResponse fetchProductBeanResponse = new FetchProductResponse();


				fetchProductBeanResponse.setProductId((Long)map.get("product_Id"));  
				fetchProductBeanResponse.setProductNm((String)map.get("product_Nm"));
				fetchProductBeanResponse.setProductCategory((String)map.get("product_category"));
				fetchProductBeanResponse.setProductPrice((Double)map.get("product_Price"));
				fetchProductBeanResponse.setProductQty((Integer)map.get("product_Qty"));
				fetchProductBeanResponse.setManufacturer((String)map.get("manufacturer"));
				beanResponse.add(fetchProductBeanResponse);

			}
			return beanResponse;
		}
		return null;
	}
	//===========================================fetch by query=======================================
	@Override
	public List<FetchProductResponse> fetchPersonDetailsByQuery(FetchProductReq fetchProductReq) {
		
		return productDao.fetchPersonDetailsByQuery(fetchProductReq);
	}
	//==========================================fetch by set==============================================//

	@Override
	public List<FetchProductResponse> fetchProductDetailsBySet(FetchProductsReq fetchProductsReq) {
		List<Map<String, Object>> rows = productDao.fetchProductDetailsBySet(fetchProductsReq);

		if (CollectionUtils.isNotEmpty(rows)) {
			FetchProductResponse fetchProductResponse = null;
			List<FetchProductResponse> productList = new ArrayList<>();
			int count = 0;
			Set<Long> set = new HashSet<>();
			List<ProductBatchBean> batchList = null;
			for (Map<String, Object> row : rows) {
				count++;
				if (set.add((Long) row.get("product_id"))) {
					if (fetchProductResponse != null) {
						
						fetchProductResponse.setBatchList(batchList);
						productList.add(fetchProductResponse);
					}
					FetchProductResponse fetchProductsResponse = new FetchProductResponse();
					fetchProductsResponse.setProductId((Long)row.get("product_Id"));  
					fetchProductsResponse.setProductNm((String)row.get("product_Nm"));
					fetchProductsResponse.setProductCategory((String)row.get("product_category"));
					fetchProductsResponse.setProductPrice((Double)row.get("product_Price"));
					fetchProductsResponse.setProductQty((Integer)row.get("product_Qty"));
					fetchProductsResponse.setManufacturer((String)row.get("manufacturer"));
					fetchProductsResponse.setVersionId((Integer) row.get("version_id"));
					batchList = new ArrayList<>();
				}
				ProductBatchBean batchBean = new ProductBatchBean();
				batchBean.setBatchId((Long) row.get("batch_id"));
				batchList.add(batchBean);
			}

			// for last row
			if (count == rows.size() && fetchProductResponse != null) {
				fetchProductResponse.setBatchList(batchList);
				productList.add(fetchProductResponse);
			}
			return productList;
		}
		return null;
	}
	
	
	
	

	@Override
	public ByteArrayInputStream getDataDownloaded() {
		
		return null;
	}
}


	

	

	








