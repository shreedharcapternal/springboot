package com.revision.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String helloWorld() {
		String msg = "Hello world shreedhar here how are you guys";
		System.out.println(msg);
		return msg;
	}
}
