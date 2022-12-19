package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servicesI.PriceServiceI;

@RestController
@RequestMapping("/prices")
public class PricesController {
	
	@Autowired PriceServiceI priceService;
	
	@GetMapping()
	public List<String> getPrices(@RequestParam(name = "series", required = true) String seriesName){
		return priceService.getPrices(seriesName);
	}
}
