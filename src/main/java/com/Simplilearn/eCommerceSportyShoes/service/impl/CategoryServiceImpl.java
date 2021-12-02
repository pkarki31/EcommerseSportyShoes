package com.Simplilearn.eCommerceSportyShoes.service.impl;

import com.Simplilearn.eCommerceSportyShoes.entity.Category;
import com.Simplilearn.eCommerceSportyShoes.repository.CategoryRepository;
import com.Simplilearn.eCommerceSportyShoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);

		if (optionalCategory.isPresent())
			return optionalCategory.get();

		return null;
	}

	@Override
	public void delete(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);

		if (optionalCategory.isPresent())
			categoryRepository.delete(optionalCategory.get());
	}
}
