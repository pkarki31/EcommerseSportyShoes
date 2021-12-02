package com.Simplilearn.eCommerceSportyShoes.service;

import com.Simplilearn.eCommerceSportyShoes.entity.Orders;
import com.Simplilearn.eCommerceSportyShoes.entity.Users;

import java.util.List;

public interface OrdersService {
	boolean save(Orders orders);
	List<Orders> getOrders();
	List<Orders> findByName(String name);


}
