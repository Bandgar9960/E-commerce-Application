package com.ecom.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.Exception.ResourceNotFoundException;
import com.ecom.Model.User;
import com.ecom.Payloads.UserDto;
import com.ecom.Repository.UserRepo;
import com.ecom.Service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);
		User saveUser = this.userRepo.save(user);
		UserDto userDto2 = this.modelMapper.map(saveUser, UserDto.class);
		return userDto2;
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> allUser = this.userRepo.findAll();
		List<UserDto> allUserDto = allUser.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		return allUserDto;
	}

	@Override
	public UserDto getByUserId(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		UserDto getUser = this.modelMapper.map(user, UserDto.class);

		return getUser;
	}

	@Override
	public void deleteUser(Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		this.userRepo.delete(user);

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
	//	user.setUserId(userDto.getUserId());
		user.setAbout(userDto.getAbout());
		user.setAddress(userDto.getAddress());
		user.setCreateAt(userDto.getCreateAt());
		user.setUpdateAt(userDto.getUpdateAt());
		user.setEmail(userDto.getEmail());
		user.setGender(userDto.getGender());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setPhone(userDto.getPhone());
        
		User saveUser = this.userRepo.save(user);
		UserDto userDto2 = this.modelMapper.map(saveUser, UserDto.class);

		return userDto2;
	}

	@Override
	public UserDto getByUserEmail(String email) {

		User findByEmail = this.userRepo.findByEmail(email);

		UserDto userDto = this.modelMapper.map(findByEmail, UserDto.class);

		return userDto;
	}

}
