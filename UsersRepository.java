package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserEntity;
@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
	UserEntity findByUserId(String userId);
}
