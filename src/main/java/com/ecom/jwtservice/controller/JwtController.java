package com.ecom.jwtservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.jwtservice.security.JWTUtil;

@RestController
@RequestMapping("/ecom/api")
public class JwtController {
	
	private final Logger log = LogManager.getLogger(JwtController.class);

	@Autowired
	JWTUtil jwtUtil;

	@PostMapping("/generatetoken")
	public String generateToken(String email, String role) {
		log.info("Generating the token...!");
		String jwtToken = jwtUtil.generateToken(email, role);
		return jwtToken;

	}

	@GetMapping("/validatetoken")
	public String validateToken(@RequestParam("token") String token) {
		log.info("Validating the token...!");
		String email = jwtUtil.validateTokenAndRetrieveSubject(token);
		return email;
	}

	@GetMapping("/token/getrole")
	public List<String> getRolesFromToken(@RequestParam("token") String token) {
		log.info("Extracting the role from the token...!");
		List<String> roles = jwtUtil.getRolesFromToken(token);
		return roles;
	}
}
