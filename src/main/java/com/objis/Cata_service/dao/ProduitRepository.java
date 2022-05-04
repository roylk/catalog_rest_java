/**
 * 
 */
package com.objis.Cata_service.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.objis.Cata_service.entities.Produit;

/**
 * @author R. KOUANI
 *
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select p from Produit p where p.id=:x")
	public Produit findbyId(@Param("x") Long id);

	@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> findProduit(@Param("x") String mc, Pageable pageable);

}
