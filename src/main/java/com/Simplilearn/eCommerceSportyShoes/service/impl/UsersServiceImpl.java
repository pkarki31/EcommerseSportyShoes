package com.Simplilearn.eCommerceSportyShoes.service.impl;

import com.Simplilearn.eCommerceSportyShoes.entity.LoginUser;
import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;
import com.Simplilearn.eCommerceSportyShoes.repository.ProductRepository;
import com.Simplilearn.eCommerceSportyShoes.repository.UsersRepository;
import com.Simplilearn.eCommerceSportyShoes.service.ProductService;
import com.Simplilearn.eCommerceSportyShoes.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public boolean save(Users users) {
		usersRepository.save(users);

		if(Objects.nonNull(users)){

			return true;
		}

		else {

			return false;
		}
	}

	@Override
	public List<Users> getUsers() {
		return usersRepository.findAll();
	}

	public List<Users> findByName(String username) {
		//System.out.println("username impl : "+username);


		List<Users> user = usersRepository.findAllByName(username);
		System.out.println("user list size : " + user.size());
		return user;
	}



	public boolean usersUpdate(String oldname,String updatedName,String password,String city,String contact,String numberofOrders) {
		Users users = usersRepository.findByName(oldname);
		if (Objects.nonNull(users)) {
			usersRepository.updateUsers(updatedName,password,city,contact,numberofOrders, users.getId());
			System.out.println("updated successfully ");
			return true;
		} else {
			System.out.println("Unable to change the user details!");
			return false;
		}

	}
}
