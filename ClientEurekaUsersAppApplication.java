package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.domain.UserEntity;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
public class ClientEurekaUsersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientEurekaUsersAppApplication.class, args);
		System.out.println("The Eureka Client Running");
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public ModelMapper modelMapper(){
	        ModelMapper modelMapper = new ModelMapper();
	        //modelMapper.addMappings(UserEntity.class);
	        return modelMapper;
	    }

}
