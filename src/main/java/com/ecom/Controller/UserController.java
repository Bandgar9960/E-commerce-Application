package com.ecom.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Payloads.ApiResponse;
import com.ecom.Payloads.UserDto;
import com.ecom.Service.UserServiceI;

/**
 * Controller Class for creating User Api
 * 
 * @author Lenovo
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceI userServiceI;

	// Insert The User Data

	/**
	 * creating User Api Add User
	 * 
	 * @param userDto
	 * @return
	 */
	@PostMapping("/")
	public ResponseEntity<UserDto> creatUser(@Valid @RequestBody UserDto userDto) {

		UserDto createUser = userServiceI.createUser(userDto);

		return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);

	}

	// Get All User Data
	
	/**
	 * creating User Method for Get all User Data
	 * @return
	 */
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers() {

		List<UserDto> allUsers = this.userServiceI.getAllUsers();

		return new ResponseEntity<List<UserDto>>(allUsers, HttpStatus.OK);

	}

	// Get single User Data
	
	/**
	 * get Single User Data
	 * @param userId
	 * @return
	 */

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
		UserDto UserbyId = this.userServiceI.getByUserId(userId);

		return new ResponseEntity<UserDto>(UserbyId, HttpStatus.OK);

	}

	// Get single User By Email
	@GetMapping("/mail/{email}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
		UserDto UserbyEmail = this.userServiceI.getByUserEmail(email);

		return new ResponseEntity<UserDto>(UserbyEmail, HttpStatus.OK);

	}

	// Update User Data
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {

		UserDto updateUser = this.userServiceI.updateUser(userDto, userId);

		return new ResponseEntity<UserDto>(updateUser, HttpStatus.CREATED);

	}

	// Delete User Data
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {

		this.userServiceI.deleteUser(userId);

		return new ResponseEntity<ApiResponse>(new ApiResponse("User Delete Successfully", true), HttpStatus.OK);

	}

}
