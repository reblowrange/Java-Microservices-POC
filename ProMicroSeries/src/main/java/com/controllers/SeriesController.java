package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.SeriesDetailsBean;
import com.servicesI.SeriesServiceI;

@RestController
@RequestMapping("/series")
public class SeriesController {

	@Autowired
	private SeriesServiceI seriesService;
	
	@GetMapping()
	public ResponseEntity<SeriesDetailsBean> getSeries(@RequestParam(name = "id", required = true) Integer id) {
		return new ResponseEntity<SeriesDetailsBean>(seriesService.getSeries(id), HttpStatus.OK);
	}
	
	@GetMapping("/series_n_prices")
	public SeriesDetailsBean getSeriesNPrices(@RequestParam(name = "id", required = true) Integer id) {
		return seriesService.getSeriesNPrices(id);
	}
}
