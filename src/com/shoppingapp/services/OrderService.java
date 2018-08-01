package com.shoppingapp.services;

import com.shoppingapp.dao.OrderDao;

public class OrderService {
	public void makeOrder(int id, String name) {
		OrderDao orderDao = new OrderDao();
		orderDao.writeOrder(id,name);
	}

}
