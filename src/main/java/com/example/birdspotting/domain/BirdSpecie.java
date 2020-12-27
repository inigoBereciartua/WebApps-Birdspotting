package com.example.birdspotting.domain;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BirdSpecie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "{birdSpecie.blank}")
	private String name;
		
	@NotNull(message = "{birdSpecie.blank}")
	@Min(value = 1250, message = "{birdspecie.yearOfDiscovery.min}")
    private Integer yearOfDiscovery;
	
	@NotEmpty(message = "{birdSpecie.blank}")
	@Pattern(regexp = "[A-Z]{1,2}[0-9]{3}", message = "{birdSpecie.code.format}")
    private String code;
		
	public BirdSpecie(String name, Integer yearOfDiscovery, String code) {
		super();
		this.name = name;
		this.yearOfDiscovery = yearOfDiscovery;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearOfDiscovery() {
		return yearOfDiscovery;
	}

	public void setYearOfDiscovery(Integer yearOfDiscovery) {
		this.yearOfDiscovery = yearOfDiscovery;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format("%s - %d (%s)", getName(), getYearOfDiscovery(), getCode());
	}
		
	@Override
    public boolean equals(Object obj) {
       if (this == obj) {    	   
    	   return true;
       }
       if (obj == null || getClass() != obj.getClass()) {
    	   return false;    	   
       }
       BirdSpecie other = (BirdSpecie) obj;
       if (!code.equals(other.code)) {    	   
    	   return false;
       }
       return name.equalsIgnoreCase(other.name);
    }

	
	
}
