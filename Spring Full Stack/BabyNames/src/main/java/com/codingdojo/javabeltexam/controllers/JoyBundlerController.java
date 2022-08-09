package com.codingdojo.javabeltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.javabeltexam.models.JoyBundler;
import com.codingdojo.javabeltexam.models.LoginUser;
import com.codingdojo.javabeltexam.models.User;
import com.codingdojo.javabeltexam.services.JoyBundlerService;
import com.codingdojo.javabeltexam.services.UserService;

@Controller
public class JoyBundlerController {

	@Autowired
    private UserService userServ;
	
	@Autowired
	private JoyBundlerService joyBundServ;
    
    public JoyBundlerController(UserService userServ, JoyBundlerService joyBundServ) {
		this.userServ = userServ;
		this.joyBundServ = joyBundServ;
	}
    
	// -------- Login / Registration --------

		@GetMapping("/")
	    public String index(Model model) {
	    
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
		// Register route
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
	        
	    	userServ.register(newUser, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        
	        session.setAttribute("userName", newUser.getUserName());
	        session.setAttribute("userId", newUser.getId());
	        return "redirect:/home";
	    }
	    
	    // login route
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	          
	    	User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        session.setAttribute("userName", user.getUserName());
	        session.setAttribute("userId", user.getId());
	        return "redirect:/home";
	    }
	    
	    // --------- Joy Bundler Routes ----------
	    
	    // Display home page
	    @GetMapping("/home")
	    public String home(Model model, HttpSession session) {
	    	if(session.getAttribute("userName") != null){
	    		model.addAttribute("allJoyBundles", joyBundServ.allJoyBundles());
	    		model.addAttribute("userName", session.getAttribute("userName"));
	    		model.addAttribute("allusers", userServ.allUsers());
	    		return "home.jsp";
	    	}else {
	    		return "redirect:/";
	    	}
	    }
	    
	    // Render new name 
	    @GetMapping("/names/new")
	    public String newName(Model model, @ModelAttribute("joyBundle") JoyBundler joyBundle, HttpSession session) {
	    	if(session.getAttribute("userName") != null){
		    	model.addAttribute("allUsers", userServ.allUsers()); 
		    	model.addAttribute("userName", session.getAttribute("userName"));
		    	return "addName.jsp";
	    	}else {
	    		return "redirect:/";
	    	}
	    }
	    
	    // Process new Name
	    @PostMapping("/addedName")
	    public String addedName(Model model, @Valid @ModelAttribute("joyBundle") JoyBundler joyBundle, BindingResult result, HttpSession session) {
			if(result.hasErrors()) {
				model.addAttribute("allUsers", userServ.allUsers()); 
		    	model.addAttribute("userName", session.getAttribute("userName"));
		    	model.addAttribute("userId", session.getAttribute("userId"));
				return "addName.jsp";
			}else {
				joyBundServ.createJoyBundler(joyBundle);
				return "redirect:/home";
			}
	    }
	    
	    // Render one name
	    @GetMapping("/names/{id}")
	    public String oneName(@PathVariable("id") Long id, @ModelAttribute("joyBundle") JoyBundler joyBundle, Model model, HttpSession session) {
	    	if(session.getAttribute("userName") != null){
		    	model.addAttribute("joyBundle", joyBundServ.findJoyBundler(id));
		    	model.addAttribute("user", userServ.allUsers());
		    	return "oneName.jsp";
	    	}else {
	    		return "redirect:/";
	    	}
	    }
	    
	    // Render edit name
	    @GetMapping("/names/{id}/edit")
	    public String editOneName(@PathVariable("id") Long id, @ModelAttribute("joyBundle") JoyBundler joyBundle, Model model, HttpSession session) {
	    	if(session.getAttribute("userName") != null){
	    		model.addAttribute("joyBundle", joyBundServ.findJoyBundler(id));
	    		model.addAttribute("sessionUserId", session.getAttribute("userId"));
	    		return "editName.jsp";
	    	} else {
	    		return "redirect:/";
	    	}
	    }
	    
	    // Put edited name
	    @PutMapping("/editedName/{id}")
	    public String editedName(@Valid @ModelAttribute("joyBundle") JoyBundler joyBundle, BindingResult result, @PathVariable("id") Long id, Model model) {
	    	if(result.hasErrors()) {
				return "editName.jsp";
			}
	    	joyBundServ.updateJoyBundler(joyBundle);
			return "redirect:/home";
	    }
	    
	    // Get delete name
	    @GetMapping("/delete/{id}")
	    public String delete(@PathVariable("id") Long id, HttpSession session) {
	    	if(session.getAttribute("userName") != null){
	    		joyBundServ.deleteJoyBundler(id);
	    		return "redirect:/home";
	    	}else {
	    		return "redirect:/";
	    	}
	    }
	    
	    // Cancel
	    @GetMapping("/cancel")
	    public String cancel(Model model, HttpSession session) {
	    	if(session.getAttribute("userName") != null){
	    		model.addAttribute("allJoyBundles", joyBundServ.allJoyBundles());
	    		model.addAttribute("userName", session.getAttribute("userName"));
	    		model.addAttribute("allusers", userServ.allUsers());
	    		return "redirect:/home";
	    	}else {
	    		return "redirect:/";
	    	}
	    }
	    
	    // Logout
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
}
