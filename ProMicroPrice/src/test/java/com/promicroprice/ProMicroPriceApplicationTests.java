package com.promicroprice;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.controllers.PricesController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProMicroPriceApplicationTests {

	@InjectMocks
	private PricesController pricesController;
	
	@LocalServerPort
	private int localPort;
	
	@Test
	public void contextLoads() {
		// Check whether Series Controller should not null
		assertThat(pricesController).isNotNull();
	}


	@Test
	public void testPricesRest() throws Exception {
		String series = "C.BRENT.P.D.H";
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + localPort + "/prices?series=" + series;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	    assertNotNull(result.getBody());
	}
}
