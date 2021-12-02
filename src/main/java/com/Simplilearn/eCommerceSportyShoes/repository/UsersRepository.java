package com.Simplilearn.eCommerceSportyShoes.repository;

import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByName(String name);


	@Query("SELECT m FROM Users m WHERE m.name LIKE %:name%")
	List<Users> findAllByName(@Param(value = "name") String name);

	@Modifying
	@Transactional
	@Query("update Users log set log.name=:name,log.password=:password,log.city=:city,log.contact=:contact,log.numberofOrders=:numberofOrders where log.id=:id")
	void updateUsers(@Param(value = "name") String name
			,@Param(value = "password") String password,@Param(value = "city") String city
			,@Param(value = "contact") String contact,@Param(value = "numberofOrders") String numberofOrders, @Param(value = "id") Long id);



}
