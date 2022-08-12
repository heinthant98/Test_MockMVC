package com.rest.model;

public class Greeting {

	private Integer id;
	private String greetings;
	
	
	
	
	
	
	public Greeting(Integer id, String greetings) {
		super();
		this.id = id;
		this.greetings = greetings;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
	}

}
