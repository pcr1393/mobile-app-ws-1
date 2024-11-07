package com.example.com.mobile_app_ws_1.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.com.mobile_app_ws_1.UserRepository;
import com.example.com.mobile_app_ws_1.io.entity.UserEntity;
import com.example.com.mobile_app_ws_1.service.UserService;
import com.example.com.mobile_app_ws_1.shared.Utils;
import com.example.com.mobile_app_ws_1.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		
		if(userRepository.findByEmail(userDto.getEmail()) != null) throw new RuntimeException("Record Already Exists");
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setEncryptedPassword("Test");
		String newUserId = utils.generateUserId(30);
		userEntity.setUserId(newUserId);
		
		UserEntity returnedEntity = userRepository.save(userEntity);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(returnedEntity, returnValue);
		return returnValue;
	}

}
