package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

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
import com.example.bean.UpdateProductBean;
import com.example.bean.UpdateProductReq;
import com.example.bean.UpdateProductsReq;

import io.micrometer.common.util.StringUtils;




//import org.apache.commons.lang3.StringUtils;
//import io.micrometer.common.util.StringUtils;

@Repository
public class ProductDaoImp  implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Value("${queries.insertProduct}")
	private String insertquery;

	@Value("${queries.updateProduct}")
	private String updatequery;
     
	@Value("${queries.deleteProduct}")
	private String deletequery;

	
	@Override
	public Boolean insertProductDetails(InsertProductReq insertProductReq) {
		boolean result = false;
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("productNm", insertProductReq.getProductNm());
			parameters.put("productCategory", insertProductReq.getProductCategory());
			parameters.put("description", insertProductReq.getDescription());
			parameters.put("distributerNm", insertProductReq.getDistributerNm());
			parameters.put("manufacturer", insertProductReq.getManufacturer());
			parameters.put("originCountry", insertProductReq.getOriginCountry());
			parameters.put("productPrice", insertProductReq.getProductPrice());
			parameters.put("productQty", insertProductReq.getProductQty());
			parameters.put("brandName", insertProductReq.getBrandName());
            parameters.put("weightUnit", insertProductReq.getWeightUnit());
            parameters.put("color", insertProductReq.getColor());
            parameters.put("size", insertProductReq.getSize());
            parameters.put("productURL", insertProductReq.getProductURL());
               
			result = namedParameterJdbcTemplate.update(insertquery, parameters) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public Boolean insertProductDetailsByUsingMapSql(InsertProductReq insertProductReq) {
		boolean result = false;
		try {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("productNm", insertProductReq.getProductNm());
			parameters.addValue("productCategory", insertProductReq.getProductCategory());
			parameters.addValue("description", insertProductReq.getDescription());
			parameters.addValue("distributerNm", insertProductReq.getDistributerNm());
			parameters.addValue("manufacturer", insertProductReq.getManufacturer());
			parameters.addValue("originCountry", insertProductReq.getOriginCountry());
			parameters.addValue("productPrice", insertProductReq.getProductPrice());
			parameters.addValue("productQty", insertProductReq.getProductQty());
			parameters.addValue("brandName", insertProductReq.getBrandName());
            parameters.addValue("weightUnit", insertProductReq.getWeightUnit());
            parameters.addValue("color", insertProductReq.getColor());
            parameters.addValue("size", insertProductReq.getSize());
            parameters.addValue("productURL", insertProductReq.getProductURL());
               
			
			result = namedParameterJdbcTemplate.update(insertquery, parameters) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean insertProductDetailsByBeanProperty(InsertProductReq insertProductReq) {

		boolean result = false;
		try {
			result = namedParameterJdbcTemplate.update(insertquery,new BeanPropertySqlParameterSource(insertProductReq)) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	

	@Override
	public Boolean updateProductDetails(UpdateProductReq updateProductReq) {
		boolean result = false;
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("productId", updateProductReq.getProductId());
			parameters.put("productNm", updateProductReq.getProductNm());
			parameters.put("productCategory", updateProductReq.getProductCategory());
			parameters.put("description", updateProductReq.getDescription());
			parameters.put("distributerNm", updateProductReq.getDistributerNm());
			parameters.put("manufacturer", updateProductReq.getManufacturer());
			parameters.put("originCountry", updateProductReq.getOriginCountry());
			parameters.put("productPrice", updateProductReq.getProductPrice());
			parameters.put("productQty", updateProductReq.getProductQty());
			parameters.put("brandName", updateProductReq.getBrandName());
            parameters.put("weightUnit", updateProductReq.getWeightUnit());
            parameters.put("color", updateProductReq.getColor());
            parameters.put("size", updateProductReq.getSize());
            parameters.put("productURL", updateProductReq.getProductURL());
            
			result = namedParameterJdbcTemplate.update(insertquery, parameters) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean updateProductDetailsBySqlMap(UpdateProductReq updateProductReq) {
		boolean result = false;
		try {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("productId", updateProductReq.getProductId());
			parameters.addValue("productNm", updateProductReq.getProductNm());
			parameters.addValue("productCategory", updateProductReq.getProductCategory());
			parameters.addValue("description", updateProductReq.getDescription());
			parameters.addValue("distributerNm", updateProductReq.getDistributerNm());
			parameters.addValue("manufacturer", updateProductReq.getManufacturer());
			parameters.addValue("originCountry", updateProductReq.getOriginCountry());
			parameters.addValue("productPrice", updateProductReq.getProductPrice());
			parameters.addValue("productQty", updateProductReq.getProductQty());
			parameters.addValue("brandName", updateProductReq.getBrandName());
            parameters.addValue("weightUnit", updateProductReq.getWeightUnit());
            parameters.addValue("color", updateProductReq.getColor());
            parameters.addValue("size", updateProductReq.getSize());
            parameters.addValue("productURL", updateProductReq.getProductURL());
			result = namedParameterJdbcTemplate.update(insertquery, parameters) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Boolean updateProductDetailsByBeanProperty(UpdateProductReq updateProductReq) {
		boolean result = false;
		try {
			result = namedParameterJdbcTemplate.update(updatequery,new BeanPropertySqlParameterSource(updateProductReq)) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public Boolean deleteProductDetails(DeleteProductReq deleteProductReq) {
		boolean result = false;
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("productId", deleteProductReq.getProductId());

			result = namedParameterJdbcTemplate.update(deletequery, map) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public Boolean deleteProductDetailsBySqlMap(DeleteProductReq deleteProductReq) {
			boolean result = false;
			try {
				MapSqlParameterSource parameters = new MapSqlParameterSource();
				parameters.addValue("productId", deleteProductReq.getProductId());

				result = namedParameterJdbcTemplate.update(deletequery, parameters) > 0;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}
	
	
	@Override
	public Boolean deleteProductDetailsByBeanProperty(DeleteProductReq deleteProductReq) {
		boolean result = false;
		try {
			BeanPropertySqlParameterSource beanPropertySqlParameterSource = new BeanPropertySqlParameterSource(
					deleteProductReq);

			result = namedParameterJdbcTemplate.update(deletequery,beanPropertySqlParameterSource) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	//============================================BATCH INSERT AND UPDATE NAMEDJDBC=================================
	
	@Override
	public Boolean insertBatchProductReq(InsertBatchProductReq insertBatchProductReq) {
		try {
		String queryForInsertProductDetails = "INSERT INTO public.products_Info_Ref2 (orgId,product_nm,product_category,description,distributer_nm,origin_country,manufacturer,product_price,product_qty,brand_name,expiry_date,weight_unit,color,size,product_URL) VALUES ( :orgId,:productNm,:productCategory,:description,:distributerNm,:manufacturer,:originCountry,:productPrice,:productQty,:brandName,:expiryDate,:weightUnit,:color,:size,:productURL)";
				
		SqlParameterSource[] batchArray = insertBatchProductReq.getProductList().stream()
				.map(product -> new MapSqlParameterSource()
		                .addValue("orgId", insertBatchProductReq.getOrgId())
		                .addValue("productNm", product.getProductNm())
		                .addValue("productCategory", product.getProductCategory())
		                .addValue("description", product.getDescription())
		                .addValue("distributerNm", product.getDistributerNm())
		                .addValue("originCountry", product.getOriginCountry())
		                .addValue("manufacturer", product.getManufacturer())
		                .addValue("productPrice", product.getProductPrice())
		                .addValue("productQty", product.getProductQty())
		                .addValue("brandName", product.getBrandName())
		                .addValue("expiryDate", product.getExpiryDate())
		                .addValue("weightUnit", product.getWeightUnit())
		                .addValue("color", product.getColor())
		                .addValue("size", product.getSize())
		                .addValue("productURL", product.getProductURL()))
		        .toArray(SqlParameterSource[]::new);

		int Count = namedParameterJdbcTemplate.batchUpdate(queryForInsertProductDetails, batchArray).length;

		
		return Count > 0;
		}
		catch (Exception e) {
	        e.printStackTrace();
	        return false;
		}
		

	}

	@Override
	public Boolean updateBatchProductReq(UpdateBatchProductReq updateBatchProductReq) {
		try {
		String queryForUpdateProductDetails = "UPDATE public.products_Info_Ref2 SET product_nm=:productNm,product_category=:productCategory,description=:description,distributer_nm=:distributerNm,origin_country=:originCountry,manufacturer=:manufacturer,product_price=:productPrice,product_qty=:productQty,brand_name=:brandName,expiry_date=:expiryDate,weight_unit=:weightUnit,color=:color,size=:size,product_URL=:productURL,version_id=version_id+1,modified_dttm=now() WHERE product_id=:productId";
	
	    SqlParameterSource[] batchArray = updateBatchProductReq.getProductList().stream()
	    	
	            .map(product -> new MapSqlParameterSource()
	                    .addValue("ProductId", updateBatchProductReq.getProductId())
	                    .addValue("productNm", product.getProductNm())
	                    .addValue("productCategory", product.getProductCategory())
	                    .addValue("description", product.getDescription())
	                    .addValue("distributerNm", product.getDistributerNm())
	                    .addValue("originCountry", product.getOriginCountry())
	                    .addValue("manufacturer", product.getManufacturer())
	                    .addValue("productPrice", product.getProductPrice())
	                    .addValue("productQty", product.getProductQty())
	                    .addValue("brandName", product.getBrandName())
	                    .addValue("expiryDate", product.getExpiryDate())
	                    .addValue("weightUnit", product.getWeightUnit())
	                    .addValue("color", product.getColor())
	                    .addValue("size", product.getSize())
	                    .addValue("productURL", product.getProductURL())
	                    .addValue("versionId",product.getVersionId())
	                    .addValue("modifiedDttm",product.getModifiedDttm()))
	                 .toArray(SqlParameterSource[]::new);

	    int count = namedParameterJdbcTemplate.batchUpdate(queryForUpdateProductDetails, batchArray).length;

	    return count > 0;
	}
	catch (Exception e) {
        e.printStackTrace();
        return false;
	  
	}
   }
	//=======================================BATCH INSERT AND UPDATE JDBCTEMPLTE============================================//
	@Override
	public Boolean insertProductReqByJdbcTemplate(InsertProductsReq insertProductsReq) {
		String query = "INSERT INTO public.products_Info_Ref2 (orgId,product_nm,product_category,description,distributer_nm,manufacturer,origin_country,product_price,product_qty,brand_name,expiry_date,weight_unit,color,size,product_URL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		int count[] = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				InsertProductBean insertproductbean = insertProductsReq.getProductList().get(i);

				ps.setLong(1, insertProductsReq.getOrgId());
				if (insertproductbean.getProductNm() != null) {
					ps.setString(2, insertproductbean.getProductNm());
				} else {
					ps.setNull(2, java.sql.Types.VARCHAR);
				}
				ps.setString(3, insertproductbean.getProductCategory());
				ps.setString(4, insertproductbean.getDescription());
				ps.setString(5, insertproductbean.getDistributerNm());
				ps.setString(6, insertproductbean.getManufacturer());
				ps.setString(7, insertproductbean.getOriginCountry());
				ps.setDouble(8, insertproductbean.getProductPrice());
				ps.setInt(9, insertproductbean.getProductQty());
				ps.setString(10, insertproductbean.getBrandName());
				ps.setDate(11, insertproductbean.getExpiryDate());
				ps.setString(12, insertproductbean.getWeightUnit());
				ps.setString(13, insertproductbean.getColor());
				ps.setString(14, insertproductbean.getSize());
				ps.setString(15, insertproductbean.getProductURL());

			}

			@Override
			public int getBatchSize() {

				return insertProductsReq.getProductList().size();
			}
		});

		return count.length == insertProductsReq.getProductList().size();

	}
	@Override
	public Boolean updateProductReqByJdbcTemplate(UpdateProductsReq updateProductsReq) {
		String query = "UPDATE public.products_Info_Ref2 SET  orgId=?, product_nm=?,product_category=?,description=?,distributer_nm=?,manufacturer=?,origin_country=?,product_price=?,product_qty=?,brand_name=?,expiry_date=?,weight_unit=?,color=?,size=?,product_URL=?,version_id=version_id+1,modified_dttm=now() WHERE product_id=?";

		int count[] = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {

				UpdateProductBean updateProductBean = updateProductsReq.getProductList().get(i);


				ps.setLong(1, updateProductsReq.getOrgId());
				if (updateProductBean.getProductNm() != null) {
					ps.setString(2, updateProductBean.getProductNm());
				} else {
					ps.setNull(2, java.sql.Types.VARCHAR);
				}
				ps.setString(3, updateProductBean.getProductCategory());
				ps.setString(4, updateProductBean.getDescription());
				ps.setString(5, updateProductBean.getDistributerNm());
				ps.setString(6, updateProductBean.getManufacturer());
				ps.setString(7, updateProductBean.getOriginCountry());
				ps.setDouble(8, updateProductBean.getProductPrice());
				ps.setInt(9, updateProductBean.getProductQty());
				ps.setString(10, updateProductBean.getBrandName());
				ps.setDate(11, updateProductBean.getExpiryDate());
				ps.setString(12, updateProductBean.getWeightUnit());
				ps.setLong(13, updateProductBean.getProductId());
				ps.setString(13, updateProductBean.getColor());
				ps.setString(14, updateProductBean.getSize());
				ps.setString(15, updateProductBean.getProductURL());
				ps.setInt(16, updateProductBean.getVersionId());
                ps.setTimestamp(17, updateProductBean.getModifiedDttm());


			}

			@Override
			public int getBatchSize() {

				return updateProductsReq.getProductList().size();
			}
		});

		return count.length == updateProductsReq.getProductList().size();
		
	}
	//===============================================insert and update single API==============================================//
	@Override
	public Boolean insertProductDetails(List<InsertProductBean> saveProductList) {
		String queryForInsertProductDetails = "INSERT INTO public.products_Info_Ref2 (orgId,product_nm,product_category,description,distributer_nm,origin_country,manufacturer,product_price,product_qty,brand_name,expiry_date,weight_unit,color,size,product_URL) VALUES ( :orgId,:productNm,:productCategory,:description,:distributerNm,:manufacturer,:originCountry,:productPrice,:productQty,:brandName,:expiryDate,:weightUnit,:color,:size,:productURL)";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(saveProductList);
		return namedParameterJdbcTemplate.batchUpdate(queryForInsertProductDetails, batch).length > 0;
	}
	@Override
	public Boolean updateProductDetails(List<InsertProductBean> updateProductList) {
		String queryForUpdateProductDetails = "UPDATE public.products_Info_Ref2 SET product_nm=:productNm,product_category=:productCategory,description=:description,distributer_nm=:distributerNm,origin_country=:originCountry,manufacturer=:manufacturer,product_price=:productPrice,product_qty=:productQty,brand_name=:brandName,expiry_date=:expiryDate,weight_unit=:weightUnit,color=:color,size=:size,product_URL=:productURL,version_id=version_id+1,modified_dttm=now() WHERE product_id=:productId";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(updateProductList);
		return namedParameterJdbcTemplate.batchUpdate(queryForUpdateProductDetails, batch).length > 0;
	}
	//========================================multiple tables================================================//
	@Override
	public Long insertProduct(InsertFetchProductBean insertFetchProductObj) {
		String queryForInsertProductDetails="INSERT INTO public.products_Info_Ref (product_nm,product_category,description,distributer_nm,origin_country,manufacturer,product_price,product_qty,brand_name,expiry_date,weight_unit,color,size,product_URL) VALUES ( :productNm,:productCategory,:description,:distributerNm,:manufacturer,:originCountry,:productPrice,:productQty,:brandName,:expiryDate,:weightUnit,:color,:size,:productURL";

		long personId = 0;
		try {
			KeyHolder holder = new GeneratedKeyHolder();
			namedParameterJdbcTemplate.update(queryForInsertProductDetails,
					new BeanPropertySqlParameterSource(insertFetchProductObj), holder, new String[] { "person_id" });
			personId = holder.getKey().longValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personId;
	}
	
	@Override
	public Boolean insertProductDetails(List<ProductBatchBean> saveBatchList, InsertFetchProductReq insertFetchProductReq) {
		String queryForInsertProductBatch = "INSERT INTO public. product_batch_xref(product_batch_id, product_id, batch_id, orgId) VALUES (?, ?, ?,?,?)";

		jdbcTemplate.batchUpdate(queryForInsertProductBatch, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ProductBatchBean productBatchObj = saveBatchList.get(i);
				ps.setLong(1, productBatchObj.getProductBatchId());
				ps.setLong(2, productBatchObj.getBatchId());
				ps.setLong(3, productBatchObj.getOrgId());
				
			}

			@Override
			public int getBatchSize() {
				return saveBatchList.size();
			}
		});
		return true;
	}
	@Override
	public Boolean updateProductDetails(List<ProductBatchBean> updateBatchList, InsertFetchProductReq InsertFetchProductReq) {
		String queryForUpdateProductBatch = "update INTO public. product_batch_xref set  product_id=? ,batch_id=?, orgId=?, version_id=version_id+1,modified_dttm=now() WHERE product_batch_id=:ProductBatchId";

		jdbcTemplate.batchUpdate(queryForUpdateProductBatch, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ProductBatchBean productBatchObj = updateBatchList.get(i);
				ps.setLong(1, productBatchObj.getProductBatchId());
				ps.setLong(2, productBatchObj.getBatchId());
				ps.setLong(3, productBatchObj.getOrgId());
				
			}

			@Override
			public int getBatchSize() {
				return updateBatchList.size();
			}
		});
		return true;
		
	}
	public Boolean updateProduct(InsertFetchProductBean insertFetchProductObj) {
		boolean result = false;
		updatequery="UPDATE public.products_Info_Ref2 SET product_nm=:productNm,product_category=:productCategory,description=:description,distributer_nm=:distributerNm,origin_country=:originCountry,manufacturer=:manufacturer,product_price=:productPrice,product_qty=:productQty,brand_name=:brandName,expiry_date=:expiryDate,weight_unit=:weightUnit,color=:color,size=:size,product_URL=:productURL,version_id=version_id+1,modified_dttm=now() WHERE product_id=:productId";
		try {
			result = namedParameterJdbcTemplate.update(updatequery,
					new BeanPropertySqlParameterSource(insertFetchProductObj)) > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	

	}
	//=========================================fetch by query for object======================================//
	@Override
	public FetchProductReq getProductDetailsByUsingObject(FetchProductReq fetchProductReq) {
		
		String queryForFetchProductDetailsByObject = "select orgId,product_id,product_nm,product_category,description,distributer_nm,origin_country,manufacturer,product_price,product_qty,brand_name,expiry_date,weight_unit,color,size,product_URL from products_Info_Ref2 where product_id=:ProductId and org_id=:orgId and is_active=:isActive";
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("ProductId", fetchProductReq.getProductId());
		return namedParameterJdbcTemplate.queryForObject(queryForFetchProductDetailsByObject, map,
				BeanPropertyRowMapper.newInstance(FetchProductReq.class));
	}
	
	//==========================================fetch by query for map=======================================//
	@Override
	public Map<String, Object> fetchProductDetailsByUsingMap(FetchProductReq fetchProductReq) {
		String queryForMap = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info_Ref2 where  Product_Id=:ProductId and org_id=:orgId and is_active=:isActive";

		Map<String, Object> map = namedParameterJdbcTemplate.queryForMap(queryForMap,
				new BeanPropertySqlParameterSource(fetchProductReq));

		return map;
	}
	@Override
	public Map<String, Object> fetchProductDetailsByMapDynamic(FetchProductReq fetchProductReq) {
		String queryForFetchProductDetailsByMap = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info_Ref2 where  Product_Id=:ProductId and org_id=:orgId and is_active=:isActive";
		StringBuilder query = new StringBuilder(queryForFetchProductDetailsByMap);
		if (StringUtils.isNotBlank(fetchProductReq.getProductNm())) {
			query.append(" AND product_nm ilike '%' ||:productNm ||'%'");
		}
		if (StringUtils.isNotBlank(fetchProductReq.getProductNm())) {
			query.append(" AND product_nm ilike '%' ||:productNum ||'%'");
		}
		Map<String, Object> map = namedParameterJdbcTemplate.queryForMap(query.toString(),
				new BeanPropertySqlParameterSource(fetchProductReq));
		return map;

	}
	//============================================fetch by query for list=======================================//
	@Override
	public List<Map<String, Object>> fetchProductDetailsByUsingList(FetchProductReq fetchProductReq) {
		String queryForFetchDataByList = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info_Ref2 where  1=1";
		StringBuilder query=new StringBuilder(queryForFetchDataByList);
		if (StringUtils.isNotBlank(fetchProductReq.getProductNm())) {
			query.append(" AND product_nm =:productNm ");
		}
		if (StringUtils.isNotBlank(fetchProductReq.getProductCategory())) {
			query.append(" AND product_category =:ProductCategory");
		}
		if (fetchProductReq.getProductPrice()!=null) {
			query.append(" AND product_Price =:productPrice");
		}
		if (fetchProductReq.getProductQty()!= null) {
			query.append(" AND product_Qty =:ProductQty");
		}
		if (StringUtils.isNotBlank(fetchProductReq.getManufacturer())) {
			query.append(" AND manufacturer =:manufacturer");
		}
		if(fetchProductReq.getPageNo()!=null) {
				query.append("limit 30 offset :PageNo=30");
							
		}
		String dynamicQuery = query.toString();
		List<Map<String, Object>> list = namedParameterJdbcTemplate.queryForList(dynamicQuery,
				new BeanPropertySqlParameterSource(fetchProductReq));
		return list;
	
	}
	///============================================fetch by query=========================================//
	@Override
	public List<FetchProductResponse> fetchPersonDetailsByQuery(FetchProductReq fetchProductReq) {
		String queryForFetchPersonsDetailsByQuery = "select Product_Id,Product_Nm,product_category,product_Price,product_Qty,manufacturer from products_Info_Ref2 where  Product_Id=:ProductId and org_id=:orgId and is_active=:isActive";
		return namedParameterJdbcTemplate.query(queryForFetchPersonsDetailsByQuery,
				//new BeanPropertySqlParameterSource(fetchProductReq),
				new BeanPropertyRowMapper<FetchProductResponse>(FetchProductResponse.class));

	}
	//========================================fetch by set=================================================//
	@Override
	public List<Map<String, Object>> fetchProductDetailsBySet(FetchProductsReq fetchProductsReq) {
		String queryForFetchPersonsDetailsByset ="select eir.Product_Id,  eir.Product_Nm, eir.product_category, eir.description, eir.distributer_nm, eir.origin_country, eir.manufacturer, eir.product_price, eir.product_qty, eir.brand_name, eir.expiry_date, eir.weight_unit, eir.color, eir.size,eir.product_URL, edx.batch_id, dr.batch_Nm, edx.product_batch_id from products_Info_Ref2 eir join public.product_batch_xref edx on eir.Product_Id=edx.Product_Id and edx.isactive=true join public.batch_ref dr on edx.batch_id=dr.batch_id where eir.isactive=true and eir.orgid=:orgId order by eir.Product_Id";
		List<Map<String, Object>> list = namedParameterJdbcTemplate.queryForList(queryForFetchPersonsDetailsByset,
				new BeanPropertySqlParameterSource(fetchProductsReq));
		return list;
	}
	}
	
	

