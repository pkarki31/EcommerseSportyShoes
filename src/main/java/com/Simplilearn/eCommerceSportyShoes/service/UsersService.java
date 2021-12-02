package com.Simplilearn.eCommerceSportyShoes.service;

import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;

import java.util.List;

public interface UsersService {
	boolean save(Users users);
	List<Users> getUsers();
	List<Users> findByName(String name);

	boolean usersUpdate(String oldname,String updatedName,String password,String city,String contact,String numberofOrders);
}
