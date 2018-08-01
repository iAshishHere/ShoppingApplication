package com.shoppingapp.services;


import com.shoppingapp.dao.UserDao;
import com.shoppingapp.pojos.UserDetails;

public class UserService {
	
	public boolean doValidation(UserDetails userDetails)
	{
		UserDao lb = new UserDao();
		return lb.readUserDetails(userDetails);
	}

}
