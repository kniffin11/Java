package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired // either include this @AutoWired for repo injection, or use "private final UserRepository userRepo" -- they're the same 
    private UserRepository userRepo;
  
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
    	
        // Reject if email is taken (present in database)
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "Email taken");
    	}
    	
        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "Matches", "your passwords don't match");
    	}
    	
        // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}
    	
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        
        return userRepo.save(newUser);
    }
    public User login(LoginUser newLogin, BindingResult result) {
    	// TO-DO - Reject values:
        
    	// Find user in the DB by email
    	// Reject if NOT present
    	Optional<User> potUser = userRepo.findByEmail(newLogin.getEmail());
    	if(!potUser.isPresent()) {
    		result.rejectValue("email", "Unique", "We dont know you; email doesnt exist in db");
    		return null;
    	}
        User user = potUser.get();
        
        // Reject if BCrypt password match fails
        // compares newlogin pass vs user pass for a match
    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Password doesnt match in the db");
    		return null;
    	}
    	
        // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}else {
    	// Otherwise return user object
    		return user;
    	}
    }
    
    //find all users
    public List<User> allUsers(){
    	return userRepo.findAll();
    }
    
    // find a user
    public User findUser(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
			return null;
		}
	}
}
