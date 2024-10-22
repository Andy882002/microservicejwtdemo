package com.example.demo.services;

import java.util.UUID;
import org.modelmapper.ModelMapper;

import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserEntity;
import com.example.demo.repository.UsersRepository;
import com.example.demo.sharedData.UserDto;

@Service
public class UsersServiceImpl implements UsersService{
	
	UsersRepository usersRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	ModelMapper modelMapper;

	public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncode, ModelMapper modelMappe) {
		
		this.usersRepository = usersRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncode;
		this.modelMapper = modelMappe;
	}
	

	
	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub the issue is after version 3.0.0 modelMapping is not able map the encrypepassword
		
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncrypetedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		System.out.println("^^$$$>> ---->>>>  "+userDetails.getEncrypetedPassword());
		//ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		System.out.println("#++++---->>>>  "+userEntity.getEncryptedPassword());
		userEntity.setEncryptedPassword(userDetails.getEncrypetedPassword());
		
		System.out.println("***---->>>>  "+userEntity.getEncryptedPassword());
		usersRepository.save(userEntity);
		System.out.println("***>>>>  "+userEntity.toString());
		UserDto returnValue = modelMapper.map(userEntity, UserDto.class);
		System.out.println("^^@@@>> ---->>>>  "+returnValue.getEncrypetedPassword());
		return returnValue;
	}

}
