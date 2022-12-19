package com.servicesI;

import com.entity.SeriesDetailsBean;

public interface SeriesServiceI {
	public SeriesDetailsBean getSeries(Integer id);
	public SeriesDetailsBean getSeriesNPrices(Integer id);
}
