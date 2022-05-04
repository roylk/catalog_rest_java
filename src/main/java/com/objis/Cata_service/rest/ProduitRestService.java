/**
 * 
 */
package com.objis.Cata_service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.objis.Cata_service.dao.ProduitRepository;
import com.objis.Cata_service.entities.Produit;

/**
 * @author R. KOUANI
 *
 */
@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;

	// liste des produits
	/*
	 * @RequestMapping(value = "/produits", method = RequestMethod.GET) public
	 * List<Produit> listeProduit() { return produitRepository.findAll(); }
	 */

	// liste des produits page par page
	@RequestMapping(value = "/produits", method = RequestMethod.GET)
	public Page<Produit> pageProduit(int page, int size) {
		return produitRepository.findAll(new PageRequest(page, size));
	}

	// liste des produits page par page
	@RequestMapping(value = "/rechercher", method = RequestMethod.GET)
	public Page<Produit> pageProduit(String mc, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {
		return produitRepository.findProduit("%" + mc + "%", new PageRequest(page, size));
	}

	// recherche par id
	@RequestMapping(value = "/produits/{id}", method = RequestMethod.GET)
	public Produit getProduit(@PathVariable("id") Long id) {
		return produitRepository.findbyId(id);
	}

	// enregistrement
	@RequestMapping(value = "/produits", method = RequestMethod.POST)
	public Produit saveProduit(@RequestBody Produit p) {
		return produitRepository.save(p);
	}

	// mise à jour
	@RequestMapping(value = "/produits/{id}", method = RequestMethod.PUT)
	public Produit updateProduit(@RequestBody Produit p, @PathVariable("id") Long id) {
		p.setId(id);
		return produitRepository.saveAndFlush(p);
	}

	@RequestMapping(value = "/produits/{id}", method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id) {
		produitRepository.deleteById(id);
	}

	/**
	 * 
	 */
	public ProduitRestService() {
		// TODO Auto-generated constructor stub
	}

}
