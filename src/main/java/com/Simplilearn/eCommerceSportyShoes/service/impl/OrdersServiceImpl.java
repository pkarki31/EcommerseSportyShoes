package com.Simplilearn.eCommerceSportyShoes.service.impl;

import com.Simplilearn.eCommerceSportyShoes.entity.Orders;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;
import com.Simplilearn.eCommerceSportyShoes.repository.OrdersRepository;
import com.Simplilearn.eCommerceSportyShoes.repository.UsersRepository;
import com.Simplilearn.eCommerceSportyShoes.service.OrdersService;
import com.Simplilearn.eCommerceSportyShoes.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public boolean save(Orders orders) {
		ordersRepository.save(orders);

		if(Objects.nonNull(orders)){

			return true;
		}

		else {

			return false;
		}
	}

	@Override
	public List<Orders> getOrders() {
		return ordersRepository.findAll();
	}

	public List<Orders> findAllByCategory(String category) {
		System.out.println("username impl : "+category);


		List<Orders> orders = ordersRepository.findAllByCategory(category);
		System.out.println("user list size : " + orders.size());
		return orders;
	}

	public List<Orders> findAllByDate(String date) {
		System.out.println("username impl : "+date);


		List<Orders> orders = ordersRepository.findAllByDate(date);
		System.out.println("user list size : " + orders.size());
		return orders;
	}




}
