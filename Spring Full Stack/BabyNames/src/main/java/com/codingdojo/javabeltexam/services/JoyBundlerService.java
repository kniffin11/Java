package com.codingdojo.javabeltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.javabeltexam.models.JoyBundler;
import com.codingdojo.javabeltexam.repository.JoyBundlerRepository;

@Service
public class JoyBundlerService {

	// Inject repo
	@Autowired 
	private JoyBundlerRepository joyBundRepo;

	// Constructor
	public JoyBundlerService(JoyBundlerRepository joyBundRepo) {
		this.joyBundRepo = joyBundRepo;
	}
	
	// Get a list of all JoyBundles
	public List<JoyBundler> allJoyBundles(){
		return joyBundRepo.findAll();
	}
	
	// Get one JoyBundle
	public JoyBundler findJoyBundler(Long id) {
		Optional<JoyBundler> optjb = joyBundRepo.findById(id);
		if(optjb.isPresent()) {
			return optjb.get();
		}else {
			return null;
		}
	}
	
	// Create a JoyBundler
	public JoyBundler createJoyBundler(JoyBundler j) {
		return joyBundRepo.save(j);
	}
	
	// Update a JoyBundler
	public JoyBundler updateJoyBundler(JoyBundler j) {
		return joyBundRepo.save(j);
	}
	
	// Delete a JoyBundler
	public void deleteJoyBundler(Long id) {
		joyBundRepo.deleteById(id);
	}
}
