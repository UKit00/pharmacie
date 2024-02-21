package com.defitech.pharmacie.stock.service;

import com.defitech.pharmacie.core.entity.Commande;

import java.util.List;

public interface ICommandeService {


    Commande ajouter(Commande commande);




    List<Commande> voirTout();


    Commande voir(int id);


    String supprimer(int id);

    Commande modifier(int id, Commande commande);


}
