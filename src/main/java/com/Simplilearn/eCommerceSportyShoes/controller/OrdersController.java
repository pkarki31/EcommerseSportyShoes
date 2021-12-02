package com.Simplilearn.eCommerceSportyShoes.controller;

import com.Simplilearn.eCommerceSportyShoes.entity.Users;
import com.Simplilearn.eCommerceSportyShoes.service.OrdersService;
import com.Simplilearn.eCommerceSportyShoes.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class OrdersController {

	@Autowired
	OrdersService ordersService;

	//Model model;

	@GetMapping("/orders")
	public String listUsers(Model theModel) {

		theModel.addAttribute("orders",ordersService.getOrders());

		//System.out.print("product :"+prodService.getProdcuts());

		return "dashboard";
	}
//
//	@GetMapping("/searchUser")
//	public String searchUserByName(@RequestParam("name") String name,Model theModel) {
//
//		System.out.print("name : "+name);
//
//		theModel.addAttribute("users",usersService.findByName(name));
//
//		//System.out.print("product :"+prodService.getProdcuts());
//
//		return "dashboard";
//		//return usersService.findByName(username);
//	}








}
