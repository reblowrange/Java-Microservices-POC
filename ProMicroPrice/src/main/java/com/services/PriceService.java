package com.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.servicesI.PriceServiceI;

@Service
public class PriceService implements PriceServiceI {

	private Map<String, List<String>> prices = new HashMap<String, List<String>>();
	{
		prices.put("C.BRENT.P.D.H",  Arrays.asList("1 jan 2020 - 98.43", "2 jan 2020 - 78.54", "4 jan 2020 - 89.23"));
		prices.put("C.BRENT.P.D.L",  Arrays.asList("1 feb 2019 - 43.12", "3 feb 2020 - 56.23", "7 feb 2020 - 67.24"));
		prices.put("C.BRENT.P.D.C",  Arrays.asList("1 jan 2019 - 89.43", "1 jan 2020 - 98.12", "1 jan 2021 - N.A."));
		prices.put("C.BRENT.P.D.M",  Arrays.asList("23 mar 2021 - 98.43", "24 mar 2021 - 78.23"));
		prices.put("C.BRENT.P.FCL.H",  Arrays.asList("24 dec 2019 - 78.2", "27 dec 2020 - 67.90", "24 dec 2021 - N.A."));
		
	}
	
	@Override
	public List<String> getPrices(String seriesName) {
		return prices.get(seriesName.toUpperCase());
	}

}
