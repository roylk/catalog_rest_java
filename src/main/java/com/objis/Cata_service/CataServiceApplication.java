package com.objis.Cata_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.objis.Cata_service.dao.ProduitRepository;
import com.objis.Cata_service.entities.Produit;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // en paramètre la désactivation de la sécurité
																		// automatique
public class CataServiceApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;// pour utiliser la deuxième methode de test

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataServiceApplication.class, args);
		/*
		 * ApplicationContext ctx = SpringApplication.run(CataServiceApplication.class,
		 * args); ProduitRepository produitRepository =
		 * ctx.getBean(ProduitRepository.class);
		 * 
		 * produitRepository.save(new Produit("LX", 2500, 23));
		 * produitRepository.save(new Produit("HP", 93000, 16));
		 * produitRepository.save(new Produit("NK", 8500, 6));
		 * produitRepository.save(new Produit("PB", 12500, 3));
		 * 
		 * List<Produit> prods = produitRepository.findAll(); prods.forEach(p ->
		 * System.out.println(p.getDesignation()));
		 */

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		
//		  produitRepository.save(new Produit("LX", 2500, 23));
//                  produitRepository.save(new Produit("HP", 93000, 16));
//		  produitRepository.save(new Produit("NK", 8500, 6));
//		  produitRepository.save(new Produit("PB", 12500, 3));
		 

		List<Produit> prods = produitRepository.findAll();
		prods.forEach(p -> System.out.println(p.getDesignation()));

	}

}
