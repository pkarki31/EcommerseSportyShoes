package com.Simplilearn.eCommerceSportyShoes.controller;

import com.Simplilearn.eCommerceSportyShoes.entity.Product;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;
import com.Simplilearn.eCommerceSportyShoes.service.ProductService;
import com.Simplilearn.eCommerceSportyShoes.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UsersController {

	@Autowired
	UsersService usersService;

	//Model model;

	@GetMapping("/users")
	public String listUsers(Model theModel) {

		theModel.addAttribute("users",usersService.getUsers());

		//System.out.print("product :"+prodService.getProdcuts());

		return "dashboard";
	}

	@GetMapping("/searchUser")
	public String searchUserByName(@RequestParam("name") String name,Model theModel) {

		System.out.print("name : "+name);

		theModel.addAttribute("users",usersService.findByName(name));

		//System.out.print("product :"+prodService.getProdcuts());

		return "dashboard";
		//return usersService.findByName(username);
	}

	@GetMapping("/createUser")
	public String createProduct(Model model) {

		System.out.print("inside create product ...");
		model.addAttribute("user",new Users());
		return "createUser";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute(value="user") Users user,Model theModel) {


		boolean created=usersService.save(user);

		if(created){
			theModel.addAttribute("updateProductMsg","User Created Successfully ");

			return "redirect:/users";
		}

		else {

			theModel.addAttribute("updateProductMsg","Something went wrong, Try Again!");

			return "createUser";
		}
	}

	@PostMapping("/usersUpdateToEdit")
	//@RequestMapping(value="/empUpdateToEdit", method = RequestMethod.POST)
	public String usersUpdateToEdit(@ModelAttribute(value="users") Users users, Map<String, Object> model) {
		model.put("users", users);
		return "usersUpdateToEdit";
	}

	@GetMapping("/usersUpdate")
	public String usersUpdate(@RequestParam("oldname") String oldname,
								 @RequestParam("updatedName") String updatedName,
								 @RequestParam("password") String password,@RequestParam("city") String city
			,@RequestParam("contact") String contact,@RequestParam("numberofOrders") String numberofOrders,Model theModel) {



		boolean passwordChanged = usersService.usersUpdate(oldname,updatedName, password,city,contact,numberofOrders);
		if (passwordChanged) {

			theModel.addAttribute("updateProductMsg","User details  Updated Successfully ");

			return "redirect:/users";
		} else {

			theModel.addAttribute("updateProductMsg","Something went wrong, Try Again!");

			return "usersUpdateToEdit";
		}
	}
}
