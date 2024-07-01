package com.ecom.jwtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.jwtservice.security.JWTUtil;

@RestController
@RequestMapping("/jwt-service")
public class JwtController {

	@Autowired
	JWTUtil jwtUtil;
	@PostMapping("/api/tokens")
	public String generateToken(String email, String role) {
		System.out.println(email  + role);
	String jwtToken=jwtUtil.generateToken(email, role);
	System.out.println(jwtToken);
		return jwtToken;
		
	}
	
	@GetMapping("/api/token/validate")
	public String validateToken(@RequestParam("token") String token) {
		System.out.println(token);
		String email= jwtUtil.validateTokenAndRetrieveSubject(token);
		System.out.println(email);
		return email;
	}
}
