package com.Simplilearn.eCommerceSportyShoes.service;

import com.Simplilearn.eCommerceSportyShoes.entity.LoginUser;


public interface LoginService {

	LoginUser login(String username, String password);
	boolean changePassword(String username, String newPassword);
	LoginUser user(String username);
	LoginUser userID(String id);
}
