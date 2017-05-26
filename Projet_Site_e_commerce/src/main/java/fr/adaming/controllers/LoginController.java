package fr.adaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String affichePageLogin() {
		return "login" ;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutMethod() {
		return "accueilClient"; 
	}
	
	@RequestMapping(value="/denied", method=RequestMethod.GET)
	public String deniedMethod() {
		return "denied"; 
	}
	
	@RequestMapping(value="/loginEchec", method=RequestMethod.GET)
	public String echecLogin(ModelMap model) {
		model.addAttribute("erreur", "true");
		return "login";
	}
}
