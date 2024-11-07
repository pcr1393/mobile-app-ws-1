package com.example.com.mobile_app_ws_1.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.com.mobile_app_ws_1.service.UserService;
import com.example.com.mobile_app_ws_1.shared.dto.UserDto;
import com.example.com.mobile_app_ws_1.ui.model.request.UserRequest;
import com.example.com.mobile_app_ws_1.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public String getUsers() {
		return "Hi users";
	}
	
	@PostMapping
	public UserRest addUsers(@RequestBody UserRequest userDetails) {
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}

}
