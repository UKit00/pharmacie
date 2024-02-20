package com.defitech.pharmacie.stock.repository;
import com.defitech.pharmacie.core.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
Fournisseur findByNomFournisseur(String nomFournisseur );
}
