package com.ecom.Service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.Payloads.CartDto;
import com.ecom.Payloads.ItemRequest;
import com.ecom.Repository.CartRepo;
import com.ecom.Repository.UserRepo;
import com.ecom.Service.CartServiceI;

@Service
public class CartServiceImpl implements CartServiceI {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CartDto addItem(ItemRequest item, String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDto get(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDto removeItem(String username, int itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
