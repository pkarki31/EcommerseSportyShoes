package com.Simplilearn.eCommerceSportyShoes.repository;

import com.Simplilearn.eCommerceSportyShoes.entity.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LoginRepository extends JpaRepository<LoginUser, Integer> {

	// @Query("select l from LoginUser l where l.username =?1 and l.password=?2")
	LoginUser findByUsernameAndPassword(String username, String password);

	//@Query("select l from LoginUser l where l.username =?1")
	LoginUser findByUsername(String username);

	LoginUser findAllById(String id);


	@Modifying
	@Transactional
	@Query("update LoginUser log set log.password=:password where log.id=:id")
	void changePassword(@Param(value = "password") String password, @Param(value = "id") Long id);
}
