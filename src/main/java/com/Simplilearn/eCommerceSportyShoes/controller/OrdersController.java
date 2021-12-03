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

	@GetMapping("/searchOrderByCategory")
	public String searchOrderByCategory(@RequestParam("category") String category,Model theModel) {

		theModel.addAttribute("orders",ordersService.findAllByCategory(category));

		return "dashboard";

	}

	@GetMapping("/searchOrderByDate")
	public String searchOrderByDate(@RequestParam("date") String date,Model theModel) {

		theModel.addAttribute("orders",ordersService.findAllByDate(date));

		return "dashboard";

	}








}
