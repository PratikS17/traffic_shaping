package com.example.test.demo;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	SpecificationService serviceForSpecification = new SpecificationService();
	ClientService serviceForClient =new ClientService();
	

	@RequestMapping(method = RequestMethod.GET, path = "/{client}/Min") //Method created to test
	public int getResult(@PathVariable String client)
	{
		return serviceForClient.map.get(client+"_MIN");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{client}/MIN")  //Method created to test
	public long getResultNew(@PathVariable String client)
	{
		return serviceForSpecification.map.get(client+"_GET_MIN");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{name}")
	public String getCall(@PathVariable String name)
	{
		//return new HelloWorldBean("Hello World " + name);
		Limit limit = new LimitOfSpecification().getSpecificationLimit();
		if(!(serviceForClient.checkLimit(name, "SEC") &&
				serviceForClient.checkLimit(name, "MIN") &&
				serviceForClient.checkLimit(name, "HOUR") &&
				serviceForClient.checkLimit(name, "WEEK") &&
				serviceForClient.checkLimit(name, "WEEK")))
		{
			return "The client limit Reached!";
		}
		else if(!(serviceForSpecification.checkLimit(name, "SEC","GET",limit.getSEC()) &&
				serviceForSpecification.checkLimit(name, "MIN","GET",limit.getMIN()) &&
				serviceForSpecification.checkLimit(name, "HOUR","GET",limit.getHOUR()) &&
				serviceForSpecification.checkLimit(name, "WEEK","GET",limit.getWEEK()) &&
				serviceForSpecification.checkLimit(name, "WEEK","GET",limit.getMONTH())))
		{
			return "The specification GET limit reached!";
		}
		else
		{
			return "Call made successfully";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/{name}")
	public String postCall(@PathVariable String name)
	{
		//return new HelloWorldBean("Hello World " + name);
		Limit limit = new LimitOfSpecification().postSpecificationLimit();
		if(!(serviceForClient.checkLimit(name, "SEC") &&
				serviceForClient.checkLimit(name, "MIN") &&
				serviceForClient.checkLimit(name, "HOUR") &&
				serviceForClient.checkLimit(name, "WEEK") &&
				serviceForClient.checkLimit(name, "WEEK")))
		{
			return "The client limit Reached!";
		}
		else if(!(serviceForSpecification.checkLimit(name, "SEC","POST",limit.getSEC()) &&
				serviceForSpecification.checkLimit(name, "MIN","POST",limit.getMIN()) &&
				serviceForSpecification.checkLimit(name, "HOUR","POST",limit.getHOUR()) &&
				serviceForSpecification.checkLimit(name, "WEEK","POST",limit.getWEEK()) &&
				serviceForSpecification.checkLimit(name, "WEEK","POST",limit.getMONTH())))
		{
			return "The specification POST limit reached!";
		}
		else
		{
			return "Call made successfully";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{name}/status")
	public String statusCall(@PathVariable String name)
	{
		//return new HelloWorldBean("Hello World " + name);
		Limit limit = new LimitOfSpecification().statusApiSpecificationLimit();
		if(!(serviceForClient.checkLimit(name, "SEC") &&
				serviceForClient.checkLimit(name, "MIN") &&
				serviceForClient.checkLimit(name, "HOUR") &&
				serviceForClient.checkLimit(name, "WEEK") &&
				serviceForClient.checkLimit(name, "WEEK")))
		{
			return "The client limit Reached!";
		}
		else if(!(serviceForSpecification.checkLimit(name, "SEC","STATUS",limit.getSEC()) &&
				serviceForSpecification.checkLimit(name, "MIN","STATUS",limit.getMIN()) &&
				serviceForSpecification.checkLimit(name, "HOUR","STATUS",limit.getHOUR()) &&
				serviceForSpecification.checkLimit(name, "WEEK","STATUS",limit.getWEEK()) &&
				serviceForSpecification.checkLimit(name, "WEEK","STATUS",limit.getMONTH())))
		{
			return "The specification Status API limit reached!";
		}
		else
		{
			return "Call made successfully";
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{name}/pay")
	public String payCall(@PathVariable String name)
	{
		//return new HelloWorldBean("Hello World " + name);
		Limit limit = new LimitOfSpecification().payApiSpecificationLimit();
		if(!(serviceForClient.checkLimit(name, "SEC") &&
				serviceForClient.checkLimit(name, "MIN") &&
				serviceForClient.checkLimit(name, "HOUR") &&
				serviceForClient.checkLimit(name, "WEEK") &&
				serviceForClient.checkLimit(name, "WEEK")))
		{
			return "The client limit Reached!";
		}
		else if(!(serviceForSpecification.checkLimit(name, "SEC","PAY",limit.getSEC()) &&
				serviceForSpecification.checkLimit(name, "MIN","PAY",limit.getMIN()) &&
				serviceForSpecification.checkLimit(name, "HOUR","PAY",limit.getHOUR()) &&
				serviceForSpecification.checkLimit(name, "WEEK","PAY",limit.getWEEK()) &&
				serviceForSpecification.checkLimit(name, "WEEK","PAY",limit.getMONTH())))
		{
			return "The specification Pay API limit reached!";
		}
		else
		{
			return "Call made successfully";
		}
	}
	
}
