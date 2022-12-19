package com.promicroseries;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.controllers.SeriesController;
import com.entity.SeriesDetailsBean;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProMicroSeriesApplicationTests {

	@InjectMocks
	private SeriesController seriesController;
	
	@LocalServerPort
	private int localPort;
	
	@Test
	public void contextLoads() {
		// Check whether Series Controller should not null
		assertThat(seriesController).isNotNull();
	}

	@Test
	public void testSeriesRest() throws Exception {
		int id = 4;
		
		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:" + localPort + "/series?id=" + id;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
	     
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	    assertNotNull(result.getBody());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testSeriesWithPriceRest() throws URISyntaxException {
		int id = 3;
		RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> entity = new HttpEntity(headers);
	    final String baseUrl = "http://localhost:" + localPort + "/series/series_n_prices?id=" + id;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<SeriesDetailsBean> result = restTemplate.exchange(uri, HttpMethod.GET,entity, new ParameterizedTypeReference<SeriesDetailsBean>() {});	     
	    
	    // ResponseEntity<Object> result = restTemplate.getForEntity(uri, Object.class);
	    //Verify request succeed
	    assertEquals(200, result.getStatusCodeValue());
	    assertEquals(id, result.getBody().getId());
	    assertEquals("C.BRENT.P.D.C", result.getBody().getName());
	    assertEquals("DAILY", result.getBody().getFrequency());
	    assertNotNull(result.getBody().getPrices());
	}
}
