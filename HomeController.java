package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CreateUserRequestModel;
import com.example.demo.model.CreateUserResponseModel;
import com.example.demo.services.UsersService;
import com.example.demo.sharedData.UserDto;
@RestController
@RequestMapping("/users")
//@CrossOrigin("*")
public class HomeController {

	@Autowired
	private Environment env;

	@Autowired
	UsersService usersService;

	@GetMapping("/status/check")
	public String status()
	{
		 System.out.println("\n--------"+ "this is check method"+"\n>>>>>>>>>>>\n");
	return "Working on port " + env.getProperty("local.server.port");
	}
	 

	@PostMapping
	public ResponseEntity<CreateUserResponseModel> createUser(@RequestBody CreateUserRequestModel userDetails)
	{
		 System.out.println("\n---++++++++++++-----"+ "this is save method"+"\n>>>>>>++++++++>>>>>\n");
	ModelMapper modelMapper = new ModelMapper();
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	UserDto userDto = modelMapper.map(userDetails, UserDto.class);

	UserDto createdUser = usersService.createUser(userDto);

	CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);

	return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}


}
