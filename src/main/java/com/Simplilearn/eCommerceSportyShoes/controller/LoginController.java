package com.Simplilearn.eCommerceSportyShoes.controller;

import com.Simplilearn.eCommerceSportyShoes.entity.LoginUser;
import com.Simplilearn.eCommerceSportyShoes.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Controller
public class LoginController {

	@Autowired
	LoginService loginService;



	@GetMapping("/login")
	public String loginUser(@RequestParam("username") String username,
							@RequestParam("password") String password,Model theModel) {
		System.out.println("username : "+username);
		System.out.println("password : "+password);
		LoginUser loggedInUser = loginService.login(username, password);
		if (Objects.nonNull(loggedInUser)) {
			return "dashboard";
		} else {

			theModel.addAttribute("text","Invalid Credentials ");
				return "welcome";
		}
	}





	@GetMapping("/welcome")
	public String welcome(){

		return "welcome";
	}

	@GetMapping("/usersID")
	public String getUserID(@RequestParam("id") String id) {

		LoginUser loggedInUser = loginService.userID(id);

		return loggedInUser.toString();

	}



	@GetMapping("/changePassword")
	public String changePassword(@RequestParam("username") String username,
								 @RequestParam("newPassword") String newPassword,Model theModel) {

		boolean passwordChanged = loginService.changePassword(username, newPassword);
		if (passwordChanged) {

			theModel.addAttribute("changePasswordMsg","Your Password has been changed .");

			return "dashboard";
		} else {

			theModel.addAttribute("changePasswordMsg","Something went wrong, Try Again!");

			return "changePasswordPage";
		}
	}

	@GetMapping("/changePasswordPage")
	public String changePasswordPage() {

		return "changePasswordPage";
	}

	@GetMapping("/logOut")
	public String logOut(Model theModel) {

		theModel.addAttribute("text","Your are Logout Successfully ! ");

		return "welcome";
	}
}
