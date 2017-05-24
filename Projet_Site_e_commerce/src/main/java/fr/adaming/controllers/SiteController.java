package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/site")
public class SiteController {

	@Autowired
	private IProduitService pService;

	/**
	 * @param pService
	 *            the pService to set
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

	//Welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePersonne(ModelMap model) {
		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);
		return "accueil";
	}

	
	//afficher les produits/catégories
	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	public String afficherListeProduits(ModelMap model) {

		List<Produit> listeProd = pService.getAllProduits();
		model.addAttribute("listeProds", listeProd);
		return "produits";
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String afficherListeCategories(ModelMap model) {

		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);
		return "accueil";
	}
	
	//ajouter un produit
	@RequestMapping(value="/ajouterProduit", method = RequestMethod.GET)
	public ModelAndView afficherFormAjoutProduit() {
		return new ModelAndView("ajouterProduit", "mProduit", new Produit());
	}
	
	@RequestMapping(value="/insererProduit", method = RequestMethod.POST)
	public String soumettreFormAjoutProduit(ModelMap model, @ModelAttribute("mProduit") Produit pProduit) {
		
		if (pProduit.getId() == null){
			pService.ajouterProduit(pProduit) ;
		} else {
			pService.modifierProduit(pProduit) ;
		}
		model.addAttribute("listeProds", pService.getAllProduits());
		return "produits" ;
	}
	
	//ajouter une catégorie
	@RequestMapping(value="/ajouterCategorie", method = RequestMethod.GET)
	public ModelAndView afficherFormAjoutCategorie() {
		return new ModelAndView("ajouterCategorie", "mCategorie", new Categorie());
	}
	
	@RequestMapping(value="/insererCategorie", method = RequestMethod.POST)
	public String soumettreFormAjoutCategorie(ModelMap model, @ModelAttribute("mCategorie") Categorie pCategorie) {
		if (pCategorie.getId() == null){
			cService.ajouterCategorie(pCategorie) ;
		} else {
			cService.modifierCategorie(pCategorie) ;
		}
		model.addAttribute("listeCats", cService.getAllCategories());
		return "accueil" ;
	}
	
	//supprimer un produit/une catégorie
	@RequestMapping(value="/supprimerProduit/{idP}", method = RequestMethod.GET)
	public String supprimerProduit(ModelMap model, @PathVariable("idP") long pId) {
		pService.supprimerProduit(pService.getProduitById(pId));
		model.addAttribute("listeProds", pService.getAllProduits());
		
		return "produits" ;
	}
	
	@RequestMapping(value="/supprimerCategorie/{idC}", method = RequestMethod.GET)
	public String supprimerCategorie(ModelMap model, @PathVariable("idC") long cId) {
		System.out.println("dans le controller suppr");
		cService.supprimerCategorie(cService.getCategorieById(cId));
		model.addAttribute("listeCats", cService.getAllCategories());
		
		return "accueil" ;
	}
	
	//modifier un produit/une catégorie
	@RequestMapping(value="/modifierProduit", method=RequestMethod.GET)
	public ModelAndView modifierProduit(@RequestParam("idP") long pId) {
		Produit p_rec = pService.getProduitById(pId);
		return new ModelAndView("ajouterProduit", "mProduit", p_rec );
	}
	
	@RequestMapping(value="/modifierCategorie", method=RequestMethod.GET)
	public ModelAndView modifierCategorie(@RequestParam("idC") long cId) {
		Categorie c_rec = cService.getCategorieById(cId);
		return new ModelAndView("ajouterCategorie", "mCategorie", c_rec );
	}
	
}
