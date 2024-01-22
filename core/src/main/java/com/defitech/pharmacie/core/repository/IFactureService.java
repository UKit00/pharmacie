package com.defitech.pharmacie.core.repository;

import com.defitech.pharmacie.core.entity.Facture;

import java.util.List;

public interface IFactureService {

    public Facture ajouter(Facture f);

    public Facture modifier(Facture f);

    public List<Facture> voirTout();

    public Facture voir(int id);

    public String supprimer(int id);
}
