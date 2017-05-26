package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
public class SiteControllerClient {

	@Autowired
	private IProduitService pService;

	/**
	 * @param pService the pService to set
	 */
	public void setpService(IProduitService pService) {
		this.pService = pService;
	}
	
	@Autowired
	private ICategorieService cService;

	/**
	 * @param cService
	 *            the cService to set
	 */
	public void setcService(ICategorieService cService) {
		this.cService = cService;
	}	

		
		//afficher les produits/catégories
		@RequestMapping(value = "/produitsClient", method = RequestMethod.GET)
		public String afficherListeProduits(ModelMap model) {

			List<Produit> listeProd = pService.getAllProduits();
			model.addAttribute("listeProds", listeProd);
			return "produitsClient";
		}

		@RequestMapping(value = "/categoriesClient", method = RequestMethod.GET)
		public String afficherListeCategories(ModelMap model) {

			List<Categorie> listeCat = cService.getAllCategories();
			model.addAttribute("listeCats", listeCat);
			return "accueilClient";
		}
		
		
}
