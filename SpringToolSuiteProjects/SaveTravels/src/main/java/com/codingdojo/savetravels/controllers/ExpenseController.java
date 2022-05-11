package com.codingdojo.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
	// Injecting the expense service
	private final ExpenseService expenseService;
	
	// Constructor for service
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/")
	public String dashboard(Model model, @ModelAttribute("expense") Expense expense) {
		
		// send out all Expenses to the JSP using Model model
		model.addAttribute("allExpenses", expenseService.allExpenses());
		return "index.jsp";
	}
	
	// @RequestParam(value="expenseName") String expenseName, @RequestParam(value="vendor") String vendor, @RequestParam(value="amount") Double amount, @RequestParam(value="description") String description 
	
	// Process the post to create an Expense
	// 				   this means we will validate the values in our model against the model Expense and then check on those results. This also allows us to not use a bunch of request params like I saved above
	@PostMapping("/processExpense")
	public String show(Model model, @Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			// you cannot redirect because the error messages created in the model will not apppear. So to include the table (since my create new page is on the same jsp as the table, i need to bring over the table model attributes
			model.addAttribute("allExpenses", expenseService.allExpenses());
			return "index.jsp";
		}else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
	
	@GetMapping("/editExpense/{id}")
	public String editExpense( @PathVariable("id") Long id, @ModelAttribute("expense") Expense expense, Model model) {
		
		model.addAttribute("expense", expenseService.findExpense(id));
		return "editExpense.jsp";
		
	}
	
	// ----- Use PUT on db updates ----- 
	// post is used to create a resource while put is used to create or replace a resource
	@PutMapping("/editedExpense/{id}")
	public String editedExpense( @Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("expense", expenseService.findExpense(id));
			// you cannot redirect because the error messages created in the model will not apppear. So to include the table (since my create new page is on the same jsp as the table, i need to bring over the table model attributes
			return "editExpense.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
	
	@GetMapping("/oneExpense/{id}")
	public String oneExpense(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "oneExpense.jsp";
	}
	
	@GetMapping("/goBack")
	public String goback() {
		return "redirect:/";
	}
}
