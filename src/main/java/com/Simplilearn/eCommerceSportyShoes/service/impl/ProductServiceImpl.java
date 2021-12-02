package com.Simplilearn.eCommerceSportyShoes.service.impl;

import com.Simplilearn.eCommerceSportyShoes.entity.LoginUser;
import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import com.Simplilearn.eCommerceSportyShoes.repository.ProductRepository;
import com.Simplilearn.eCommerceSportyShoes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public boolean save(Product product) {
		productRepository.save(product);

		if(Objects.nonNull(product)){

			return true;
		}

		else {

			return false;
		}
	}

	@Override
	public List<Product> getProdcuts() {
		return productRepository.findAll();
	}

	/*@Override
	public List<Product> findByName(String productName) {
		return productRepository.findByName(productName);
	}*/

	public boolean updateProduct(String oldname,String updatedName, String price,String size,String category) {
		Product product = productRepository.findByName(oldname);
		if (Objects.nonNull(product)) {
			productRepository.updateProduct(updatedName,price,size,category, product.getId());
			System.out.println("updated successfully ");
			return true;
		} else {
			System.out.println("Unable to change the password!");
			return false;
		}

	}
}
