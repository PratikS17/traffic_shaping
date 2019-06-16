package com.example.test.demo;

public class LimitOfSpecification {
	
	public Limit getSpecificationLimit()
	{
		return new Limit(0,5,0,700,0); 
	}
	
	public Limit postSpecificationLimit()
	{
		return new Limit(20,0,40,900,1000);
	}
	
	public Limit statusApiSpecificationLimit()
	{
		return new Limit(20,0,40,900,1000);
	}
	
	public Limit payApiSpecificationLimit()
	{
		return new Limit(10,50,0,700,0);
	}

}
