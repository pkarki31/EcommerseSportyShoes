package com.Simplilearn.eCommerceSportyShoes.service;

import com.Simplilearn.eCommerceSportyShoes.entity.Product;

import java.util.List;

public interface ProductService {
	boolean save(Product product);
	List<Product> getProdcuts();
	//List<Product> findByName(String name);

	boolean updateProduct(String oldname,String updatedName, String price,String size,String category);
}
