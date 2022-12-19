package com.entity;

import java.util.List;

public class SeriesDetailsBean {
	/**
	 * 
	 */
	//private static final long serialVersionUID = -8798824231378562647L;/
	private Integer id;
	private String name;
	private String frequency;
	private List<String> prices;
	
	public SeriesDetailsBean() {}
	
	public SeriesDetailsBean(Integer id, String name, String frequency) {
		super();
		this.id = id;
		this.name = name;
		this.frequency = frequency;
	}
	public SeriesDetailsBean(Integer id, String name, String frequency, List<String> prices) {
		super();
		this.id = id;
		this.name = name;
		this.frequency = frequency;
		this.prices = prices;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public List<String> getPrices() {
		return prices;
	}
	public void setPrices(List<String> prices) {
		this.prices = prices;
	}
	
	
}
