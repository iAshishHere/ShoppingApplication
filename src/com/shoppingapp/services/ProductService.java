package com.shoppingapp.services;

import java.util.List;

import com.shoppingapp.dao.ProductDao;
import com.shoppingapp.pojos.ProductDetails;

public class ProductService {
	
	public List<ProductDetails> fetchProductDetails()
	{
		ProductDao productDao = new ProductDao();
		return productDao.readProduct();
	}
	
	public void updateProduct(int id) {
		ProductDao productDao = new ProductDao();
		productDao.updateProduct(id);
		
	}

}
