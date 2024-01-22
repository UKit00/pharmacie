package com.defitech.pharmacie.core.service;

import com.defitech.pharmacie.core.entity.Produit;

import java.util.List;

public interface IProduitService {

    Produit ajouter(Produit p);

    public Produit modifier(Produit p);

    public List<Produit> voirTout();

    public Produit voir(int id);

    public String supprimer(int id);
    
}
