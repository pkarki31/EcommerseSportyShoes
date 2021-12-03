package com.Simplilearn.eCommerceSportyShoes.repository;

import com.Simplilearn.eCommerceSportyShoes.entity.Orders;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;
import com.Simplilearn.eCommerceSportyShoes.service.OrdersService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	Orders findByUserName(String name);


	@Query("SELECT m FROM Orders m WHERE m.category =:category")
	List<Orders> findAllByCategory(@Param(value = "category") String category);

	@Query("SELECT m FROM Orders m WHERE m.date LIKE %:date%")
	List<Orders> findAllByDate(@Param(value = "date") String date);




}
