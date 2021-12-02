package com.Simplilearn.eCommerceSportyShoes.repository;

import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByName(String name);

	@Modifying
	@Transactional
	@Query("update Product log set log.name=:name,log.price=:price,log.size=:size,log.category=:category where log.id=:id")
	void updateProduct(@Param(value = "name") String name
			,@Param(value = "price") String price,@Param(value = "size") String size
			,@Param(value = "category") String category, @Param(value = "id") Long id);
}
