package com.Simplilearn.eCommerceSportyShoes.repository;

import com.Simplilearn.eCommerceSportyShoes.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
