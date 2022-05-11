package com.codingdojo.bookclub.controllers;

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

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class BookClubController {
	
    @Autowired
    private UserService userServ;
    @Autowired
    private BookService bookServ;
    
    public BookClubController(UserService userServ, BookService bookServ) {
		this.bookServ = bookServ;
		this.userServ = userServ;
	}
    
    // -------- Login / Registration --------

	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
        
    	userServ.register(newUser, result);
    
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userName", newUser.getUserName());
        session.setAttribute("userId", newUser.getId());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
          
    	User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userName", user.getUserName());
        session.setAttribute("userId", user.getId());
        return "redirect:/books";
    }
    
    // -------- Books --------
    
    // show dashboard 
    @GetMapping("/books")
    public String books(Model model, @ModelAttribute("book") Book book, HttpSession session) {
    	
    	if(session.getAttribute("userName") != null){
    		model.addAttribute("allBooks", bookServ.allBooks());
    		model.addAttribute("userName", session.getAttribute("userName"));
    		model.addAttribute("allusers", userServ.allUsers());
    		return "dashboard.jsp";
    	}else {
    		return "redirect:/";
    	}
    	
    }
    
    // get to make a new book
    @GetMapping("/books/new")
    public String newBook(Model model, @ModelAttribute("book") Book book, HttpSession session) {
    	model.addAttribute("allUsers", userServ.allUsers()); 
    	model.addAttribute("userName", session.getAttribute("userName"));
    	return "addBook.jsp";
    }
    
    // post to make a new book
    @PostMapping("/addedBook")
    public String show(Model model, @Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("allUsers", userServ.allUsers()); 
	    	model.addAttribute("userName", session.getAttribute("userName"));
			return "addBook.jsp";
		}else {
			bookServ.createBook(book);
			return "redirect:/books";
		}
    }
    
    // to view one book
    @GetMapping("/books/{id}")
    public String oneBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, Model model) {
    	model.addAttribute("book", bookServ.findBook(id));
    	model.addAttribute("user", userServ.allUsers());
    	return "oneBook.jsp";
    }
    
    // get to edit a book
    @GetMapping("/books/{id}/edit")
    public String editOneBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book, Model model) {
    	model.addAttribute("book", bookServ.findBook(id));
    	return "editBook.jsp";
    }
    
    // put to edit a book
    @PutMapping("/editedBook/{id}")
    public String editedBook(@Valid @ModelAttribute("book") Book book, BindingResult result, @PathVariable("id") Long id, Model model) {
    	if(result.hasErrors()) {
			model.addAttribute("book", bookServ.findBook(id));
			// you cannot redirect because the error messages created in the model will not apppear. So to include the table (since my create new page is on the same jsp as the table, i need to bring over the table model attributes
			return "editBook.jsp";
		}
		bookServ.updateBook(book);
		return "redirect:/books";
    }
    
    // to logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}
