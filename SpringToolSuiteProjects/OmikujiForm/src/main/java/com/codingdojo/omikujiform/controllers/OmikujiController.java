package com.codingdojo.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@GetMapping("/omikuji")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@PostMapping("/info")
	public String info(HttpSession session, @RequestParam(value="num") String num, @RequestParam(value="cityName") String cityName, @RequestParam(value="person") String person, @RequestParam(value="hobby") String hobby, @RequestParam(value="livingThing") String livingThing, @RequestParam(value="compliment") String compliment) {
		session.setAttribute("num", num);
		session.setAttribute("cityName", cityName);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("compliment", compliment);
		return "redirect:/omikuji/show";
	}
		
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		String numAsString = (String) session.getAttribute("num");
		int num = Integer.parseInt(numAsString);
		String cityName = (String) session.getAttribute("cityName");	
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String livingThing = (String) session.getAttribute("livingThing");
		String compliment = (String) session.getAttribute("compliment");
		
		model.addAttribute("num", num);
		model.addAttribute("cityName", cityName);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("livingThing", livingThing);
		model.addAttribute("compliment", compliment);
		return "show.jsp"; 
	}
}
