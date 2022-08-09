package com.codingdojo.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// putting this up here means all routes start with /greeting
@RequestMapping("/greeting")
public class HomeController {
	
	// the above annotation allows this route to be nothing, its /greeting
	@RequestMapping("")
    public String index(){
      return "This is accessed view http://your_server/simple/root";
    }
	
	// @RequestMapping("/hello") does this same method. 
	@RequestMapping(value="/greeting/hello", method=RequestMethod.GET)
    public String hello(){
      return "Hello world! What route did you use to access me?";
    }
	
	// /greeting/goobye
    @RequestMapping("/goodbye")
    public String world(){
      return "Goodbye world!";
    }
}
