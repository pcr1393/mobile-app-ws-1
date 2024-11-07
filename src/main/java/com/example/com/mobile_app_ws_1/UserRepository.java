package com.example.com.mobile_app_ws_1;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.com.mobile_app_ws_1.io.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);

}
