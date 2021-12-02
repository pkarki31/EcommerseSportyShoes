package com.Simplilearn.eCommerceSportyShoes.service.impl;

import com.Simplilearn.eCommerceSportyShoes.entity.LoginUser;
import com.Simplilearn.eCommerceSportyShoes.repository.LoginRepository;
import com.Simplilearn.eCommerceSportyShoes.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public LoginUser login(String username, String password) {
		System.out.println("username impl : "+username);
		System.out.println("password impl : "+password);

		LoginUser user = loginRepository.findByUsernameAndPassword(username, password);
		System.out.println("User found : " + user);
		return user;
	}

	public LoginUser user(String username) {
		//System.out.println("username impl : "+username);


		LoginUser user = loginRepository.findByUsername(username);
		System.out.println("User password found : " + user.getPassword());
		return user;
	}

	public LoginUser userID(String id) {
		//System.out.println("username impl : "+username);


		LoginUser user = loginRepository.findAllById(id);
		System.out.println("User found : " + user);
		return user;
	}

	public boolean changePassword(String username, String newPassword) {
		LoginUser user = loginRepository.findByUsername(username);
		if (Objects.nonNull(user)) {
			loginRepository.changePassword(newPassword, user.getId());
			System.out.println("User " + user.getUsername() + " has successfuly changed the password");
			return true;
		} else {
			System.out.println("Unable to change the password!");
			return false;
		}

	}

}
