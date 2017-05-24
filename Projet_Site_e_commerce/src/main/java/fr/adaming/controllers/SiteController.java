package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private IProduitService pService ;

	/**
	 * @param pService the pService to set
	 */
	public void setpService(IProduitService pService) {
		this.pService = pService;
	}
	
	@Autowired
	private ICategorieService cService ;

	/**
	 * @param cService the cService to set
	 */
	public void setcService(ICategorieService cService) {
		this.cService = cService;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePersonne(ModelMap model) {

		return "accueil";
	}
}






















