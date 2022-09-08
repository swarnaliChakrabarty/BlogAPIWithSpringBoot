package com.springboot.blog.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.blog.entities.Role;
import com.springboot.blog.entities.User;
import com.springboot.blog.exceptions.ResourseNotFoundException;
import com.springboot.blog.payloads.UserDto;
import com.springboot.blog.repository.RolesRepo;
import com.springboot.blog.repository.UserRepo;
import com.springboot.blog.services.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private  RolesRepo roleRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
	
		User user=this.dtoToUser(userDto);
		User savedUser=userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		 User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User"," Id ",userId));
		 
		 user.setName(userDto.getName());
		 user.setEmail(userDto.getEmail());
		 user.setPassword(userDto.getPassword());
		 user.setAbout(userDto.getAbout());


		 User updatedUser=userRepo.save(user);
		 return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		 User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User"," Id ",userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User>users=this.userRepo.findAll();
		List<UserDto>userDtos=users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourseNotFoundException("User"," Id ",userId));
		this.userRepo.delete(user);
		
	}
	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user=this.modelMapper.map(userDto,User.class);
		
		//encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		//role
		Role role=this.roleRepo.findById(2).get();
		
		user.getRoles().add(role);
		
		User newUser=this.userRepo.save(user);
		
		return this.modelMapper.map(newUser, UserDto.class);
		
		
		
		
	}
	
	//In place of this 2 method we can use modelMapper libaries
	private User dtoToUser(UserDto userDto) {
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		return user;
		
		User user=this.modelMapper.map(userDto, User.class);
		return user;
	}
	
	private UserDto userToDto(User user) {
//		UserDto dto=new UserDto();
//		dto.setId(user.getId());
//		dto.setName(user.getName());
//		dto.setEmail(user.getEmail());
//		dto.setPassword(user.getPassword());
//		dto.setAbout(user.getAbout());
//		return dto;
		return this.modelMapper.map(user, UserDto.class);
	
		
	}

	
}
