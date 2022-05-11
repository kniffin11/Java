package com.codingdojo.daikichi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// ctrl + shift + o will auto import annotations in the code
@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("/{num}")
	public String welcome(@PathVariable("num") String num) {
		int iterations = Integer.parseInt(num);
		for(int i = 0; i < iterations; i++) {
			System.out.println("Welcome!");
		}
		return "printed Welcome! in the console";
	}
	
	@RequestMapping("/today/{num}")
	public String today(@PathVariable("num") String num) {
		int iterations = Integer.parseInt(num);
		for(int i = 0; i < iterations; i++) {
			System.out.println("Today you will find luck in all your endeavors!");
		}
		return "This now has a path variable";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
	@RequestMapping("/travel/kyoto")
	public String travel() {
		return "Congradulations! You will soon travel to Kyoto!";
	}
	
	// all url variables are strings 
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") String num) {
		int input = Integer.parseInt(num);
		if(input % 2 == 0) {
			return "You will take a grand hourney in the near future, but be wary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}
}
