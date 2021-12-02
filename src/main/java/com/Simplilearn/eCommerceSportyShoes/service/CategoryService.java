package com.Simplilearn.eCommerceSportyShoes.service;

import com.Simplilearn.eCommerceSportyShoes.entity.Category;

import java.util.List;

public interface CategoryService {

	void save(Category category);

	List<Category> findAll();

	Category findById(long id);

	void delete(long id);
}
