package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.service.ICategorieService;

@Controller
public class LoginController {
	
	@Autowired
	private ICategorieService cService;

	/**
	 * @param cService
	 *            the cService to set
	 */
	public void setcService(ICategorieService cService) {
		this.cService = cService;
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String affichePageLogin() {
		return "login" ;
	}
	
	@RequestMapping(value="/loginClient", method=RequestMethod.GET)
	public String affichePageLoginClient() {
		return "loginClient" ;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutMethod(ModelMap model) {
		model.addAttribute("listeCats", cService.getAllCategories());
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
