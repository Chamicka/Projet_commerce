package fr.adaming.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Categorie;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IPanierService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/site")
@SessionAttributes(value = "sPanier", types = { Panier.class })
public class SiteControllerClient {

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

	@Autowired
	private IPanierService panService;

	/**
	 * @param panService
	 *            the panService to set
	 */
	public void setPanService(IPanierService panService) {
		this.panService = panService;
	}

	@ModelAttribute("sPanier")
	public Panier getPanier(HttpSession session) {

		if (session.getAttribute("sPanier") == null) {
			Panier panier = new Panier();
			session.setAttribute("sPanier", panier);
			return panier;
		} else {
			return (Panier) session.getAttribute("sPanier");
		}

	}

	// Welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePersonne(ModelMap model, HttpSession session) {

		// attributs catégories
		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);

		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));

		return "accueilClient";
	}

	// afficher les produits/catégories
	@RequestMapping(value = "/produitsClient/{idC}", method = RequestMethod.GET)
	public String afficherListeProduits(ModelMap model, @PathVariable("idC") long cId, HttpSession session) {

		// attributs catégorie
		model.addAttribute("idCat", cId);
		List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(cId));
		model.addAttribute("listeProds", listeProd);

		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));

		// if (model.get("mPanier") == null) {
		// System.out.println("dans le if panier");
		// Panier panier = new Panier();
		// model.addAttribute("mPanier", panier);
		// model.getClass();
		// }
		return "produitsClient";
	}

	@RequestMapping(value = "/categoriesClient", method = RequestMethod.GET)
	public String afficherListeCategories(ModelMap model) {

		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);
		return "accueilClient";
	}

	// ajouter au panier
	@RequestMapping(value = "/ajouterPanier/{idP}/{idC}", method = RequestMethod.GET)
	public String ajouterAuPanier(ModelMap model, @PathVariable("idP") long pId, @PathVariable("idC") long cId,
			HttpSession session) {

		// attributs catégorie
		model.addAttribute("idCat", cId);
		List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(cId));
		model.addAttribute("listeProds", listeProd);

		//ajouter au panier
		Panier p_rec = pService.ajouterAuPanier(pId, getPanier(session), 1);
		session.setAttribute("sPanier", p_rec);

		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));

		return "produitsClient";
	}

	@RequestMapping(value="/supprimerProduitPanier/{idC}/{idP}", method =RequestMethod.GET)
	public String supprimerProduitPanier(ModelMap model,@PathVariable("idC") long cId, @PathVariable("idP") long pId, HttpSession session) {
		
		// attributs catégorie
		model.addAttribute("idCat", cId);
		List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(cId));
		model.addAttribute("listeProds", listeProd);
		
		//supprimer la ligne
		session.setAttribute("sPanier", panService.supprimerLigne(getPanier(session), pId));
		
		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));
		
		return "produitsClient";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
