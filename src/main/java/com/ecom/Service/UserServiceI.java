package com.ecom.Service;

import java.util.List;

import com.ecom.Payloads.UserDto;

public interface UserServiceI {

	UserDto createUser(UserDto userDto);

	List<UserDto> getAllUsers();

	UserDto getByUserId(Integer userId);

	void deleteUser(Integer userId);

	UserDto updateUser(UserDto userDto, Integer userId);
	
	UserDto getByUserEmail(String email);
	

}
