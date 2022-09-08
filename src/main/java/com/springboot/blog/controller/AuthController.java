package com.springboot.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payloads.UserDto;
import com.springboot.blog.security.JwtAuthRequest;
import com.springboot.blog.security.JwtAuthResponse;
import com.springboot.blog.security.JwtTokenHelper;
import com.springboot.blog.services.UserService;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		
		
		this.authenticate(request.getUsername(),request.getPassword());
		UserDetails userDetail=this.userDetailsService.loadUserByUsername(request.getUsername());
		String token=this.jwtTokenHelper.generateToken(userDetail);
		JwtAuthResponse response =new JwtAuthResponse();
		response.setToken(token);
		return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);
	}


	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
		try {
		this.authenticationManager.authenticate(authenticationToken);
		}
		catch(BadCredentialsException e) {
			System.out.print("Invalid Details");
			throw new Exception("Invalid Username or Password");
		}
		
		
	}
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
		UserDto registerUser=this.userService.registerNewUser(userDto);
		return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
	}
}
