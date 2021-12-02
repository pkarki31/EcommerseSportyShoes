package com.Simplilearn.eCommerceSportyShoes.controller;

import com.Simplilearn.eCommerceSportyShoes.entity.Category;
import com.Simplilearn.eCommerceSportyShoes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}

	@GetMapping("/categories/{id}")
	public Category getAllCategories(@PathVariable("id") long id) {
		return categoryService.findById(id);
	}

	@PostMapping("/categories")
	public void saveCategory(@RequestBody Category newCategory) {
		categoryService.save(newCategory);
	}
	
	@DeleteMapping("/categories/{id}")
	public void deleteCategory(@PathVariable("id") long id) {
		categoryService.delete(id);
	}

}
