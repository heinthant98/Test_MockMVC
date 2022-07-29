package com.rest.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Greeting;

@RestController
@RequestMapping("/hello")
public class GreetingController {

	private static String template ="Hello, %s!";
	
	private final AtomicInteger counter = new AtomicInteger();
	
	@GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping()
	public String hello() {
		return "Hello World!";
	}
}
