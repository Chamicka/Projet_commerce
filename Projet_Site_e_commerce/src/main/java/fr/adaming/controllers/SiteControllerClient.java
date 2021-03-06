package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Array;

import fr.adaming.model.Admin;
import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IClientService;
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

	@Autowired
	private IClientService clService;

	/**
	 * @param clService
	 *            the clService to set
	 */
	public void setClService(IClientService clService) {
		this.clService = clService;
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

	@ModelAttribute("sIdCat")
	public long getIdCat(HttpSession session) {

		if (session.getAttribute("sIdCat") == null) {
			long idCat = 0;
			session.setAttribute("sIdCat", idCat);
			return idCat;
		} else {
			return (long) session.getAttribute("sIdCat");
		}

	}

	@ModelAttribute("mClient")
	public Client getmClient(HttpSession session) {

		if (session.getAttribute("mClient") == null) {
			session.setAttribute("mClient", null);
			return null;
		} else {
			return (Client) session.getAttribute("mClient");
		}

	}

	// Welcome
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePersonne(ModelMap model, HttpSession session) {

		// attributs cat�gories
		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);

		model.addAttribute("idCat", getIdCat(session));

		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));
		model.addAttribute("word", new Produit());
		return "accueilClient";
	}

	// afficher les produits/cat�gories
	@RequestMapping(value = "/produitsClient/{idC}", method = RequestMethod.GET)
	public String afficherListeProduits(ModelMap model, @PathVariable("idC") long cId, HttpSession session) {

		// attributs cat�gorie
		model.addAttribute("idCat", cId);
		session.setAttribute("sIdCat", cId);
		List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(cId));
		model.addAttribute("listeProds", listeProd);

		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));
		model.addAttribute("word", new Produit());
		return "produitsClient";
	}

	@RequestMapping(value = "/categoriesClient", method = RequestMethod.GET)
	public String afficherListeCategories(ModelMap model) {

		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);
		model.addAttribute("word", new Produit());
		return "accueilClient";
	}

	// ajouter au panier
	@RequestMapping(value = "/ajouterPanier/{idP}", method = RequestMethod.GET)
	public String ajouterAuPanier(ModelMap model, @PathVariable("idP") long pId, HttpSession session) {

		if (pService.getProduitById(pId).getQuantite() == 0) {
			model.addAttribute("dispo", "Le produit n'est plus disponible :/");
			session.setAttribute("sPanier", getPanier(session));
			model.addAttribute("listeLignes", getPanier(session).getLignesCommande());
			model.addAttribute("total", panService.calculerTotal(getPanier(session)));
			// attributs cat�gorie
			if (getIdCat(session) != 0) {
				model.addAttribute("idCat", getIdCat(session));
				List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(getIdCat(session)));
				model.addAttribute("listeProds", listeProd);
			}
			model.addAttribute("word", new Produit());
			return "produitsClient";
		} else {
			// ajouter au panier

			// v�rifier si le produit est d�j� dans le panier
			Panier panier = getPanier(session);
			List<LigneCommande> lignes = panier.getLignesCommande();
			boolean dansPanier = false;
			if (lignes != null) {
				for (int i = 0; i < lignes.size(); i++) {
					if (lignes.get(i).getProduit().getId() == pService.getProduitById(pId).getId()) {
						panier = pService.ajouterAuPanierPlus(panier, i);
						dansPanier = true;
					}
				}
			}

			// si on l'a trouv�, on a juste rajout� +1 � sa quantit� et on
			// ajoute le
			// panier � la session, sinon on ajoute une nouvelle ligne au panier
			if (dansPanier) {
				session.setAttribute("sPanier", panier);
			} else {
				Panier p_rec = pService.ajouterAuPanier(pId, getPanier(session), 1);
				session.setAttribute("sPanier", p_rec);
			}

			// attributs panier
			Panier panier_final = getPanier(session);
			model.addAttribute("listeLignes", panier_final.getLignesCommande());
			model.addAttribute("total", panService.calculerTotal(panier_final));

			// attributs cat�gorie
			if (getIdCat(session) != 0) {
				model.addAttribute("idCat", getIdCat(session));
				List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(getIdCat(session)));
				model.addAttribute("listeProds", listeProd);
			}
			model.addAttribute("word", new Produit());
			return "produitsClient";
		}

	}

	// ajouter au panier
	@RequestMapping(value = "/ajouterPanierAccueil/{idP}", method = RequestMethod.GET)
	public String ajouterAuPanierAccueil(ModelMap model, @PathVariable("idP") long pId, HttpSession session) {

		// attributs cat�gories
		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);

		if (pService.getProduitById(pId).getQuantite() == 0) {
			model.addAttribute("dispo", "Le produit n'est plus disponible :/");
			session.setAttribute("sPanier", getPanier(session));
			model.addAttribute("listeLignes", getPanier(session).getLignesCommande());
			model.addAttribute("total", panService.calculerTotal(getPanier(session)));
			model.addAttribute("word", new Produit());
			return "produitsClient";
		} else {

			// ajouter au panier

			// v�rifier si le produit est d�j� dans le panier
			Panier panier = getPanier(session);
			List<LigneCommande> lignes = panier.getLignesCommande();
			boolean dansPanier = false;
			if (lignes != null) {
				for (int i = 0; i < lignes.size(); i++) {
					if (lignes.get(i).getProduit().getId() == pService.getProduitById(pId).getId()) {
						panier = pService.ajouterAuPanierPlus(panier, i);
						dansPanier = true;
					}
				}
			}

			// si on l'a trouv�, on a juste rajout� +1 � sa quantit� et on
			// ajoute le
			// panier � la session, sinon on ajoute une nouvelle ligne au panier
			if (dansPanier) {
				session.setAttribute("sPanier", panier);
			} else {
				Panier p_rec = pService.ajouterAuPanier(pId, getPanier(session), 1);
				session.setAttribute("sPanier", p_rec);
			}

			// attributs panier
			Panier panier_final = getPanier(session);
			model.addAttribute("listeLignes", panier_final.getLignesCommande());
			model.addAttribute("total", panService.calculerTotal(panier_final));
			model.addAttribute("word", new Produit());
			return "accueilClient";
		}
	}

	@RequestMapping(value = "/supprimerProduitPanier/{idP}", method = RequestMethod.GET)
	public String supprimerProduitPanier(ModelMap model, @PathVariable("idP") long pId, HttpSession session) {

		session.setAttribute("sPanier", panService.supprimerLigne(getPanier(session), pId));

		// attributs panier
		Panier panier_final = getPanier(session);
		model.addAttribute("listeLignes", panier_final.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier_final));

		// attributs cat�gorie
		model.addAttribute("idCat", getIdCat(session));
		List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(getIdCat(session)));
		model.addAttribute("listeProds", listeProd);
		model.addAttribute("word", new Produit());
		return "produitsClient";
	}

	@RequestMapping(value = "/moinsProduitPanier/{idP}", method = RequestMethod.GET)
	public String moinsProduitPanier(ModelMap model, @PathVariable("idP") long pId, HttpSession session) {

		Panier panier = getPanier(session);
		List<LigneCommande> lignes = panier.getLignesCommande();
		for (int i = 0; i < lignes.size(); i++) {
			if (lignes.get(i).getProduit().getId() == pService.getProduitById(pId).getId()) {
				session.setAttribute("sPanier", panService.supprimerMoins(getPanier(session), i));
			}
		}
		// supprimer la ligne

		// attributs panier
		Panier panier_final = getPanier(session);
		model.addAttribute("listeLignes", panier_final.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier_final));

		// attributs cat�gorie
		model.addAttribute("idCat", getIdCat(session));
		List<Produit> listeProd = pService.getAllProduitsByCat(cService.getCategorieById(getIdCat(session)));
		model.addAttribute("listeProds", listeProd);
		model.addAttribute("word", new Produit());
		return "produitsClient";
	}

	@RequestMapping(value = "/supprimerProduitPanierAccueil/{idP}", method = RequestMethod.GET)
	public String supprimerProduitPanierAccueil(ModelMap model, @PathVariable("idP") long pId, HttpSession session) {

		// attributs cat�gories
		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);

		// supprimer la ligne
		session.setAttribute("sPanier", panService.supprimerLigne(getPanier(session), pId));

		// attributs panier
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));
		model.addAttribute("word", new Produit());
		return "accueilClient";
	}

	@RequestMapping(value = "/moinsProduitPanierAccueil/{idP}", method = RequestMethod.GET)
	public String moinsProduitPanierAccueil(ModelMap model, @PathVariable("idP") long pId, HttpSession session) {

		// attributs cat�gories
		List<Categorie> listeCat = cService.getAllCategories();
		model.addAttribute("listeCats", listeCat);

		Panier panier = getPanier(session);
		List<LigneCommande> lignes = panier.getLignesCommande();
		for (int i = 0; i < lignes.size(); i++) {
			if (lignes.get(i).getProduit().getId() == pService.getProduitById(pId).getId()) {
				session.setAttribute("sPanier", panService.supprimerMoins(getPanier(session), i));
			}
		}
		// supprimer la ligne

		// attributs panier
		Panier panier_final = getPanier(session);
		model.addAttribute("listeLignes", panier_final.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier_final));
		model.addAttribute("word", new Produit());
		return "accueilClient";
	}


	@RequestMapping(value = "/formulaireInscription", method = RequestMethod.GET)
	public ModelAndView afficherFormInscription(HttpSession session) {

		return new ModelAndView("inscription", "mClient", new Client());
	}

	@RequestMapping(value = "/enregistrerInscription", method = RequestMethod.POST)
	public String enregistrerClient(ModelMap model, @ModelAttribute("mClient") Client client, HttpSession session) {
		System.out.println("dans le controller");
		System.out.println("client : " + client);
		if (client.getId() == null) {
			System.out.println("dans le if");
			clService.ajouterClient(client);
		} else {
			System.out.println("dans le else");
			clService.modifierClient(client);
		}

		System.out.println("avant le panier");
		Panier panier_final = getPanier(session);
		model.addAttribute("listeLignes", panier_final.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier_final));
		session.setAttribute("mClient", client);
		model.addAttribute("word", new Produit());
		return "accueilClient";
	}

	@RequestMapping(value = "/validerCommande", method = RequestMethod.GET)
	public String validerCommande(ModelMap model, HttpSession session) {

		Panier panier = getPanier(session);
		int total = panService.calculerTotal(panier);
		Client client = getmClient(session);
		model.addAttribute("msg",
				"La facture pour votre commande pour un total de " + total + "euros vous a bien �t� envoy�e au "
						+ client.getAdresse() + ". Merci et � tr�s vite monsieur ou madame " + client.getNom());
		session.setAttribute("sPanier", null);
		model.addAttribute("word", new Produit());
		return "accueilClient";
	}


	
	@RequestMapping(value="/trouverByKeyWord", method=RequestMethod.POST)
	public String trouverByKeyWord(ModelMap model, @ModelAttribute("word") Produit word, HttpSession session){
		
		
		System.out.println("le mot est : "  + word.getDescription());
		
		model.addAttribute("listeProds", pService.getByKeyWord(word.getDescription()));
		Panier panier = getPanier(session);
		model.addAttribute("listeLignes", panier.getLignesCommande());
		model.addAttribute("total", panService.calculerTotal(panier));
		return "produitsClient";
	}
	

}
