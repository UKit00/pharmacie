package com.defitech.pharmacie.stock.service;

import com.defitech.pharmacie.core.entity.Produit;
import com.defitech.pharmacie.stock.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService implements IProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit ajouter(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit modifier(Produit p) {
        int id = p.getId();
        Optional<Produit> optProduit = produitRepository.findById(id);
        return optProduit.map(produit -> {
            produit.setNomProduit(p.getNomProduit());
            produit.setDescription(p.getDescription());
            produit.setPrixUnitaire(p.getPrixUnitaire());
            produit.setQte(p.getQte());
            return produitRepository.save(produit);
        }).orElseThrow(() -> new RuntimeException("Produit non trouvée avec l'ID : " + id));
    }

    @Override
    public List<Produit> voirTout() {
        return produitRepository.findAll();
    }

    @Override
    public Produit voir(int id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit non trouver pour voir"));
    }

    @Override
    public String supprimer(int id) {
        produitRepository.deleteById(id);
        return "Bien supprimer";
    }
}
