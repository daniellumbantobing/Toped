package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.Item;
import com.example.demo.jpa.ItemRepository;
import com.example.demo.jpa.Role;
import com.example.demo.jpa.RoleRepository;
import com.example.demo.jpa.User;
import com.example.demo.jpa.UserRepository;





@RestController
public class LoginController {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	@Autowired 
	ItemRepository itemRepository;
	
	public LoginController(UserRepository userRepository, RoleRepository  roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("user", new User());
		return mv;
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("user", new User());
		return mv;
	}
	
	@GetMapping("/user")
	public ModelAndView user() {
		List<Item> items = itemRepository.findAll();
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("items", items);
		
		return mv;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView loginSubmit(@ModelAttribute User user, BindingResult bindingResult, Model model) {
		
		  model.addAttribute("user", user);
	        User userRole = userRepository.findByUsername(user.getUsername());
	   
	        System.out.println(userRole.getRoleid());

	        if(userRole.getRoleid() == 1){
	            return new ModelAndView("redirect:/item");
	        }
	        if(userRole.getRoleid() == 2){
	            return new ModelAndView("redirect:/user");
	        }else{
	            return new ModelAndView("redirect:/login");
	        }
	    }
	@GetMapping("/registration")
	public ModelAndView registration() {
		List<Role> listRoles = roleRepository.findAll();
		System.out.println(listRoles.size());
		ModelAndView mv = new ModelAndView("registration"); 
		mv.addObject("roles", listRoles); 
		mv.addObject("user", new User());

		return mv;
}
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ModelAndView registrationSubmit(@ModelAttribute User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Error");
		}
		model.addAttribute("user", user);
		userRepository.save(user);
		
		 return new ModelAndView("redirect:/login");
	}
}
