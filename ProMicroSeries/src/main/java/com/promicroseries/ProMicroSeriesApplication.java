package com.promicroseries;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.controllers", "com.services"})
@EnableDiscoveryClient
public class ProMicroSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProMicroSeriesApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	private void testCrypt() {
		String userPassword = "Reblow";
		byte[] salt = new byte[12];
        new SecureRandom().nextBytes(salt);
	        
	    KeySpec spec = new PBEKeySpec(userPassword.toCharArray(), salt, 4096, 256 * 8); 
	    SecretKeyFactory f;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			System.out.println(f.generateSecret(spec).getEncoded().toString()); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
