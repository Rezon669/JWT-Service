//package com.ecom.jwtservice.service;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EncryptDecryptService {
//
//	private static final Logger logger = LogManager.getLogger(EncryptDecryptService.class);
//	
//
//	@Value("${SECRET_KEY}")
//	private String secretkey;
//
//	public String setEncryptedToken(String jwttoken) {
//	
//
//		try {
//			Cipher cipher = Cipher.getInstance("AES");
//			SecretKeySpec secretKey = new SecretKeySpec(secretkey.getBytes(StandardCharsets.UTF_8), "AES");
//			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//
//			byte[] encryptedBytes = cipher.doFinal(jwttoken.getBytes());
//			String encryptedToken = Base64.getEncoder().encodeToString(encryptedBytes);
//			return encryptedToken;
//		} catch (Exception e) {
//			// Handle encryption error
//			logger.error(e);
//			return "Error: " + e.getMessage();
//		}
//	}
//
//	public String getDecryptedToken(String cookieString) {
//		try {
//			if (!cookieString.isEmpty()) {
//
//				String[] parts = cookieString.split("; ");
//
//				for (String part : parts) {
//					if (part.startsWith("token=")) {
//					
//						cookieString = part.substring(6);
//
//						break; 
//					}
//				}
//
//				Cipher cipher = Cipher.getInstance("AES");
//				SecretKeySpec secretKey = new SecretKeySpec(secretkey.getBytes(), "AES");
//				cipher.init(Cipher.DECRYPT_MODE, secretKey);
//
//				byte[] decodedBytes = Base64.getDecoder().decode(cookieString);
//				byte[] decryptedBytes = cipher.doFinal(decodedBytes);
//				String decryptedToken = new String(decryptedBytes);
//
//				return decryptedToken;
//			} else {
//				return "No encrypted token found in the cookie";
//			}
//		} catch (Exception e) { // Handle decryption error
//			return "Decryption error: " + e.getMessage();
//		}
//
//	}
//}
