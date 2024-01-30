package com.defitech.pharmacie.stock.service;

import com.defitech.pharmacie.core.entity.Fournisseur;

import java.util.List;

public interface IFournisseurService {

    Fournisseur ajouter(Fournisseur f);

    public Fournisseur modifier(Fournisseur f);

    public List<Fournisseur> voirTout();

    public Fournisseur voir(int id);

    public String supprimer(int id);

}

