package com.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.entity.SeriesDetailsBean;
import com.servicesI.SeriesServiceI;

@Service
public class SeriesService implements SeriesServiceI {
	@Autowired
	private RestTemplate restTemplate;
	
	private List<SeriesDetailsBean> data = Arrays.asList(
			new SeriesDetailsBean(1, "C.BRENT.P.D.H", "BUSINESS"),
			new SeriesDetailsBean(2, "C.BRENT.P.D.L", "BUSINESS"),
			new SeriesDetailsBean(3, "C.BRENT.P.D.C", "DAILY"),
			new SeriesDetailsBean(4, "C.BRENT.P.D.M", "BUSINESS"),
			new SeriesDetailsBean(5, "C.BRENT.P.FCL.H", "DAILY")
			);
	
	@Override
	public SeriesDetailsBean getSeries(Integer id) {
		return data.stream().filter(x -> x.getId() == id).findAny().orElseThrow();
	}

	@Override
	public SeriesDetailsBean getSeriesNPrices(Integer id) {
		SeriesDetailsBean filterd = data.stream().filter(x -> x.getId() == id).findAny().orElseThrow();
		SeriesDetailsBean output = new SeriesDetailsBean(filterd.getId(), filterd.getName(), filterd.getFrequency());
		if (output != null) {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<List<String>> entity = new HttpEntity<List<String>>(headers);
		    
		    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://pro-micro-prices/prices")
		            .queryParam("series", output.getName());

		     @SuppressWarnings("unchecked")
			List<String> prices = (List<String>) restTemplate.exchange(
		    		  builder.toUriString(), HttpMethod.GET, entity, List.class).getBody();
		     output.setPrices(prices);
		}
		return output;
	}

}
