package com.cemal.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import com.cemal.librarymanagementsystem.dto.LoginRequest;
import com.cemal.librarymanagementsystem.dto.RegistrationRequest;
import com.cemal.librarymanagementsystem.dto.TokenResponse;
import com.cemal.librarymanagementsystem.entity.User;
import com.cemal.librarymanagementsystem.repository.UserRepository;
import com.cemal.librarymanagementsystem.security.JwtTokenUtil;
import com.cemal.librarymanagementsystem.service.impl.UserServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
public class AccountController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
		System.out.println(request.getUsername());
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		final User user = userRepository.findByUsername(request.getUsername());
		final String token = jwtTokenUtil.generateToken(user);
		return ResponseEntity.ok(new TokenResponse(user.getUsername(), token));
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest)
			throws AuthenticationException {
		Boolean response = userService.register(registrationRequest);
		return ResponseEntity.ok(response);
	}

}