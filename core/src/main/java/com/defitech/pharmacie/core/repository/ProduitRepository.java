package com.defitech.pharmacie.core.repository;

import com.defitech.pharmacie.core.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
